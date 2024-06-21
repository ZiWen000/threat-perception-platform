package com.tpp.threat_perception_platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.log.Log;
import com.tpp.threat_perception_platform.dao.LogsMapper;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Logs;

import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsServiceImpl implements LogsService {

    @Autowired
    private LogsMapper logsMapper;

    public ResponseResult list(MyParam myParam) {
        PageHelper.startPage(myParam.getPage(), myParam.getLimit());
        List<Logs> logsList = logsMapper.findAll(myParam);
        PageInfo<Logs> pageInfo = new PageInfo<>(logsList);
        return new ResponseResult(pageInfo.getTotal(), pageInfo.getList());
    }

    public int add(List<Logs> logsList) {
        //1. 需要将旧数据删除，通过mac地址删除
        logsMapper.deleteByMac(logsList.get(0).getMac());
        //2. 添加新数据
        return logsMapper.insertSelectiveBatch(logsList);
    }
}
