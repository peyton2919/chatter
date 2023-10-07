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
public class TestLoginController {

    @GetMapping("/login")
    public String login() {

        return "login";
    }
}
