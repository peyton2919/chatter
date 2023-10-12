package cn.peyton.children.chatter.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <h4>app 根目录</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.controller.base.AppController
 * @date 2023年10月08日 8:45
 * @version 1.0.0
 * </pre>
 */
@Controller
@RequestMapping("/api")
public class AppController {

    /** session中的 验证码 key */
    public final static String KEY_SESSION_PHONE_CODE = "SESSION_PHONE_CODE_220323";
    /** session中的 手机号码 key */
    public final static String KEY_SESSION_PHONE = "SESSION_PHONE_220324";
    /** session中的 手机号码 key */
    public final static String KEY_SESSION_IMAGES = "SESSION_IMAGES_220325";

    /** 用户登录成功时，存在 session中的 用户传参对象 key */
    public final static String SESSION_USER = "SESSION_USER_PARAM_2203231859";

    /** token中 手机号码 key */
    public final static String KEY_TOKEN_PHONE = "TOKEN_PHONE_2203231641";
    /** token中 账户号码 key */
    public final static String KEY_TOKEN_ACCOUNT = "TOKEN_ACCOUNT_2203231829";
    /** token 其他号码 key */
    public final static String KEY_TOKEN_OTHER = "TOKEN_OTHER_2203231830";

    public final static String KEY_PHONE_CACHE_TIME = "PHONE_TIME_2203262148";
}
