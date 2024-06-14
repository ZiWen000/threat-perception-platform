package com.tpp.threat_perception_platform.service;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Process;
import com.tpp.threat_perception_platform.response.ResponseResult;

import java.util.List;

public interface ProcessService {
    int add(List<Process> processList);

    ResponseResult list(MyParam myParam);
}
