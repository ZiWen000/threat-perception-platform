package com.tpp.threat_perception_platform.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String mac;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String fullName;

    /**
     * 
     */
    private String sid;

    /**
     * 
     */
    private String sidType;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String disabled;

    /**
     * 账户锁
     */
    private String lockout;

    /**
     * 密码是否修改过
     */
    private String passwordChangeable;

    /**
     * 密码是否设置有效期
     */
    private String passwordExpires;

    /**
     * 
     */
    private String passwordRequired;

    private static final long serialVersionUID = 1L;
}