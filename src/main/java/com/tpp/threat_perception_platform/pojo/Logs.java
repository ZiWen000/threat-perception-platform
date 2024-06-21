package com.tpp.threat_perception_platform.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName logs
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logs implements Serializable {
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
    private Integer eventId;

    /**
     * 
     */
    private String timestamp;

    /**
     * 
     */
    private String param1;

    /**
     * 
     */
    private String param2;

    /**
     * 
     */
    private String param3;

    /**
     * 
     */
    private String param4;

    /**
     * 
     */
    private String param5;

    /**
     * 
     */
    private String param6;

    /**
     * 
     */
    private String param7;

    private static final long serialVersionUID = 1L;
}