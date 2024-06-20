package com.tpp.threat_perception_platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tpp.threat_perception_platform.dao.WeakPwdMapper;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.WeakPwd;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.WeakPwdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeakPwdServiceImpl implements WeakPwdService {
    @Autowired
    private WeakPwdMapper weakPwdMapper;

    public ResponseResult list(MyParam myParam) {
        PageHelper.startPage(myParam.getPage(), myParam.getLimit());
        List<WeakPwd> weakPwdList = weakPwdMapper.findAll(myParam);
        PageInfo<WeakPwd> pageInfo = new PageInfo<>(weakPwdList);
        return new ResponseResult(pageInfo.getTotal(), pageInfo.getList());
    }

    public int add(List<WeakPwd> weakPwdList) {
        //1. 需要将旧数据删除，通过mac地址删除
        weakPwdMapper.deleteByMac(weakPwdList.get(0).getMac());
        //2. 添加新数据
        return weakPwdMapper.insertSelectiveBatch(weakPwdList);
    }
}
