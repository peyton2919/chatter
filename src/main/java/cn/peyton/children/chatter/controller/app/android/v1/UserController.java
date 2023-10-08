package cn.peyton.children.chatter.controller.app.android.v1;

import cn.peyton.children.chatter.controller.base.AppController;
import cn.peyton.children.chatter.param.UserBindParam;
import cn.peyton.children.chatter.param.UserInfoParam;
import cn.peyton.children.chatter.param.UserParam;
import cn.peyton.children.chatter.service.*;
import cn.peyton.children.chatter.toolkit.UserTools;
import cn.peyton.core.cache.LocalCache;
import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.enums.PROPERTY;
import cn.peyton.core.img.ImageProcessing;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.page.PageQuery;
import cn.peyton.core.token.TokenTools;
import cn.peyton.core.toolkit.AliSMSUtil;
import cn.peyton.core.toolkit.FileTools;
import cn.peyton.core.toolkit.MessageTools;
import cn.peyton.core.validator.Regulation;
import cn.peyton.core.validator.Valid;
import cn.peyton.core.validator.constraints.*;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h3> 用户信息 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@RestController
public class UserController extends AppController {

	/** 存在session中的 code key */
	private final static String KEY_SESSION_PHONE_CODE = "SESSION_PHONE_CODE_220323";
	/** 存在 session中的 phone key */
	private final static String KEY_SESSION_PHONE = "SESSION_PHONE_220323";

	/** 手机登录时 存在 token 对象 key */
	private final static String KEY_TOKEN_PHONE = "TOKEN_PHONE_2203231641";
	/** 账号登录时 存在 token 对象 key */
	private final static String KEY_TOKEN_ACCOUNT = "TOKEN_ACCOUNT_2203231829";
	/** 其他登录时 存在 token 对象 key */
	private final static String KEY_TOKEN_OTHER = "TOKEN_OTHER_2203231830";

	private final static String KEY_PHONE_CACHE_TIME = "PHONE_TIME_2203262148";

	@Resource
	private UserService userService;

	@Resource
	private UserBindService userBindService;
	@Resource
	private UserInfoService userInfoService;

	@Resource
	private CommentService commentService;
	@Resource
	private FollowService followService;
	@Resource
	private PostService postService;

	@GetMapping("/test")
	@Valid
	public JSONResult<UserParam> index1(HttpServletResponse response) throws IOException {

		return JSONResult.success("成功");
	}

	// 发送验证码
	@PostMapping("/sendcode")
	@Valid
	public JSONResult<UserParam> sendCode(
			@NotBlank(message = "手机号码不能为空！")
			@Phone
			String phone, HttpServletRequest request) {

		// 判断是否可用 ,返回 true 表示应该手机被禁用
		if (userService.isStatus(phone, PROPERTY.PHONE, 0)) {
			return JSONResult.fail(HttpStatusCode.ERR_USER_DISABLED);
		}
		//先判断手机号码 是否存在, 不存在就返回;
		UserParam _user = userService.findByPhone(phone);
		if (null == _user) {

			return JSONResult.fail(HttpStatusCode.ERR_PHONE_UNREGISTERED);
		}
		// 判断是否已经提交过
		LocalCache cache = LocalCache.getInstance();
		Object _objTime = cache.get(KEY_PHONE_CACHE_TIME);
		long _currTime = System.currentTimeMillis();
		if (null != _objTime) {
			long _oldTime = Long.parseLong(_objTime.toString());
			// 判断时间为 60秒
			if ((_currTime / 1000) - (_oldTime / 1000) <= 60) {

				return JSONResult.fail(HttpStatusCode.ERR_SEND_VERIFICATION_FAST);
			}
		}
		cache.put(KEY_PHONE_CACHE_TIME, _currTime);

		//生产 随机数
		StringBuffer code = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			int r = (int) (Math.random() * 10);
			code.append(r);
		}
		//把验证码存到 session 中
		HttpSession session = request.getSession();
		session.setAttribute(KEY_SESSION_PHONE_CODE, code);
		session.setAttribute(KEY_SESSION_PHONE, phone);

		//todo 后期更新 阿里大于
		AliSMSUtil.sendCode(phone, code.toString());

		//发送验证逻辑
		return JSONResult.success(MessageTools.createSMSTemplate(code + ""));
	}

	// 用户注册
	@PostMapping("/reg")
	@Valid
	public JSONResult<UserParam> reg(UserParam userParam) {
		//todo
		//判断是否重名
		if (userService.isRename(userParam.getUsername())) {

			return JSONResult.fail(HttpStatusCode.ERR_USER_NAME_BE_USED);
		}
		UserParam _user = userService.reg(userParam);
		return (null != _user) ?
				JSONResult.success(HttpStatusCode.SUCCESS_REGISTER.getMsg(), _user)
				: JSONResult.fail(HttpStatusCode.ERR_REGISTER);
	}

	// 手机登录
	@PostMapping("/phonelogin")
	@Valid
	public JSONResult<UserParam> phoneLogin(@NotBlank(message = "手机号不能为空！") String phone,
											@NotBlank(message = "验证码不能为空！") String code,
											HttpServletRequest request) {
		// 判断是否可用 ,返回 true 表示应该手机被禁用
		if (userService.isStatus(phone, PROPERTY.PHONE, 0)) {

			return JSONResult.fail(HttpStatusCode.ERR_USER_DISABLED);
		}
		//用手机号码 查找 为空表示该用户不存在
		UserParam _param = userService.findByPhone(phone);
		if (null == _param){
			return JSONResult.fail(HttpStatusCode.ERR_PHONE_UNREGISTERED);
		}
		//获取 session
		HttpSession session = request.getSession();
		//获取手机号码
		Object _phone = session.getAttribute(KEY_SESSION_PHONE);
		//获取 验证码
		Object _code = session.getAttribute(KEY_SESSION_PHONE_CODE);
		// 重复 判断 从 session 中找到相应的数据
		if(null == _phone || null == _code){
			return JSONResult.fail(HttpStatusCode.ERR_PHONE_UNREGISTERED);
		}
		// 判断 手机 与 验证码 相同
		if (phone.equals(_phone.toString()) && code.equals(_code.toString())) {
			//设置登录 类型
			_param.setLoginType(PROPERTY.PHONE);
			// token 工具类
			TokenTools _tokenTools = new TokenTools();
			//创建 token
			String token = _tokenTools.sign(KEY_TOKEN_PHONE, _param);
			// token 赋值到 _param 对象
			_param.setToken(token);
			// 把 _param 对象存在 session 中
			session.setAttribute(PROPERTY.SESSION_USER,_param);
			return JSONResult.success(phone + HttpStatusCode.SUCCESS_LOGIN.getMsg(), _param);
		}
		return JSONResult.fail(HttpStatusCode.ERR_PHONE_UNREGISTERED);
	}

	// 用户账户登录
	@PostMapping("/login")
	@Valid
	public JSONResult<UserParam> login(@NotBlank(message = "用户名不能为空！") String username,
									   @NotBlank(message = "密码不能为空！") String password,
									   HttpServletRequest request) {
		// 判断是否可用 ,返回 true 表示应该手机被禁用
		if (userService.isStatus(username, PROPERTY.ACCOUNT, PROPERTY.STATUS_0)) {

			return JSONResult.fail(HttpStatusCode.ERR_USER_DISABLED);
		}
		// 根据用户 和 密码 查找 ; 返回 为空表示 应该用户账号密码不正确 ;
		UserParam _param = userService.login(username, password);
		if (null == _param) {
			return JSONResult.fail(HttpStatusCode.ERR_USERNAME_PASSWORD_WRONG);
		}
		//设置登录 类型
		_param.setLoginType(PROPERTY.ACCOUNT);
		// token 工具类
		TokenTools tokenTools = new TokenTools();
		//创建 token
		String token = tokenTools.sign(KEY_TOKEN_ACCOUNT, _param);

		// token 赋值到 _param 对象
		_param.setToken(token);
		HttpSession session = request.getSession();
		// 把 _param 对象存在 session 中
		session.setAttribute(PROPERTY.SESSION_USER,_param);
		return JSONResult.success(username + HttpStatusCode.SUCCESS_LOGIN.getMsg(), _param);

	}

	// 第三方 登录
	@PostMapping("/otherlogin")
	@Valid
	public JSONResult<UserParam> otherLogin(UserBindParam param, HttpServletRequest request) {
		//todo
		HttpSession _session = request.getSession();
		// 第一次绑定,用户表没有记录,需要强制绑定手机号码;
		UserBindParam _ubp = userBindService.findByOpenIdAndType(param.getOpenId(), param.getType());
		UserParam _userParam = null;
		if (null != _ubp) {
			if (_ubp.getUserId() > 0) {
				_userParam = userService.findById(_ubp.getUserId());
			}
			if (null == _userParam) {
				_userParam = new UserParam();
				_userParam.getUserBindParams().add(_ubp);
				_userParam.setUsername(_ubp.getNickName());
				_userParam.setUserPic(_ubp.getAvatarUrl());
			}
			createUserParam(_userParam,param,_session);
			return JSONResult.success(_userParam);
		}
		// _userParam = new UserParam();
		// _userParam.setUsername(param.getNickName());
		// _userParam.setUserPic(param.getAvatarUrl());
		param.setUserId(0);
		param = userBindService.add(param);
		if (null != param) {
			_userParam = new UserParam();
			_userParam.getUserBindParams().add(param);
			_userParam.setUsername(param.getNickName());
			_userParam.setUserPic(param.getAvatarUrl());
			createUserParam(_userParam,param,_session);
			return JSONResult.success(_userParam);
		}

		return JSONResult.fail(HttpStatusCode.ERR_BINDING);
	}
	// 创建用户对象 方法
	private void createUserParam(UserParam _userParam, UserBindParam param, HttpSession session) {
		_userParam.setLoginType(PROPERTY.OTHER);
		TokenTools tokenTools = new TokenTools();
		String token = tokenTools.sign(KEY_TOKEN_OTHER, _userParam, param.getExpiresIn());
		_userParam.setToken(token);
		session.setAttribute(PROPERTY.SESSION_USER,_userParam);
	}

	// 用户退出
	@PostMapping("/user/logout")
	public JSONResult<UserParam> logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(PROPERTY.SESSION_USER);
		return JSONResult.success(HttpStatusCode.SUCCESS_OUT_LOGIN.getMsg());
	}

	// 用户手机、邮箱 绑定
	@PostMapping("/user/bind")
	public JSONResult<UserParam> bind(String value,String type,
									  HttpServletRequest request) {
		if (!(PROPERTY.PHONE.equals(type) || PROPERTY.ACCOUNT.equals(type)
				|| PROPERTY.EMAIL.equals(type))) {
			return JSONResult.fail(HttpStatusCode.ERR_BINDING_NOT_FIND_TYPE);
		}
		//验证 手机号 和 邮箱地址
		Pattern pattern = null;
		Matcher matcher;
		if (PROPERTY.EMAIL.equals(type)) {
			pattern = Pattern.compile(Regulation.REGEX_EMAIL_ALL);
		}
		if (PROPERTY.PHONE.equals(type)) {
			pattern = Pattern.compile(Regulation.REGEX_PHONE);
		}
		if (PROPERTY.EMAIL.equals(type) || PROPERTY.PHONE.equals(type)) {
			matcher = pattern.matcher(value);
			//验证不通过
			if (!matcher.matches()) {
				return JSONResult.fail(
						((PROPERTY.PHONE.equals(type)) ? HttpStatusCode.ERR_PHONE.getCode() : HttpStatusCode.ERR_EMAIL.getCode()),
						(PROPERTY.PHONE.equals(type)) ? HttpStatusCode.ERR_PHONE.getMsg() : HttpStatusCode.ERR_EMAIL.getMsg());
			}
		}

		// 需要配置 AuthenticationInterceptor 拦截器,判断用户已经存到session中,否则可能转换异常
		UserParam _user = UserTools.getUserParam(request);

		//申明 值 和 类型 并赋值
		String _sessionType = _user.getLoginType();
		String _tmpType = ""; //临时类型
		String _tmpMsg = ""; //临时输出信息
		String _tmpValue = "";//临时值
		if (PROPERTY.EMAIL.equals(type)){
			_tmpType = PROPERTY.EMAIL;
			_tmpMsg = PROPERTY.NAME_EMAIL;
			_tmpValue = _user.getEmail();
		} else if (PROPERTY.PHONE.equals(type)) {
			_tmpType = PROPERTY.PHONE;
			_tmpMsg = PROPERTY.NAME_PHONE;
			_tmpValue = _user.getPhone();
		}

		// 判断 当前登录方式
		if (_tmpType.equals(_sessionType)) {
			return JSONResult.fail(HttpStatusCode.ERR_BINDING_HAS_BEEN_BOUND.getCode(),
					HttpStatusCode.ERR_BINDING_HAS_BEEN_BOUND.getMsg() + _tmpMsg);
		}

		// 判断当前用户的有没有绑定
		if (null != _tmpValue && !"".equals(_tmpValue)) {
			return JSONResult.fail(HttpStatusCode.ERR_BINDING_HAS_BEEN_BOUND.getCode(),
					HttpStatusCode.ERR_BINDING_HAS_BEEN_BOUND.getMsg() + _tmpMsg);
		}
		_tmpValue = value;
		if (PROPERTY.EMAIL.equals(type)){
			// 判断该 邮箱 是否绑定了其他用户
			if (userService.isBindEmail(_user.getId(),_tmpValue)) {
				return JSONResult.fail(HttpStatusCode.ERR_BINDING_HAS_BEEN_BOUND.getCode(),
						HttpStatusCode.ERR_BINDING_HAS_BEEN_BOUND.getMsg() + _tmpMsg);
			}
			_user.setEmail(_tmpValue);
			if (userService.updateEmail(_user)) {
				return JSONResult.success(_tmpMsg + HttpStatusCode.SUCCESS_BINDING);
			}
		} else if (PROPERTY.PHONE.equals(type)) {
			// 判断该手机是否绑定了其他用户
			if (userService.isBindPhone(_user.getId(),_tmpValue)) {
				return JSONResult.fail(HttpStatusCode.ERR_BINDING_HAS_BEEN_BOUND.getCode(),
						HttpStatusCode.ERR_BINDING_HAS_BEEN_BOUND.getMsg() + _tmpMsg);
			}
			_user.setPhone(_tmpValue);
			if (userService.updatePhone(_user)) {
				return JSONResult.success(_tmpMsg + HttpStatusCode.SUCCESS_BINDING);
			}
		}
		return JSONResult.fail(HttpStatusCode.ERR_BINDING.getCode(), _tmpMsg + HttpStatusCode.ERR_BINDING.getMsg());
	}

	// 绑定第三方账号; 需要 类型有 {qq,weixin,sinaweibo}
	@PostMapping("/user/bindother")
	public JSONResult<UserParam> bindOther(UserBindParam param, HttpServletRequest request) {
		// 需要配置 AuthenticationInterceptor 拦截器,判断用户已经存到session中,否则可能转换异常
		UserParam _user = UserTools.getUserParam(request);
		//绑定多个账号
		List<UserBindParam> _userBindParams = _user.getUserBindParams();
		if (null != _userBindParams) {
			//
			for (UserBindParam _p : _userBindParams) {
				if (_p.getType().equals(param.getType())) {
					return JSONResult.fail(HttpStatusCode.ERR_BINDING_HAS_BEEN_BOUND);
				}
				//
				if (userBindService.isBindOther(_user.getId(),
						_p.getOpenId(), _p.getType())) {
					return JSONResult.fail(HttpStatusCode.ERR_BINDING_HAS_BEEN_BOUND);
				}
			}

		}
		// if (userBindService.insert(param)) {
		//     return JSONResult.success(StatusCode.SUCCESS_BINDING.getMsg());
		// }

		return JSONResult.fail(HttpStatusCode.ERR_BINDING);
	}

	// 搜索用户
	@PostMapping("/search")
	public JSONResult<List<UserParam>> search(
			@NotBlank(message = "搜索字段不能为空！") String keyword,
			@Min(message = "要大于0的数！") int pageNo){

		return JSONResult.success(userService.search(keyword,new PageQuery(pageNo)));
	}
	// ****************************************************************************************** //

	// 编辑用户头像
	@PostMapping("/user/edituserpic")
	public JSONResult editUserPic(MultipartFile file, HttpServletRequest request) {
		UserParam _user = UserTools.getUserParam(request);
		String _path = null;
		if (null == file) {
			return JSONResult.fail(HttpStatusCode.ERR_NOT_OTHER);
		}
		try {
			_path = ImageProcessing.execute(file.getInputStream(),
					file.getOriginalFilename(), PROPERTY.PATH_IMG_AVATAR, null);
		} catch (IOException e) {
			e.printStackTrace();
			return JSONResult.fail(HttpStatusCode.ERR_ERROR_FILE);
		}
		try {
			if (userService.updateUserPic(_user.getId(), _path)) {

				return JSONResult.success(HttpStatusCode.SUCCESS_AVATAR_UPDATE.getMsg(), _path);
			}
		} catch (Exception e) {

		}finally {
			//删除头像
			FileTools.delFile(PROPERTY.PATH_IMG_AVATAR + _path);
		}

		return JSONResult.fail(HttpStatusCode.ERR_AVATAR_UPDATE);
	}

	// 编辑用户资料
	@Valid
	@PostMapping("/user/edituserinfo")
	public JSONResult<UserInfoParam> editUserInfo(UserInfoParam param, HttpServletRequest request) {
		UserParam _user = UserTools.getUserParam(request);
		param.setUserId(_user.getId());
		if (userInfoService.updateUserInfo(param)) {
			return JSONResult.success(HttpStatusCode.SUCCESS_USER_UPDATE.getMsg(), param);
		}
		return JSONResult.fail(HttpStatusCode.ERR_USER_UPDATE);
	}

	// 修改用户密码
	@Valid
	@PostMapping("/user/repassword")
	public JSONResult<UserParam> editPassword(
			@NotBlank(message = "旧密码不能为空！")
			@Length(min = 6,max = 20,message = "密码长度为6~20的字符!")
			String oldPassword,
			@NotBlank(message = "新密码不能为空！")
			@Length(min = 6,max = 20,message = "密码长度为6~20的字符!")
			String newPassword,
			@NotBlank(message = "确认密码不能为空！")
			String confirmPassword, HttpServletRequest request) {
		UserParam _user = UserTools.getUserParam(request);
		// 从数据库中找出的密码
		String _dPW = userService.findPasswordById(_user.getId(), oldPassword);
		// 判断旧密码是否正确
		if (null == _dPW) {
			return JSONResult.fail(HttpStatusCode.ERR_OLD_PASSWORD);
		}
		if (!newPassword.equals(confirmPassword)) {
			return JSONResult.fail(HttpStatusCode.ERR_CONFIRM_PASSWORD);
		}
		if (_dPW.equals(userService.encryptPW(newPassword))) {
			return JSONResult.fail(HttpStatusCode.ERR_NEW_OLD_PASSWORD);
		}
		if (userService.updatePassword(_user.getId(),newPassword)) {
			return JSONResult.success(HttpStatusCode.SUCCESS_PASSWORD_UPDATE.getMsg());
		}

		return JSONResult.fail(HttpStatusCode.ERR_PASSWORD_UPDATE);
	}
}