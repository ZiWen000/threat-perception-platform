package com.tpp.threat_perception_platform.dao;


import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 26725
* @description 针对表【account】的数据库操作Mapper
* @createDate 2024-06-12 14:17:55
* @Entity pojo.Account
*/
@Mapper
public interface AccountMapper {

    int deleteByPrimaryKey(Long id);
    int deleteByMac(String mac);

    int insert(Account record);

    int insertSelective(Account record);
    int insertSelectiveBatch(@Param("records") List<Account> records);

    Account selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> findAll(@Param("param") MyParam param);
}
