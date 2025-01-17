package com.tpp.threat_perception_platform.param;

import com.tpp.threat_perception_platform.pojo.Vulnerability;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreatParam {
    private String mac;
    private String hostname;
    //1表示需要探测，0表示不需要探测
    private Integer hotfix=0;  //补丁探测
    private Integer vulnerability=0;  //漏洞探测
    private Integer weakPwd=0;  //弱密码探测
    private Integer app=0;      //应用风险探测
    private Integer system=0;      //系统风险探测

    //漏洞列表
    private List<Vulnerability> vulDbs;

    //类型
    private String type="threat";
}
