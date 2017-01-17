package com.ck.web.dal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户信息表
 * Created by ChengK on 2017/1/6 0006.
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserInfoDo extends BaseDo{
    /**
     * 登录号
     */
    private String loginNo;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 组ID
     */
    private String groupId;
    /**
     * 父组Id
     */
    private String pGroupId;
    /**
     * 登录密码
     */
    private String loginPwd;
    /**
     * 邮件
     */
    private String eMail;
    /**
     * 电话号码
     */
    private String telephone;
}
