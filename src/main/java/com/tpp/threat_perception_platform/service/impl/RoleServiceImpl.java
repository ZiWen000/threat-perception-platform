package com.tpp.threat_perception_platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tpp.threat_perception_platform.dao.RoleMapper;
import com.tpp.threat_perception_platform.param.MyParam;
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

    public ResponseResult roleList(MyParam param) {
        //处理分页的逻辑
        PageHelper.startPage(param.getPage(),param.getLimit());
        List<Role> datas = roleMapper.findAll(param);
        PageInfo<Role> pageInfo = new PageInfo<>(datas);
        return new ResponseResult(pageInfo.getTotal(),pageInfo.getList());
    }

    public ResponseResult deleteByPrimaryKey(Long id) {
        return null;
    }

    public ResponseResult insert(Role record) {
        Role db_role = roleMapper.selectByName(record.getRoleName());
        if (db_role != null) {
            return new ResponseResult(1,"角色已存在");
        }

        roleMapper.insert(record);
        return new ResponseResult(0,"添加成功");
    }

    public ResponseResult insertSelective(Role record) {
        return null;
    }

    public ResponseResult selectByPrimaryKey(Long id) {return null;}

    /**
     * 编辑角色数据
     * @param record
     * @return
     */
    public ResponseResult updateByPrimaryKeySelective(Role record) {
        roleMapper.updateByPrimaryKeySelective(record);
        return new ResponseResult(0,"编辑成功");
    }

    /**
     * 编辑角色
     * @param record
     * @return
     */
    public ResponseResult updateByPrimaryKey(Role record) {
        return new ResponseResult(0,"编辑成功");
    }

    public ResponseResult delete(Integer[] ids) {
        roleMapper.delete(ids);
        return new ResponseResult<>(0, "删除成功！");
    }
}
