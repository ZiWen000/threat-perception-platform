package com.tpp.threat_perception_platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tpp.threat_perception_platform.dao.ProcessMapper;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.App;
import com.tpp.threat_perception_platform.pojo.Process;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessMapper processMapper;

    public int add(List<Process> processList) {
        //先删再添加
        processMapper.deleteByMac(processList.get(0).getMac());
        return processMapper.insertSelectiveBatch(processList);
    }


    public ResponseResult list(MyParam myParam) {
        PageHelper.startPage(myParam.getPage(), myParam.getLimit());
        List<Process> processList = processMapper.findAll(myParam);
        PageInfo<Process> pageInfo = new PageInfo<>(processList);
        return new ResponseResult(pageInfo.getTotal(), pageInfo.getList());
    }
}
