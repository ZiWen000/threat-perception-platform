package com.tpp.threat_perception_platform.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName app
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class App implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 主机mac地址
     */
    private String mac;

    /**
     * 应用名称
     */
    private String displayName;

    /**
     * 应用安装路径
     */
    private String installLocation;

    /**
     * 应用卸载路径
     */
    private String uninstallLocation;

    private static final long serialVersionUID = 1L;
}