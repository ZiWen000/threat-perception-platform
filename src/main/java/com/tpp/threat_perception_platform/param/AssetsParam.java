package com.tpp.threat_perception_platform.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetsParam {
    private String mac;
    private String hostname;
    //1表示需要探测，0表示不需要探测
    private Integer account=0;  //账号探测
    private Integer service=0;  //服务探测
    private Integer process=0;  //进程探测
    private Integer app=0;      //应用探测

    //类型
    private String type="assets";
}
