package com.tpp.threat_perception_platform.service;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Service;
import com.tpp.threat_perception_platform.response.ResponseResult;

import java.util.List;


public interface ServiceService {
    ResponseResult list(MyParam myParam);

    int add(List<Service> serviceList);
}