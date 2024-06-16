package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.App;
import com.tpp.threat_perception_platform.pojo.Hotfix;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 26725
* @description 针对表【hotfix】的数据库操作Mapper
* @createDate 2024-06-14 10:15:41
* @Entity pojo.Hotfix
*/
public interface HotfixMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Hotfix record);

    int insertSelective(Hotfix record);

    Hotfix selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Hotfix record);

    int updateByPrimaryKey(Hotfix record);

    int insertSelectiveBatch(@Param("hotfixList") List<Hotfix> hotfixList);

    List<Hotfix> findAll(@Param("param") MyParam param);

    @Delete("delete from hotfix where mac = #{mac}")
    void deleteByMac(String mac);
}
