package com.tpp.threat_perception_platform.service;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Hotfix;
import com.tpp.threat_perception_platform.response.ResponseResult;


import java.util.List;

public interface HotfixService {
    int add(List<Hotfix> hotfixList);

    ResponseResult list(MyParam myParam);
}
