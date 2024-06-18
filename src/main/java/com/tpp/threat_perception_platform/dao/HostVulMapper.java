package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.pojo.HostVul;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 26725
* @description 针对表【host_vul】的数据库操作Mapper
* @createDate 2024-06-18 12:51:47
* @Entity pojo.HostVul
*/
@Mapper
public interface HostVulMapper {

    int deleteByPrimaryKey(Long id);

    int deleteByMac(String mac);

    int insert(HostVul record);

    int insertSelective(HostVul record);

    int insertSelectiveBatch(List<HostVul> hostVuls);

    HostVul selectByPrimaryKey(Long id);

    /**
     * 通过漏洞id查询数据
     * @param vulId
     * @return
     */
    List<HostVul> selectByVulId(Integer vulId);

    int updateByPrimaryKeySelective(HostVul record);

    int updateByPrimaryKey(HostVul record);

}
