package com.tpp.threat_perception_platform.controller;

import com.tpp.threat_perception_platform.param.AssetsParam;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.param.ThreatParam;
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

    /**
     * 获取主机列表,无分页
     * @param param
     * @return
     */
    @PostMapping("/list/all")
    public ResponseResult list(){
        return hostService.list();
    }


    /**
     * 资产探测
     * @param param
     * @return
     */
    @PostMapping("/assets/get")
    public ResponseResult assetsGet(@RequestBody AssetsParam param){
        System.out.println(param);
        return hostService.assetsGet(param);
    }

    @PostMapping("/threat/get")
    public ResponseResult threatGet(@RequestBody ThreatParam param){
        System.out.println(param);
        return hostService.threatGet(param);
    }
}
