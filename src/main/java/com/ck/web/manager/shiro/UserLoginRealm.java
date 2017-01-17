package com.ck.web.manager.shiro;


import com.ck.web.common.util.MD5Util;
import com.ck.web.dal.mapper.LoginMapper;
import com.ck.web.dal.model.UserInfoDo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 登录认证和授权
 * Created by ChengK on 2017/1/10 0010.
 */
public class UserLoginRealm extends AuthorizingRealm {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 授权操作
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 身份验证操作
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {

        //token中存放用户登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获得用户名与密码
        String username = token.getUsername();
        String password = MD5Util.getMD5(String.valueOf(token.getPassword()));

        //TODO 与数据库中用户名和密码进行比对。比对成功则返回info，比对失败则抛出对应信息的异常
        UserInfoDo reqDo = new UserInfoDo();
        reqDo.setLoginNo(username);
        UserInfoDo userInfoDo = loginMapper.findUserByLoginNo(reqDo);

        if(userInfoDo == null){
            throw new UnknownAccountException("不存在该账号");
        }
        if(!userInfoDo.getLoginPwd().equals(password)){
            throw new UnknownAccountException("密码错误");
        }

        //返回认证信息由父类AuthenticatingRealm进行认证
        return new SimpleAuthenticationInfo(username, userInfoDo.getLoginPwd(), getName());
    }
}
