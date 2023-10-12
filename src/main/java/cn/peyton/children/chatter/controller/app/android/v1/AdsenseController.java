package cn.peyton.children.chatter.controller.app.android.v1;

import cn.peyton.children.chatter.controller.base.AppController;
import cn.peyton.children.chatter.param.AdsenseParam;
import cn.peyton.children.chatter.service.AdsenseService;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.page.PageQuery;
import cn.peyton.core.validator.Valid;
import cn.peyton.core.validator.constraints.Min;
import cn.peyton.core.validator.constraints.Size;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
public class AdsenseController extends AppController {

	@Resource
	private AdsenseService adsenseService;

	@Valid
	@PostMapping("/adsense")
	public JSONResult<List<AdsenseParam>> findByType(
			@Size(min = 0,max=1,message = "数值超出限制范围！") Integer type,
			@Min(message = "要大于0的数！")Integer pageNo) {
		return JSONResult.success(adsenseService.findByType(type,new PageQuery(pageNo)));
	}

}
