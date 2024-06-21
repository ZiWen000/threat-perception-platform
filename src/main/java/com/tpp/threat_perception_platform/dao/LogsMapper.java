package com.tpp.threat_perception_platform.dao;

import com.mysql.cj.log.Log;
import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Logs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 26725
* @description 针对表【logs】的数据库操作Mapper
* @createDate 2024-06-21 09:38:20
* @Entity pojo.Logs
*/
@Mapper
public interface LogsMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Logs record);

    int insertSelective(Logs record);

    Logs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Logs record);

    int updateByPrimaryKey(Logs record);

    @Delete("delete from logs where mac = #{mac}")
    void deleteByMac(String mac);

    int insertSelectiveBatch(@Param("logsList") List<Logs> logsList);

    List<Logs> findAll(@Param("param") MyParam param);
}
