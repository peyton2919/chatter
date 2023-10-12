package cn.peyton.children.chatter.controller.app.android.v1;

import cn.peyton.children.chatter.param.SupportParam;
import cn.peyton.children.chatter.param.UserParam;
import cn.peyton.children.chatter.service.PostService;
import cn.peyton.children.chatter.service.SupportService;
import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.enums.PROPERTY;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.validator.Valid;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 支持 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@RestController
public class SupportController {

	@Resource
	private SupportService supportService;
	@Resource
	private PostService postService;

	// 用户顶踩
	@PostMapping("/user/support")
	@Valid
	public JSONResult<SupportParam> create(SupportParam supportParam, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserParam _userParam = (UserParam) session.getAttribute(PROPERTY.SESSION_USER);
		SupportParam _param = supportService.isSupport(_userParam.getId(), supportParam.getPostId());
		//判断当前记录是否有操作过
		if (null != _param) {
			if (_param.getType() == supportParam.getType()) {
				return JSONResult.fail(HttpStatusCode.ERR_NOT_REPEAT_OPERATION.getCode(),
						((supportParam.getType() == 0) ? "已经顶过了," : "已经踩过了,") + "不能重复操作!");
			}
			_param.setType(supportParam.getType());

			if (supportService.update(_param)){
				return JSONResult.success((_param.getType() == 0) ? "顶成功" : "踩成功");
			}
		}
		//判断文章是否存在
		if (!postService.isPost(supportParam.getPostId())) {
			return JSONResult.fail(HttpStatusCode.ERR_NOT_EXIST);
		}
		supportParam.setUserId(_userParam.getId());
		if (null != supportService.add(supportParam)){
			return JSONResult.success((supportParam.getType() == 0) ? "顶成功" : "踩成功");
		}
		return JSONResult.fail(HttpStatusCode.ERR_OPERATE_UPDATE);
	}
}
