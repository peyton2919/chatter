package cn.peyton.children.chatter.controller.app.android.v1;

import cn.peyton.children.chatter.controller.base.AppController;
import cn.peyton.children.chatter.param.ImagesParam;
import cn.peyton.children.chatter.param.PostImageParam;
import cn.peyton.children.chatter.param.PostParam;
import cn.peyton.children.chatter.param.UserParam;
import cn.peyton.children.chatter.service.PostImageService;
import cn.peyton.children.chatter.service.PostService;
import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.enums.PROPERTY;
import cn.peyton.core.err.child.ValidationException;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.page.PageQuery;
import cn.peyton.core.validator.Valid;
import cn.peyton.core.validator.constraints.Min;
import cn.peyton.core.validator.constraints.NotBlank;
import cn.peyton.core.validator.constraints.Size;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 帖子 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@RestController
public class PostController extends AppController {

	@Resource
	private PostService postService;
	@Resource
	private PostImageService postImageService;

	// 发表文章详情
	@PostMapping("/user/post/add")
	@Valid
	@Transactional(rollbackFor = {Exception.class, ValidationException.class})
	public JSONResult<PostParam> add(PostParam postParam, HttpServletRequest request) {
		postParam.getUserParam().setId(1);
		//todo
		HttpSession session = request.getSession();
		UserParam _userParam = (UserParam) session.getAttribute(PROPERTY.SESSION_USER);

		// todo 更新数据
		if (!postService.add(postParam)) {
			return JSONResult.fail(HttpStatusCode.ERR_ADD_FAILED,postParam);
		}
		// todo 连接图片
		// 创建post_image 关联表
		// 从 session 中获取图片
		List<ImagesParam> _images = (List<ImagesParam>) request.getSession().getAttribute(KEY_SESSION_IMAGES);
		if (null != _images) {
			int _postId = postParam.getId();
			// 拼装 postImage 对象
			List<PostImageParam> _pips = new ArrayList<>();
			for (ImagesParam _ip : _images) {
				PostImageParam _p = new PostImageParam();
				_p.setPostId(_postId);
				_p.setImageId(_ip.getId());
				_pips.add(_p);
			}
			_pips = postImageService.insertBatch(_pips);
			if (null == _pips) {
				return JSONResult.fail(HttpStatusCode.ERR_ADD_FAILED, postParam);
			}
			postParam.setImageParamList(_images);
		} else {
			return JSONResult.fail(HttpStatusCode.ERR_LACK_IMAGES);
		}
		return JSONResult.success(postParam);
	}

	// 获取文章详情
	@PostMapping("/post/detail")
	@Valid
	public JSONResult<PostParam> detail(@Min(message = "要大于0的数！") Integer id) {

		return JSONResult.success(postService.findByPrimaryKey(id));
	}

	// 获取指定话题下的文章列表
	@PostMapping("/post/topicid")
	@Valid
	public JSONResult<List<PostParam>> findByTopicId(
			@Min(message = "要大于0的数！") Integer topicId,
			@Min(message = "要大于0的数！") Integer pageNo,
			@Size(min = 0, max = 1, message = "数值超出规定范围！") Integer type) {

		return JSONResult.success(postService.findByTopicId(topicId, new PageQuery(pageNo),type));
	}

	// 获取指定文章分类下的文章列表
	@PostMapping("/post/postclassid")
	@Valid
	public JSONResult<List<PostParam>> findByPostClassId(
			@Min(message = "要大于0的数！")Integer postClassId,
			@Min(message = "要大于0的数！")Integer pageNo){

		return JSONResult.success(postService.findByClassId(postClassId,new PageQuery(pageNo)));
	}

	// 获取指定用户下的文章列表 {游客可点}
	@PostMapping("/post/userid")
	@Valid
	public JSONResult<List<PostParam>> findByUserId(
			@Min(message = "要大于0的数！")Integer userId,
			@Min(message = "要大于0的数！")Integer pageNo){

		return JSONResult.success(postService.findByUserId(userId,new PageQuery(pageNo)));
	}

	// 获取指定用户下的文章列表 {含隐私}
	@PostMapping("/user/post/pkuserid")
	@Valid
	public JSONResult<List<PostParam>> findByPKUserId(
			@Min(message = "要大于0的数！") Integer pageNo,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserParam _userParam = (UserParam) session.getAttribute(PROPERTY.SESSION_USER);
		return JSONResult.success(postService.findByPKUserId(_userParam.getId(), new PageQuery(pageNo)));
	}

	// 搜索文章
	@PostMapping("/post/search")
	@Valid
	public JSONResult<List<PostParam>> search(
			@NotBlank(message = "关键字不能为空！") String keyword,
			@Min(message = "要大于0的数！") Integer pageNo) {

		return JSONResult.success(postService.search(keyword, new PageQuery(pageNo)));
	}
}
