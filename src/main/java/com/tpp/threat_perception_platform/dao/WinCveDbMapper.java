package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.pojo.WinCveDb;

import java.util.List;

/**
* @author 26725
* @description 针对表【win_cve_db(Windows漏洞与KB补丁关系库)】的数据库操作Mapper
* @createDate 2024-06-16 12:39:24
* @Entity pojo.WinCveDb
*/
public interface WinCveDbMapper {

    int deleteByPrimaryKey(Long id);

    int insert(WinCveDb record);

    int insertSelective(WinCveDb record);

    WinCveDb selectByPrimaryKey(Long id);

    List<WinCveDb> selectByKbId(String kbId);

    int updateByPrimaryKeySelective(WinCveDb record);

    int updateByPrimaryKey(WinCveDb record);

}
