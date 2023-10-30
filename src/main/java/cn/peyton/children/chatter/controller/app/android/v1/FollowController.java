package cn.peyton.children.chatter.controller.app.android.v1;

import cn.peyton.children.chatter.controller.base.AppController;
import cn.peyton.children.chatter.param.FollowParam;
import cn.peyton.children.chatter.param.UserParam;
import cn.peyton.children.chatter.service.FollowService;
import cn.peyton.children.chatter.service.UserService;
import cn.peyton.children.chatter.toolkit.UserTools;
import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.page.PageQuery;
import cn.peyton.core.token.Token;
import cn.peyton.core.token.TokenTools;
import cn.peyton.core.validator.Valid;
import cn.peyton.core.validator.constraints.Min;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h3> 关注 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@RestController
public class FollowController extends AppController {

	@Resource
	private FollowService followService;
	@Resource
	private UserService userService;

	// 用户关注
	@Token
	@Valid
	@PostMapping("/user/follow")
	public JSONResult<FollowParam> follow(
			@Min(message = "数值不能小于1！", value = 1)
			Integer id, HttpServletRequest request) {
		//UserParam _userParam= UserTools.getUserParam(request);

		String _tokenValue = request.getHeader(TokenTools.Property.ACCESS_TOKEN);
		if (null == _tokenValue) {
			return JSONResult.fail(HttpStatusCode.ERR_ILLEGAL_TOKEN);
		}
		TokenTools<UserParam> _tokenTools = new TokenTools<UserParam>();
		UserParam _userParam = _tokenTools.getObject(KEY_TOKEN, _tokenValue, new UserParam());
		if (null == _userParam) {
			return JSONResult.fail(HttpStatusCode.ERR_ILLEGAL_TOKEN);
		}
		int _userId = _userParam.getId();
		// 不能关注自己
		if (id == _userId) {
			return JSONResult.fail(HttpStatusCode.ERR_NOT_OPERATE_SELF);
		}
		//判断用户是否存在
		if (!userService.isUserId(id)) {
			return JSONResult.fail(HttpStatusCode.ERR_USER_NOT_EXIST);
		}
		// 判断是否已经关注过
		if (followService.isFollow(id, _userId)) {
			return JSONResult.fail(HttpStatusCode.ERR_FOLLOW);
		}

		// 保存对象
		if (followService.add(_userId, id)) {
			return JSONResult.success(HttpStatusCode.SUCCESS_OPERATE_UPDATE.getMsg());
		}
		return JSONResult.fail(HttpStatusCode.ERR_OPERATE_UPDATE);
	}
	// 用户取消关注
	@PostMapping("/user/unfollow")
	@Valid
	public JSONResult<FollowParam> unFollow(
			@Min(message = "数值不能小于1！", value = 1)
			int followId, HttpServletRequest request) {
		UserParam _userParam= UserTools.getUserParam(request);
		int _userId = _userParam.getId();
		// 不能取消关注自己
		if (followId == _userId) {
			return JSONResult.fail(HttpStatusCode.ERR_NOT_CANCEL_OPERATE_SELF);
		}
		// 判断用户是否合法
		if (!userService.isUserId(followId)) {
			return JSONResult.fail(HttpStatusCode.ERR_USER_NOT_EXIST);
		}
		// 判断是否已经关注过
		if (!followService.isFollow(followId, _userId)) {
			return JSONResult.fail(HttpStatusCode.ERR_NOT_FOLLOW);
		}
		// 删除 关注
		if (followService.delete(_userId, followId)) {
			return JSONResult.success(HttpStatusCode.SUCCESS_OPERATE_UPDATE.getMsg());
		}
		return JSONResult.fail(HttpStatusCode.ERR_OPERATE_UPDATE);
	}

	// 互注列表
	@Valid
	@PostMapping("/user/friends")
	public JSONResult<List<FollowParam>> friends(
			@Min(message = "数值不能小于1！", value = 1)
			Integer pageNo, HttpServletRequest request) {
		UserParam _user = UserTools.getUserParam(request);
		return JSONResult.success(followService.friends(_user.getId(),new PageQuery(pageNo)));
	}

	// 粉丝列表
	@Valid
	@PostMapping("/user/fens")
	public JSONResult<List<FollowParam>> fens(
			@Min(message = "数值不能小于1！", value = 1)
			Integer pageNo, HttpServletRequest request) {
		UserParam _user = UserTools.getUserParam(request);
		return JSONResult.success(followService.follows(_user.getId(),new PageQuery(pageNo),true));
	}

	// 关注列表
	@Valid
	@PostMapping("/user/follows")
	public JSONResult<List<FollowParam>> follows(
			@Min(message = "数值不能小于1！", value = 1)
			Integer pageNo, HttpServletRequest request) {
		UserParam _user = UserTools.getUserParam(request);

		return JSONResult.success(followService.follows(_user.getId(),new PageQuery(pageNo),false));
	}
}
