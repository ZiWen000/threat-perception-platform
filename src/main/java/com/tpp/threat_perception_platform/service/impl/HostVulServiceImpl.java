package com.tpp.threat_perception_platform.service.impl;

import com.tpp.threat_perception_platform.dao.HostVulMapper;
import com.tpp.threat_perception_platform.pojo.HostVul;
import com.tpp.threat_perception_platform.service.HostVulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostVulServiceImpl implements HostVulService {

    @Autowired
    private HostVulMapper hostVulMapper;

    public int add(List<HostVul> hostVulList) {
        hostVulMapper.deleteByMac(hostVulList.get(0).getMac());
        return hostVulMapper.insertSelectiveBatch(hostVulList);
    }
}
