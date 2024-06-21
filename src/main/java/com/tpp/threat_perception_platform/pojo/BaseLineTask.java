package com.tpp.threat_perception_platform.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName base_line_task
 */
@Data
public class BaseLineTask implements Serializable {
    /**
     * 主键自增ID
     */
    private Integer id;

    /**
     * 任务
名
     */
    private String taskName;

    /**
     * 任务执行时间
     */
    private Date taskTime;

    /**
     * 
     */
    private Integer taskStatus;

    /**
     * 需要执行任务的主机mac地址
     */
    private String taskHosts;

    private static final long serialVersionUID = 1L;
}