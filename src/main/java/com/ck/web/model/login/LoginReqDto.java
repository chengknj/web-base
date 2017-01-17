package com.ck.web.model.login;

import com.ck.web.model.base.BaseReqDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 登录请求DTO
 * Created by ChengK on 2017/1/6 0006.
 */
@Getter
@Setter
@ToString
public class LoginReqDto extends BaseReqDto{

    /**
     * 登录号
     */
    private String loginNo;
    /**
     * 密码
     */
    private String password;
}
