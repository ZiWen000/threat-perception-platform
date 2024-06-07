package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 26725
* @description 针对表【role】的数据库操作Mapper
* @createDate 2024-06-05 12:17:15
* @Entity pojo.Role
*/
@Mapper
public interface RoleMapper {
    List<Role> findAll(MyParam param);

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 批量删除
     * @param ids
     */
    void delete(@Param("ids") Integer[] ids);

    @Select("select * from role where role_name = #{roleName} limit 1")
    Role selectByName(String roleName);

    void updateByNameSelective(Role record);
}
