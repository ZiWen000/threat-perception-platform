package com.tpp.threat_perception_platform.dao;


import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Host;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author 26725
* @description 针对表【host】的数据库操作Mapper
* @createDate 2024-06-07 10:42:06
* @Entity pojo.Host
*/
@Mapper
public interface HostMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Host record);

    int insertSelective(Host record);

    Host selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Host record);

    int updateByPrimaryKey(Host record);

    int updateByMacSelective(Host record);

    @Select("select * from host where mac = #{mac} limit 1")
    Host selectByMac(String mac);

    List<Host> findAll(MyParam param);

    @Select("select hostname,mac from host")
    List<Host> findAll2();//查询所有，没有条件
}
