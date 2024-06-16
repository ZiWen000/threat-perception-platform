package com.tpp.threat_perception_platform.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName hotfix
 */
@Data
public class Hotfix implements Serializable {
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
    private String hotfixId;

    private static final long serialVersionUID = 1L;
}