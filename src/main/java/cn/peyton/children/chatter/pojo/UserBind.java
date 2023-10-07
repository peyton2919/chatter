package cn.peyton.children.chatter.pojo;


import java.io.Serializable;
/**
 * <h3> 第三方登录信息 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class UserBind implements Serializable {
	/** 编号  */
	private Integer id;
	/** 类型 对应第三方的 provider  */
	private String type;
	/** 开放编号  */
	private String openId;
	/** 用户编号  */
	private Integer userId;
	/** 昵称  */
	private String nickName;
	/** 头像地址  */
	private String avatarUrl;

	//================================== Constructor =======================================//

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
	 * @param type 类型 对应第三方的 provider
	 */ 
	public void setType(String type){
		this.type = type;
	}

	/** 
	 * @return 类型 对应第三方的 provider
	 */ 
	public String getType(){
		return type;
	}

	/** 
	 * @param openId 开放编号 
	 */ 
	public void setOpenId(String openId){
		this.openId = openId;
	}

	/** 
	 * @return 开放编号 
	 */ 
	public String getOpenId(){
		return openId;
	}

	/** 
	 * @param userId 用户编号 
	 */ 
	public void setUserId(Integer userId){
		this.userId = userId;
	}

	/** 
	 * @return 用户编号 
	 */ 
	public Integer getUserId(){
		return userId;
	}

	/** 
	 * @param nickName 昵称 
	 */ 
	public void setNickName(String nickName){
		this.nickName = nickName;
	}

	/** 
	 * @return 昵称 
	 */ 
	public String getNickName(){
		return nickName;
	}

	/** 
	 * @param avatarUrl 头像地址 
	 */ 
	public void setAvatarUrl(String avatarUrl){
		this.avatarUrl = avatarUrl;
	}

	/** 
	 * @return 头像地址 
	 */ 
	public String getAvatarUrl(){
		return avatarUrl;
	}

}
