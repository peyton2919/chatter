package cn.peyton.children.chatter.controller.app.android.v1;

import cn.peyton.children.chatter.service.UserBindService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 第三方登录信息 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@RestController
public class UserBindController {

	@Resource
	private UserBindService userBindService;

}
