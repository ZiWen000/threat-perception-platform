package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Service;
import com.tpp.threat_perception_platform.pojo.WeakPwd;
import com.tpp.threat_perception_platform.service.WeakPwdService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 26725
* @description 针对表【weak_pwd】的数据库操作Mapper
* @createDate 2024-06-18 16:52:26
* @Entity pojo.WeakPwd
*/
@Mapper
public interface WeakPwdMapper {

    int deleteByPrimaryKey(Long id);

    int insert(WeakPwd record);

    int insertSelective(WeakPwd record);

    int insertSelectiveBatch(List<WeakPwd> weakPwdList);

    List<WeakPwd> findAll(@Param("param") MyParam myParam);

    WeakPwd selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WeakPwd record);

    int updateByPrimaryKey(WeakPwd record);

    @Delete("delete from weak_pwd where mac = #{mac}")
    void deleteByMac(String mac);
}
