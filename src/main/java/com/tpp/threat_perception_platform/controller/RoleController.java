package com.tpp.threat_perception_platform.controller;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Role;
import com.tpp.threat_perception_platform.response.ResponseResult;
import com.tpp.threat_perception_platform.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 分页查询
     * @param param
     * @return
     */
    @PostMapping("/list")
    public ResponseResult list(MyParam param){
        return roleService.roleList(param);
    }

    /**
     * 增添角色
     * @param role
     * @return
     */
    @PostMapping("/add")
    public ResponseResult add(@RequestBody Role role){
        return roleService.insert(role);
    }

    /**
     * 编辑角色
     * @param role
     * @return
     */
    @PostMapping("/edit")
    public ResponseResult edit(@RequestBody Role role){
        return roleService.updateByPrimaryKeySelective(role);
    }

    /**
     * 批量删除角色
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    public ResponseResult delete(@RequestParam("ids[]") Integer[] ids){
        return roleService.delete(ids);
    }
}
