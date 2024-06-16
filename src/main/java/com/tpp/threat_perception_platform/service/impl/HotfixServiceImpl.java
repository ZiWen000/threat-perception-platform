package com.tpp.threat_perception_platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tpp.threat_perception_platform.dao.HotfixMapper;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.App;
import com.tpp.threat_perception_platform.pojo.Hotfix;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.HotfixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotfixServiceImpl implements HotfixService {

    @Autowired
    private HotfixMapper hotfixMapper;

    public int add(List<Hotfix> hotfixList) {
        //1. 需要将旧数据删除，通过mac地址删除
        hotfixMapper.deleteByMac(hotfixList.get(0).getMac());
        //2. 添加新数据
        return hotfixMapper.insertSelectiveBatch(hotfixList);
    }

    public ResponseResult list(MyParam myParam) {
        PageHelper.startPage(myParam.getPage(), myParam.getLimit());
        List<Hotfix> hotfixList = hotfixMapper.findAll(myParam);
        PageInfo<Hotfix> pageInfo = new PageInfo<>(hotfixList);
        return new ResponseResult(pageInfo.getTotal(), pageInfo.getList());
    }
}
