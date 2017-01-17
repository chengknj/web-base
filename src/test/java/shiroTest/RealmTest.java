package shiroTest;

import com.ck.web.common.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * shiro测试类
 * Created by ChengK on 2017/1/11 0011.
 */
public class RealmTest {
    private static final Logger logger = LoggerFactory.getLogger(RealmTest.class);

    public static void main(String[] args) {
        testRealm();
    }

    private static void testRealm() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro_ownRealm.ini");
        //2、得到SecurityManager实例并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("admin", MD5Util.getMD5("123qwe"));
        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }

    }
}
