package com.ck.web.dal.mapper;

import com.ck.web.dal.model.UserInfoDo;
import org.springframework.stereotype.Component;

/**
 * 登录mapper
 * Created by ChengK on 2017/1/6 0006.
 */
@Component
public interface LoginMapper {

    int checkLoginPwd(UserInfoDo userInfoDo);

    UserInfoDo findUserByLoginNo(UserInfoDo userInfoDo);
}
