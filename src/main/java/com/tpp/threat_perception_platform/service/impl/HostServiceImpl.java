package com.tpp.threat_perception_platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tpp.threat_perception_platform.dao.HostMapper;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Host;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {
    @Autowired
    private HostMapper hostMapper;
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
}
