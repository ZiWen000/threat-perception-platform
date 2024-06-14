package com.tpp.threat_perception_platform.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName service
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String protocol;

    /**
     * 
     */
    private Integer port;

    /**
     * 
     */
    private String state;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String product;

    /**
     * 
     */
    private String version;

    /**
     * 
     */
    private String extrainfo;

    private String mac;

    private static final long serialVersionUID = 1L;


}