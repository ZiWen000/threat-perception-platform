package com.tpp.threat_perception_platform.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName process
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Process implements Serializable {
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
    private Integer pid;

    /**
     * 
     */
    private Integer ppid;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String cmd;

    /**
     * 
     */
    private Integer priority;

    /**
     * 
     */
    private String description;

    private static final long serialVersionUID = 1L;
}