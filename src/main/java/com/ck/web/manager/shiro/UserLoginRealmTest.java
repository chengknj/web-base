package com.ck.web.manager.shiro;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.sql.*;

/**
 * 登录认证和授权
 * Created by ChengK on 2017/1/10 0010.
 */
@SuppressWarnings("Duplicates")
public class UserLoginRealmTest extends AuthorizingRealm {

    /**
     * 授权操作
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 身份验证操作
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //token中存放用户登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获得用户名与密码
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());
        //String username = (String) authenticationToken.getPrincipal();

        //TODO 与数据库中用户名和密码进行比对。比对成功则返回info，比对失败则抛出对应信息的异常
        //根据username从数据库中查询是否存在用户
        String sql = "SELECT * FROM T_USER_INFO WHERE LOGIN_NO = '" + username + "'";
        ResultSet resultSet = DBHelper(sql);
        String pwd = null;
        try {
            if(resultSet.next()){
                pwd = resultSet.getString("LOGIN_PWD");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assert pwd != null;
        if(!pwd.equals(password)){
            System.out.println("密码错误");
            throw new UnknownAccountException("密码错误");
        }

        //返回认证信息由父类AuthenticatingRealm进行认证
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                username, pwd, getName());

        return info;
    }

    private static final String url = "jdbc:mysql://127.0.0.1/web-ssm";
    private static final String name = "com.mysql.jdbc.Driver";
    private static final String user = "webBase";
    private static final String password = "123qwe";

    private Connection conn = null;

    private ResultSet DBHelper(String sql){
        ResultSet rs = null;
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);//准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
