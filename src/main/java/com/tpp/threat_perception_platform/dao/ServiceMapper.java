package com.tpp.threat_perception_platform.dao;


import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Service;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 26725
* @description 针对表【service】的数据库操作Mapper
* @createDate 2024-06-13 14:38:27
* @Entity pojo.Service
*/
@Mapper
public interface ServiceMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Service record);

    int insertSelective(Service record);

    Service selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Service record);

    int updateByPrimaryKey(Service record);

    List<Service> findAll(@Param("param") MyParam myParam);

    @Delete("delete from service where mac = #{mac}")
    void deleteByMac(String mac);

    int insertSelectiveBatch(List<Service> serviceList);
}
