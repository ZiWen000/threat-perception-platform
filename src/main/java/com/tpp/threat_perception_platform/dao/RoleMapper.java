package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.pojo.Role;

import java.util.List;

/**
* @author 26725
* @description 针对表【role】的数据库操作Mapper
* @createDate 2024-06-05 12:17:15
* @Entity pojo.Role
*/
public interface RoleMapper {
    List<Role> findAll();
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

}
