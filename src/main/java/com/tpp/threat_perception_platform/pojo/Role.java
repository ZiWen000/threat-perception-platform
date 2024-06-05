package com.tpp.threat_perception_platform.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName role
 */
@Data
public class Role implements Serializable {
    /**
     * 主键ID
     */
    private Integer roleId;

    /**
     * 角色名字
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleDesc;

    private static final long serialVersionUID = 1L;
}