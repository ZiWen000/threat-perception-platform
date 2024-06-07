package com.tpp.threat_perception_platform.service;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.response.ResponseResult;

/**
 * 角色的业务逻辑接口
 */
public interface RoleService {
    ResponseResult roleList(MyParam param);
    ResponseResult deleteByPrimaryKey(Long id);
    ResponseResult insert(Role record);
    ResponseResult insertSelective(Role record);
    ResponseResult selectByPrimaryKey(Long id);
    ResponseResult updateByPrimaryKeySelective(Role record);
    ResponseResult updateByPrimaryKey(Role record);
    ResponseResult delete(Integer[] ids);
}
