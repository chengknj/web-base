package com.ck.web.serviceImpl.login;

import com.ck.web.manager.login.LoginManagerImpl;
import com.ck.web.model.base.BaseResponse;
import com.ck.web.model.login.LoginReqDto;
import com.ck.web.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录service实现类
 * Created by ChengK on 2017/1/6 0006.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginManagerImpl loginManager;

    /**
     * 登录密码校验
     */
    @Override
    public BaseResponse<Boolean> checkLoginPwd(LoginReqDto loginReqDto) {
        return loginManager.checkLoginPwd(loginReqDto);
    }
}
