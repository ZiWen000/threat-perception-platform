package com.tpp.threat_perception_platform.dao;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Account;
import com.tpp.threat_perception_platform.pojo.Process;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 26725
* @description 针对表【process】的数据库操作Mapper
* @createDate 2024-06-13 10:57:33
* @Entity pojo.Process
*/
@Mapper
public interface ProcessMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Process record);

    int insertSelective(Process record);

    Process selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);

    @Delete("delete from process where mac = #{mac}")
    void deleteByMac(String mac);

    int insertSelectiveBatch(@Param("processList") List<Process> processList);

    List<Process> findAll(@Param("param") MyParam param);
}
