package cn.peyton.children.chatter.controller.app.android.v1;

import cn.peyton.children.chatter.controller.base.AppController;
import cn.peyton.children.chatter.param.TopicParam;
import cn.peyton.children.chatter.service.TopicService;
import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.page.PageQuery;
import cn.peyton.core.validator.Valid;
import cn.peyton.core.validator.constraints.Min;
import cn.peyton.core.validator.constraints.NotBlank;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h3> 话题 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Valid
@RestController
public class TopicController extends AppController {

	@Resource
	private TopicService topicService;
	@Valid
	@PostMapping("/topic/add")
	public JSONResult<TopicParam> add(TopicParam param) {
		if (topicService.isRename(param.getTitle(), param.getTopicClassId())) {
			return JSONResult.fail(HttpStatusCode.ERR_USER_NAME_BE_USED);
		}
		return topicService.add(param)?JSONResult.success(param):JSONResult.fail(HttpStatusCode.ERR_ADD_FAILED);
	}

	// 获取热门话题
	@PostMapping("/hottopic")
	public JSONResult<List<TopicParam>> findByHot(
			@Min(message = "要大于0的数！") Integer topicClassId,
			@Min(value = 1, message = "要大于0的数！") Integer pageNo) {
		return JSONResult.success(topicService.findByHot(topicClassId, new PageQuery(pageNo)));
	}

	// 获取指定话题分类下的话题列表
	@PostMapping("/topic/classid")
	public JSONResult<List<TopicParam>> topicByTopicClassId(
			@Min(message = "要大于0的数！") Integer topicClassId,
			@Min(value = 1, message = "要大于0的数！") Integer pageNo) {

		List<TopicParam> topics = topicService.findByTopicId(topicClassId, new PageQuery(pageNo));
		return JSONResult.success(topics);
	}
	@Valid
	// 搜索话题
	@PostMapping("/topic/search")
	public JSONResult<List<TopicParam>> search(
			@NotBlank(message = "搜索字段不能为空！") String keyword,
			@Min(value = 1,message = "要大于0的数！")
			Integer pageNo){

		return JSONResult.success(topicService.search(keyword,new PageQuery(pageNo)));
	}
}
