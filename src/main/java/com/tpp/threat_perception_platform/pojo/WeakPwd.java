package com.tpp.threat_perception_platform.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName weak_pwd
 */
@Data
public class WeakPwd implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String uName;

    /**
     * 
     */
    private String uPwd;

    /**
     * 
     */
    private String mac;

    private static final long serialVersionUID = 1L;
}