package cn.peyton.children.chatter.controller.pc;/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.controller.pc.TestLoginController
 * @date 2023年10月06日 10:08
 * @version 1.0.0
 * </pre>
 */

import cn.peyton.children.chatter.controller.base.AppController;
import cn.peyton.core.toolkit.LogTools;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.controller.pc.TestLoginController
 * @date 2023年10月06日 10:08
 * @version 1.0.0
 * </pre>
 */
@Controller
public class TestLoginController extends AppController {

    @GetMapping("/login")
    public String login() {
        LogTools.error("测试");

        return "login";
    }
}
