package cn.peyton.children.chatter.controller.app.android;

import cn.peyton.children.chatter.pojo.Adsense;
import cn.peyton.children.chatter.service.AdsenseService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 广告 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@RestController
public class AdsenseController {

	@Resource
	private AdsenseService adsenseService;

	@GetMapping("/find")
	public Adsense findById() {
		return adsenseService.findById(1);
	}

}
