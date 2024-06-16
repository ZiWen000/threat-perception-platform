package com.tpp.threat_perception_platform.controller;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.HotfixService;
import com.tpp.threat_perception_platform.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotfix")
public class HotfixController {
    @Autowired
    private HotfixService hotfixService;

    /**
     * 补丁探测信息分页查询
     * @param myParam
     * @return
     */
    @PostMapping("/list")
    public ResponseResult list(MyParam myParam){
        return hotfixService.list(myParam);
    }
}