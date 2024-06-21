package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.pojo.BaseLineTask;

/**
* @author 26725
* @description 针对表【base_line_task】的数据库操作Mapper
* @createDate 2024-06-21 16:17:44
* @Entity pojo.BaseLineTask
*/
public interface BaseLineTaskMapper {

    int deleteByPrimaryKey(Long id);

    int insert(BaseLineTask record);

    int insertSelective(BaseLineTask record);

    BaseLineTask selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseLineTask record);

    int updateByPrimaryKey(BaseLineTask record);

}
