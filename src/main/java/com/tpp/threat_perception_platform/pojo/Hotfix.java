package com.tpp.threat_perception_platform.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName hotfix
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    /**
     * 补丁可能包含的CVE列表
     */
    private List<WinCveDb> winCveDbList;

    private static final long serialVersionUID = 1L;
}