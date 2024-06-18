package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.pojo.WeakPwd;

/**
* @author 26725
* @description 针对表【weak_pwd】的数据库操作Mapper
* @createDate 2024-06-18 16:52:26
* @Entity pojo.WeakPwd
*/
public interface WeakPwdMapper {

    int deleteByPrimaryKey(Long id);

    int insert(WeakPwd record);

    int insertSelective(WeakPwd record);

    WeakPwd selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WeakPwd record);

    int updateByPrimaryKey(WeakPwd record);

}
