package cn.peyton.children.chatter.controller.app.android.v1;

import cn.peyton.children.chatter.param.CommentParam;
import cn.peyton.children.chatter.param.UserParam;
import cn.peyton.children.chatter.service.CommentService;
import cn.peyton.children.chatter.service.PostService;
import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.enums.PROPERTY;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.validator.Valid;
import cn.peyton.core.validator.constraints.Min;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h3> 评论 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@RestController
public class CommentController {

	@Resource
	private CommentService commentService;
	@Resource
	private PostService postService;

	//用户评论
	@PostMapping("/user/comment")
	public JSONResult<CommentParam> create(CommentParam param, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserParam _userParam = (UserParam) session.getAttribute(PROPERTY.SESSION_USER);
		// 判断 fid不为0时
		if (param.getFId() != 0) {
			if (!commentService.isCommentByFId(param.getFId())) {
				return JSONResult.fail(HttpStatusCode.ERR_NOT_PARENT_COMMENT);
			}
		}
		// 判断 post文章是否存在
		if (!postService.isPost(param.getPostId())) {
			return JSONResult.fail(HttpStatusCode.ERR_NOT_EXIST);
		}
		// 判断是否非法数据
		if (!commentService.isCommentByFIdAndPostId(param.getFId(), param.getPostId())) {
			return JSONResult.fail(HttpStatusCode.ERR_COMMENT_LOGIC);
		}
		param.getUserParam().setId(_userParam.getId());
		CommentParam _cp = commentService.add(param);
		if (null != _cp) {
			return JSONResult.success(HttpStatusCode.SUCCESS_OPERATE_UPDATE.getMsg(), _cp);
		}
		return JSONResult.fail(HttpStatusCode.ERR_OPERATE_UPDATE);
	}

	// 获取当前文章的所有评论
	@PostMapping("/comment/postid")
	@Valid
	public JSONResult<List<CommentParam>> findByPostId(
			@Min(value = 0,message = "参数值要大于0！") Integer postId) {

		return JSONResult.success(commentService.findByPostId(postId));
	}
}
