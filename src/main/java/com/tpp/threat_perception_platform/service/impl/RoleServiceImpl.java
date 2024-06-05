package com.tpp.threat_perception_platform.service.impl;

import com.tpp.threat_perception_platform.dao.RoleMapper;
import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public ResponseResult roleList() {
        List<Role> datas = roleMapper.findAll();
        Long count = 5L;
        return new ResponseResult(count,datas);
    }

    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    public int insert(Role record) {
        return 0;
    }

    public int insertSelective(Role record) {
        return 0;
    }

    public Role selectByPrimaryKey(Long id) {
        return null;
    }

    public int updateByPrimaryKeySelective(Role record) {
        return 0;
    }

    public int updateByPrimaryKey(Role record) {
        return 0;
    }
}
