package cn.peyton.children.chatter.controller.hint;

import cn.peyton.children.chatter.controller.base.AppController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.controller.hint.UserHintMessage
 * @date 2023年10月13日 16:00
 * @version 1.0.0
 * </pre>
 */
@Controller
public class UserHintMessage extends AppController {

    @Value(value = "${user.password} ${base.not.null}")
    protected String PASSWORD_NOT_NULL;

}
