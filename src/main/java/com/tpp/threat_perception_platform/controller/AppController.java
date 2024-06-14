package com.tpp.threat_perception_platform.controller;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.AccountService;
import com.tpp.threat_perception_platform.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    private AppService appService;

    /**
     * 应用信息列表分页查询
     * @param myParam
     * @return
     */
    @PostMapping("/list")
    public ResponseResult list(MyParam myParam){
        return appService.list(myParam);
    }
}
