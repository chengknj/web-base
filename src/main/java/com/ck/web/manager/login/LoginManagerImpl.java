package com.ck.web.manager.login;

import com.ck.web.common.exception.ExceptionCode;
import com.ck.web.common.util.MD5Util;
import com.ck.web.dal.mapper.LoginMapper;
import com.ck.web.dal.model.UserInfoDo;
import com.ck.web.model.base.BaseResponse;
import com.ck.web.model.login.LoginReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 登录manager实现类
 * Created by ChengK on 2017/1/6 0006.
 */
@Component
public class LoginManagerImpl {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 密码登录校验
     */
    public BaseResponse<Boolean> checkLoginPwd(LoginReqDto loginReqDto) {
        BaseResponse<Boolean> baseResponse = new BaseResponse<>();
        UserInfoDo userInfoDo = new UserInfoDo();
        userInfoDo.setLoginNo(loginReqDto.getLoginNo());
        userInfoDo.setLoginPwd(MD5Util.getMD5(loginReqDto.getPassword()));
        int count = loginMapper.checkLoginPwd(userInfoDo);
        if(count>0){
            baseResponse.setResult(true);
        }else{
            baseResponse.setError(ExceptionCode.LOGIN_PWD_ERROR.getCode(),ExceptionCode.LOGIN_PWD_ERROR.getDesc());
        }
        return baseResponse;
    }
}
