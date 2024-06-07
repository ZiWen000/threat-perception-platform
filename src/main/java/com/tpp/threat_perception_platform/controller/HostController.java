package com.tpp.threat_perception_platform.controller;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/host")
public class HostController {

    @Autowired
    private HostService hostService;

    /**
     * 获取主机列表
     * @param param
     * @return
     */
    @PostMapping("/list")
    public ResponseResult list(MyParam param){
        return hostService.list(param);
    }
}
