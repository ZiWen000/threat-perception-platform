package com.tpp.threat_perception_platform.service.impl;

import com.tpp.threat_perception_platform.dao.AccountMapper;
import com.tpp.threat_perception_platform.pojo.Account;
import com.tpp.threat_perception_platform.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    /**
     * 添加账号探测数据
     * @param accountList
     * @return
     */
    @Transactional
    public int add(List<Account> accountList) {
        //1. 需要将旧数据删除，通过mac地址删除
        accountMapper.deleteByMac(accountList.get(0).getMac());
        //2. 添加新数据
        return accountMapper.insertSelectiveBatch(accountList);
    }
}
