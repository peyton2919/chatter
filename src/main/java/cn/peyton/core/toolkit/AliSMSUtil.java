package cn.peyton.core.toolkit;

import cn.peyton.core.json.JSONResult;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3>阿里大于短信验证类</h3>
 * <pre>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2022/3/26 22:32
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
@RestController
public class AliSMSUtil {

    public static JSONResult sendCode(String phone, String code) {

        return JSONResult.success();
    }
}
