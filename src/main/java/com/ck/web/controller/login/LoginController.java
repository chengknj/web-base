package com.ck.web.controller.login;

import com.alibaba.fastjson.JSONObject;
import com.ck.web.common.exception.ExceptionCode;
import com.ck.web.controller.base.BaseController;
import com.ck.web.model.base.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录controller
 * Created by ChengK on 2016/12/23 0023.
 */
@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{

    /**
     * 登录失败处理
     * @return 登录失败响应类
     */
    @RequestMapping(value = "/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BaseResponse<Boolean> baseResponse = new BaseResponse<>();
        baseResponse.setError(ExceptionCode.LOGIN_PWD_ERROR.getCode(), ExceptionCode.LOGIN_PWD_ERROR.getDesc());
        String json = JSONObject.toJSONString(baseResponse);
        response.getWriter().write(json);
    }
}
