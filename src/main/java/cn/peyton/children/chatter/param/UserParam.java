package cn.peyton.children.chatter.param;

import cn.peyton.children.chatter.aop.img.ImageHostPath;
import cn.peyton.children.chatter.pojo.User;
import cn.peyton.children.chatter.pojo.UserBind;
import cn.peyton.children.chatter.pojo.UserInfo;
import cn.peyton.core.toolkit.DateTools;
import cn.peyton.core.toolkit.base.Lists;
import cn.peyton.core.validator.constraints.*;

import java.io.Serializable;
import java.util.List;

/**
 * <h3> 用户信息 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@ImageHostPath(name = "userPic")
public class UserParam implements Serializable {
	/** 编号  */
	private Integer id;
	/** 名字  */
	@NotBlank(message = "用户名称不能为空！")
	@Length(min = 4,max = 30,message = "用户名称长度为4~30个字符！")
	private String username;
	/** 头像  */
	private String userPic;
	/** 密码  */
	@NotBlank(message = "用户密码不能为空！")
	@Length(min = 6,max=30,message = "用户密码长度为6~30个字符！")
	private String password;
	/** 确认密码  */
	@NotBlank(message = "确认密码不能为空！")
	@Alike(fieldName = "password")
	private String confirmPwd;
	/** 手机  */
	@Phone
	private String phone;
	/** 邮箱  */
	@Email
	private String email;
	/** 0 禁用 1启用  */
	private Integer status;
	/** 创建时间  */
	private String createTime;

	// 附加
	/** 用户登录类型 */
	private String loginType;
	/** token 值 */
	private String token;
	/** 用户扩展信息  */
	private UserInfoParam userInfoParam;
	/** 用户绑定对象 */
	private List<UserBindParam> userBindParams;

	//================================== Constructor =======================================//
	public UserParam() {
		if (null == userInfoParam) {
			userInfoParam = new UserInfoParam();
		}
		if (null == userBindParams) {
			userBindParams = Lists.newArrayList();
		}
	}

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 编号 
	 */ 
	public void setId(Integer id){
		this.id = id;
	}

	/** 
	 * @return 编号 
	 */ 
	public Integer getId(){
		return id;
	}

	/** 
	 * @param username 名字 
	 */ 
	public void setUsername(String username){
		this.username = username;
	}

	/** 
	 * @return 名字 
	 */ 
	public String getUsername(){
		return username;
	}

	/** 
	 * @param userPic 头像 
	 */ 
	public void setUserPic(String userPic){
		this.userPic = userPic;
	}

	/** 
	 * @return 头像 
	 */ 
	public String getUserPic(){
		return userPic;
	}

	/** 
	 * @param password 密码 
	 */ 
	public void setPassword(String password){
		this.password = password;
	}

	/** 
	 * @return 密码 
	 */ 
	public String getPassword(){
		return password;
	}

	/**
	 * @return 确认密码
	 */
	public String getConfirmPwd() {
		return confirmPwd;
	}

	/**
	 * @param confirmPwd 确认密码
	 */
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	/** 
	 * @param phone 手机 
	 */ 
	public void setPhone(String phone){
		this.phone = phone;
	}

	/** 
	 * @return 手机 
	 */ 
	public String getPhone(){
		return phone;
	}

	/** 
	 * @param email 邮箱 
	 */ 
	public void setEmail(String email){
		this.email = email;
	}

	/** 
	 * @return 邮箱 
	 */ 
	public String getEmail(){
		return email;
	}

	/** 
	 * @param status 0 禁用 1启用 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 0 禁用 1启用 
	 */ 
	public Integer getStatus(){
		return status;
	}

	/** 
	 * @param createTime 创建时间 
	 */ 
	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public String getCreateTime(){
		return createTime;
	}

	/**
	 * @return 用户登录类型
	 */
	public String getLoginType() {
		return loginType;
	}

	/**
	 * @param loginType 用户登录类型
	 */
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	/**
	 * @return token 值
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token token 值
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return 用户扩展信息
	 */
	public UserInfoParam getUserInfoParam() {
		return userInfoParam;
	}

	/**
	 * @param userInfoParam 用户扩展信息
	 */
	public void setUserInfoParam(UserInfoParam userInfoParam) {
		this.userInfoParam = userInfoParam;
	}

	/**
	 * @return 用户绑定对象
	 */
	public List<UserBindParam> getUserBindParams() {
		return userBindParams;
	}

	/**
	 * @param userBindParams 用户绑定对象
	 */
	public void setUserBindParams(List<UserBindParam> userBindParams) {
		this.userBindParams = userBindParams;
	}

	/**
	 * <h4>对象转成User对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,username,userPic,password,phone,email,status,createTime]
	 * </pre>
	 */
	public User convert(){
		User user = new User(); 
		user.setId(id);
		user.setUsername(username);
		user.setUserPic(userPic);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		user.setStatus(status);
		user.setCreateTime(DateTools.dateToTimestamp(createTime));
		user.setUserInfo((null != userInfoParam) ? userInfoParam.convert() : new UserInfo());
		if (null != userBindParams) {
			for (UserBindParam _param : userBindParams) {
				// UserBindParam 转成 UserBind, 并添加到集合里
				user.getUserBinds().add(_param.convert());
			}
		}
		return user;
	} 
	/**
	 * <h4>User对象转成UserParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,username,userPic,password,phone,email,status,createTime]
	 * </pre>
	 */
	public UserParam compat(User user){ 
		if(null == user){
			return new UserParam();
		}
		this.setId(user.getId());
		this.setUsername(user.getUsername());
		this.setUserPic(user.getUserPic());
		this.setPassword(user.getPassword());
		this.setPhone(user.getPhone());
		this.setEmail(user.getEmail());
		this.setStatus(user.getStatus());
		this.setCreateTime(DateTools.timestampToStrDate(user.getCreateTime()));
		this.setUserInfoParam(new UserInfoParam().compat(user.getUserInfo()));
		if (null != user.getUserBinds()) {
			for (UserBind _ub : user.getUserBinds()) {
				// UserBind 转成 UserBindParam, 并添加到集合里
				this.getUserBindParams().add(new UserBindParam().compat(_ub));
			}
		}
		return this;
	} 
}
