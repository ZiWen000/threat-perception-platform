package com.tpp.threat_perception_platform.service;

import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.response.ResponseResult;

/**
 * 角色的业务逻辑接口
 */
public interface RoleService {
    ResponseResult roleList();
    int deleteByPrimaryKey(Long id);
    int insert(Role record);
    int insertSelective(Role record);
    Role selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(Role record);
    int updateByPrimaryKey(Role record);
}
