package cn.peyton.children.chatter.controller.base;

import cn.peyton.children.chatter.param.UserParam;
import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.token.TokenTools;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

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
@RestController
@RequestMapping("/api")
public class AppController extends BaseController implements Serializable {


    /** session中的 验证码 key */
    public final static String KEY_SESSION_PHONE_CODE = "SESSION_PHONE_CODE_220323";
    /** session中的 手机号码 key */
    public final static String KEY_SESSION_PHONE = "SESSION_PHONE_220324";
    /** session中的 手机号码 key */
    public final static String KEY_SESSION_IMAGES = "SESSION_IMAGES_220325";

    /** 用户登录成功时，存在 session中的 用户传参对象 key */
    public final static String SESSION_USER = "SESSION_USER_PARAM_2203231859";

    /** token中 手机号码 key */
    public final static String KEY_TOKEN = "TOKEN_2203231641";

    public final static String KEY_PHONE_CACHE_TIME = "PHONE_TIME_2203262148";

    @Override
    public JSONResult<UserParam>  handleToken(HttpServletRequest request) {
        String _tokenValues = request.getHeader(TokenTools.Property.ACCESS_TOKEN);
        if (null == _tokenValues){
            return JSONResult.fail(HttpStatusCode.ERR_ILLEGAL_TOKEN);
        }
        TokenTools<UserParam> _tokenTools = new TokenTools<>();
        UserParam _userParam = _tokenTools.getObject(KEY_TOKEN, _tokenValues, new UserParam());
        if (null == _userParam){
            return JSONResult.fail(HttpStatusCode.ERR_ILLEGAL_TOKEN);
        }
        return JSONResult.success(_userParam);
    }
}
