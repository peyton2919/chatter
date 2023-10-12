package cn.peyton.children.chatter.controller.app.android.v1;

import cn.peyton.children.chatter.param.FeedbackParam;
import cn.peyton.children.chatter.param.UserParam;
import cn.peyton.children.chatter.service.FeedbackService;
import cn.peyton.children.chatter.toolkit.UserTools;
import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.page.PageQuery;
import cn.peyton.core.validator.Valid;
import cn.peyton.core.validator.constraints.Min;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h3> 反馈 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@RestController
public class FeedbackController {

	@Resource
	private FeedbackService feedbackService;
	// 用户反馈
	@PostMapping("/user/feedback")
	@Valid
	public JSONResult<FeedbackParam> create(FeedbackParam param, HttpServletRequest request) {
		UserParam _userParam = UserTools.getUserParam(request);
		param.setFromId(_userParam.getId());
		param.setToId(0);
		if (feedbackService.add(param)) {
			return JSONResult.success(HttpStatusCode.SUCCESS_OPERATE_UPDATE.getMsg());
		}
		return JSONResult.fail(HttpStatusCode.ERR_OPERATE_UPDATE);
	}

	// 获取用户反馈列表
	@Valid
	@PostMapping("/user/feedbacklist")
	public JSONResult<List<FeedbackParam>> feedbackList(
			@Min(message = "数值不能小于1！", value = 1)
			Integer pageNo, HttpServletRequest request) {

		return JSONResult.success(feedbackService.finds(new PageQuery(pageNo)));
	}
}
