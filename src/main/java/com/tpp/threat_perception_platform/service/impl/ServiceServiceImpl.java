package com.tpp.threat_perception_platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.App;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private com.tpp.threat_perception_platform.dao.ServiceMapper serviceMapper;

    public ResponseResult list(MyParam myParam) {
        PageHelper.startPage(myParam.getPage(), myParam.getLimit());
        List<com.tpp.threat_perception_platform.pojo.Service> serviceList = serviceMapper.findAll(myParam);
        PageInfo<com.tpp.threat_perception_platform.pojo.Service> pageInfo = new PageInfo<>(serviceList);
        return new ResponseResult(pageInfo.getTotal(), pageInfo.getList());
    }

    public int add(List<com.tpp.threat_perception_platform.pojo.Service> serviceList) {
        //1. 需要将旧数据删除，通过mac地址删除
        serviceMapper.deleteByMac(serviceList.get(0).getMac());
        //2. 添加新数据
        return serviceMapper.insertSelectiveBatch(serviceList);
    }
}
