package com.bjike.goddess.recruit.config;

import com.bjike.goddess.common.consumer.config.HIInfo;
import com.bjike.goddess.common.consumer.config.Interceptor;
import com.bjike.goddess.common.consumer.interceptor.login.LoginIntercept;
import com.bjike.goddess.common.consumer.interceptor.login.StorageIntercept;
import com.bjike.goddess.storage.api.StorageUserAPI;
import com.bjike.goddess.user.api.UserAPI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 自定义登陆拦截
 *
 * @Author: [sunfengtao]
 * @Date: [2017-06-01 11:51]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class CustomIntercept implements Interceptor {

    @Autowired
    private StorageUserAPI storageUserAPI;
    @Autowired
    private UserAPI userAPI;

    @Override
    public List<HIInfo> customerInterceptors() {
        List<HIInfo> list = new ArrayList<>();
        HIInfo loginInfo = new HIInfo(new LoginIntercept(userAPI), "/**");
        HIInfo storage = new HIInfo(new StorageIntercept(storageUserAPI), "/**");

        return Arrays.asList(loginInfo, storage);
    }

}