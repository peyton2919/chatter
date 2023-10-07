package cn.peyton.children.chatter.controller.app.android.v1;

import cn.peyton.children.chatter.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 用户信息 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@RestController
public class UserController {

	/** 存在session中的 code key */
	private final static String KEY_SESSION_PHONE_CODE = "SESSION_PHONE_CODE_220323";
	/** 存在 session中的 phone key */
	private final static String KEY_SESSION_PHONE = "SESSION_PHONE_220323";

	/** 手机登录时 存在 token 对象 key */
	private final static String KEY_TOKEN_PHONE = "TOKEN_PHONE_2203231641";
	/** 账号登录时 存在 token 对象 key */
	private final static String KEY_TOKEN_ACCOUNT = "TOKEN_ACCOUNT_2203231829";
	/** 其他登录时 存在 token 对象 key */
	private final static String KEY_TOKEN_OTHER = "TOKEN_OTHER_2203231830";

	private final static String KEY_PHONE_CACHE_TIME = "PHONE_TIME_2203262148";

	@Resource
	private UserService userService;

}
