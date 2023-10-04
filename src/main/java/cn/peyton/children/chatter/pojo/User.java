package cn.peyton.children.chatter.pojo;

import java.io.Serializable;
/**
 * <h3> 用户信息 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class User implements Serializable {
	/** 编号  */
	private Integer id;
	/** 名字  */
	private String username;
	/** 头像  */
	private String userPic;
	/** 密码  */
	private String password;
	/** 手机  */
	private String phone;
	/** 邮箱  */
	private String email;
	/** 0 禁用 1启用  */
	private Integer status;
	/** 创建时间  */
	private Integer createTime;

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
	public void setCreateTime(Integer createTime){
		this.createTime = createTime;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Integer getCreateTime(){
		return createTime;
	}

}
