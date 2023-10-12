package cn.peyton.children.chatter.controller.app.android.v1;

import cn.peyton.children.chatter.param.BlackListParam;
import cn.peyton.children.chatter.param.UserParam;
import cn.peyton.children.chatter.service.BlackListService;
import cn.peyton.children.chatter.service.UserService;
import cn.peyton.children.chatter.toolkit.UserTools;
import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.validator.Valid;
import cn.peyton.core.validator.constraints.Min;
import cn.peyton.core.validator.constraints.NotBlank;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 拉黑集 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@RestController
public class BlackListController {

	@Resource
	private BlackListService blackListService;
	@Resource
	private UserService userService;


	// 加入黑名单
	@PostMapping("/user/addblack")
	@Valid
	public JSONResult<BlackListParam> addBlack(
			@NotBlank(message = "用户不能为空")
			@Min(message = "数值不能小于1！", value = 1)
			Integer blackId, HttpServletRequest request) {
		UserParam _userParam = UserTools.getUserParam(request);
		if (blackId == _userParam.getId()) {
			return JSONResult.fail(HttpStatusCode.ERR_NOT_OPERATE_SELF);
		}
		//判断是否已经拉黑
		if (blackListService.isUserIdAndBlackId(_userParam.getId(), blackId)) {
			return JSONResult.fail(HttpStatusCode.ERR_HAS_BEEN_BLOCKED);
		}
		// 判断用户是否合法
		if (!userService.isUserId(blackId)) {
			return JSONResult.fail(HttpStatusCode.ERR_USER_NOT_EXIST);
		}
		// 添加黑名单
		BlackListParam _param = new BlackListParam();
		_param.setBlackId(blackId);
		_param.setUserId(_userParam.getId());
		if (blackListService.add(_param)) {
			return JSONResult.success(HttpStatusCode.SUCCESS_OPERATE_UPDATE.getMsg());
		}
		return JSONResult.fail(HttpStatusCode.ERR_OPERATE_UPDATE);
	}

	// 移除黑名单
	@PostMapping("/user/removeblack")
	@Valid
	public JSONResult<BlackListParam> removeBlack(
			@NotBlank(message = "用户不能为空")
			@Min(message = "数值不能小于1！", value = 1)
			Integer blackId, HttpServletRequest request) {
		UserParam _userParam = UserTools.getUserParam(request);
		if (blackId == _userParam.getId()) {
			return JSONResult.fail(HttpStatusCode.ERR_NOT_OPERATE_SELF);
		}
		// 判断用户是否合法
		if (!userService.isUserId(blackId)) {
			return JSONResult.fail(HttpStatusCode.ERR_USER_NOT_EXIST);
		}
		// 判断是否已经拉黑
		if (!blackListService.isUserIdAndBlackId(_userParam.getId(), blackId)) {
			return JSONResult.fail(HttpStatusCode.ERR_NOT_BLOCKED);
		}
		if (blackListService.delete(_userParam.getId(), blackId)) {
			return JSONResult.success(HttpStatusCode.SUCCESS_OPERATE_UPDATE.getMsg());
		}
		return JSONResult.fail(HttpStatusCode.ERR_OPERATE_UPDATE);
	}
}
