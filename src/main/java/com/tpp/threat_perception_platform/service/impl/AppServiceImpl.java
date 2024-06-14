package com.tpp.threat_perception_platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tpp.threat_perception_platform.dao.AppMapper;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Account;
import com.tpp.threat_perception_platform.pojo.App;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.AppService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private AppMapper appMapper;

    public int add(List<App> appList) {
        //1. 需要将旧数据删除，通过mac地址删除
        appMapper.deleteByMac(appList.get(0).getMac());
        //2. 添加新数据
        return appMapper.insertSelectiveBatch(appList);
    }

    public ResponseResult list(MyParam myParam) {
        PageHelper.startPage(myParam.getPage(), myParam.getLimit());
        List<App> appList = appMapper.findAll(myParam);
        PageInfo<App> pageInfo = new PageInfo<>(appList);
        return new ResponseResult(pageInfo.getTotal(), pageInfo.getList());
    }
}
