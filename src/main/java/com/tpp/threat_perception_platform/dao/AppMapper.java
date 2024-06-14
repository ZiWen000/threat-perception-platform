package com.tpp.threat_perception_platform.dao;


import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Account;
import com.tpp.threat_perception_platform.pojo.App;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 26725
* @description 针对表【app】的数据库操作Mapper
* @createDate 2024-06-13 10:57:33
* @Entity pojo.App
*/
@Mapper
public interface AppMapper {

    int deleteByPrimaryKey(Long id);

    int insert(App record);

    int insertSelective(App record);

    App selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);

    @Delete("delete from app where mac = #{mac}")
    void deleteByMac(String mac);

    int insertSelectiveBatch(@Param("appList") List<App> appList);

    List<App> findAll(@Param("param") MyParam param);
}
