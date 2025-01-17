package com.tpp.threat_perception_platform.service;

import com.tpp.threat_perception_platform.param.MyParam;
import com.tpp.threat_perception_platform.pojo.Account;
import com.tpp.threat_perception_platform.response.ResponseResult;

import java.util.List;

public interface AccountService {
    int add(List<Account> accountList);

    /**
     * 账号列表
     * @param myParam
     * @return
     */
    ResponseResult list(MyParam myParam);
}
