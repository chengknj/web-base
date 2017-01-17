package com.ck.web.service.login;

import com.ck.web.model.base.BaseResponse;
import com.ck.web.model.login.LoginReqDto;

/**
 * 登录接口
 * Created by ChengK on 2017/1/6 0006.
 */
public interface LoginService {

    /**
     * 登录密码校验
     */
    BaseResponse<Boolean> checkLoginPwd(LoginReqDto loginReqDto);
}
