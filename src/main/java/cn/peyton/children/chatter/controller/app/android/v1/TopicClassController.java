package cn.peyton.children.chatter.controller.app.android.v1;

import cn.peyton.children.chatter.controller.base.AppController;
import cn.peyton.children.chatter.param.TopicClassParam;
import cn.peyton.children.chatter.service.TopicClassService;
import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.validator.Valid;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h3> 话题分类 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@RestController
public class TopicClassController extends AppController {

	@Resource
	private TopicClassService topicClassService;

	@Valid
	@PostMapping("/topicclass/add")
	public JSONResult<TopicClassParam> add(TopicClassParam param) {
		if (topicClassService.isRename(param.getClassName())) {
			return JSONResult.fail(HttpStatusCode.ERR_USER_NAME_BE_USED);
		}
		return topicClassService.add(param)?JSONResult.success(param):JSONResult.fail(HttpStatusCode.ERR_ADD_FAILED);
	}

	// 获取所有话题分类
	@PostMapping("/topicclass")
	public JSONResult<List<TopicClassParam>> finds() {
		return JSONResult.success(topicClassService.finds());
	}


}
