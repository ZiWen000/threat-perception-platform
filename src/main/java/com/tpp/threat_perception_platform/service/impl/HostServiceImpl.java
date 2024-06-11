package com.tpp.threat_perception_platform.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tpp.threat_perception_platform.dao.HostMapper;
import com.tpp.threat_perception_platform.param.AssetsParam;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Host;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.HostService;
import com.tpp.threat_perception_platform.service.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {
    @Autowired
    private HostMapper hostMapper;

    @Autowired
    private RabbitmqService rabbitmqService;
    public int save(Host host) {
        //主机入库前，先查询有没有对应的主机
        //根据mac地址来查询
        Host db_host = hostMapper.selectByMac(host.getMac());
        if(db_host !=null){
            //如果不为空，则更新
            host.setUpdateTime(new java.util.Date());
            host.setHostId(db_host.getHostId());
            return hostMapper.updateByPrimaryKey(host);
        }
        //当主机上线的时候，动态的创建队列
        String exchange = "agent_exchange";
        //agent_mac地址_queue
        //先处理mac地址
        String mac = host.getMac().replace(":","");
        String queueName = "agent_"+mac+"_queue";
        String routingKey = mac;
        rabbitmqService.createAgentQueue(exchange,queueName,routingKey);


        //没有对应的主机，则新增
        host.setStatus(1);
        host.setCreateTime(new java.util.Date());
        host.setUpdateTime(new java.util.Date());
        return hostMapper.insert(host);
    }

    /**
     * 获取主机列表
     * @param param
     * @return
     */
    public ResponseResult list(MyParam param) {
        // 分页查询
        PageHelper.startPage(param.getPage(), param.getLimit());
        //做一次查询
        List<Host> hosts = hostMapper.findAll(param);
        PageInfo<Host> pageInfo = new PageInfo<>(hosts);

        return new ResponseResult(pageInfo.getTotal(), pageInfo.getList());
    }

    public int updateByMac(Host host) {
        host.setUpdateTime(new java.util.Date());
        return hostMapper.updateByMacSelective(host);
    }

    /**
     * 资产探测逻辑处理
     * @param param
     * @return
     */
    public ResponseResult assetsGet(AssetsParam param) {
        //1. 判断主机是否在线
        //当前时间-更新时间 > 4 就表示已经离线
        Host db_host = hostMapper.selectByMac(param.getMac());
        long delta = System.currentTimeMillis() - db_host.getUpdateTime().getTime();
        if(delta > 4*1000){
            //主机下线，需要更新
            Host host = new Host();
            host.setStatus(0);
            host.setMac(param.getMac());
            hostMapper.updateByMacSelective(host);
            return new ResponseResult(1005,"主机离线，请重新上线！");
        }
        //2. 将对象转换成json字符串
        String data = JSON.toJSONString(param);
        //3. 将JSON字符串发送到对应队列
        String exchange = "agent_exchange";
        String routingKey = param.getMac().replace(":","");
        rabbitmqService.sendMessage(exchange,routingKey,data);
        return new ResponseResult(0,"探测命令请求成功，请稍后查看");
    }
}
