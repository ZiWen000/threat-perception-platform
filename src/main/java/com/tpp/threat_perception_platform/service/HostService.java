package com.tpp.threat_perception_platform.service;

import com.tpp.threat_perception_platform.param.AssetsParam;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Host;
import com.tpp.threat_perception_platform.response.ResponseResult;

public interface HostService {
    int save(Host host);

    /**
     * 获取主机列表
     * @param param
     * @return
     */
    ResponseResult list(MyParam param);

    /**
     * 不分页的获取所有主机列表
     * @return
     */
    ResponseResult list();

    int updateByMac(Host host);

    /**
     * 资产探测逻辑处理
     * @param param
     * @return
     */
    ResponseResult assetsGet(AssetsParam param);
}
