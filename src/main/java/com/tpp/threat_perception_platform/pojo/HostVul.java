package com.tpp.threat_perception_platform.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName host_vul
 */
@Data
public class HostVul implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 主机mac
     */
    private String mac;

    /**
     * 漏洞id
     */
    private Integer vulId;

    private static final long serialVersionUID = 1L;
}