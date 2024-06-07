package com.tpp.threat_perception_platform.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName host
 */
@Data
public class Host implements Serializable {
    /**
     * 
     */
    private Integer hostId;

    /**
     * 
     */
    private String hostname;

    /**
     * 
     */
    private String ip;

    /**
     * 
     */
    private String mac;

    /**
     * 
     */
    private String osName;

    /**
     * 
     */
    private String osVersion;

    /**
     * 
     */
    private String osType;

    /**
     * 
     */
    private String osArch;

    /**
     * 
     */
    private String cpu;

    /**
     * 
     */
    private String ram;

    /**
     * 1：正常，0：下线
     */
    private Integer status;

    /**
     * 上线时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}