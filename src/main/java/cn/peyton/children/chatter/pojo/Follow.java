package cn.peyton.children.chatter.pojo;


import java.io.Serializable;
/**
 * <h3> 关注 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class Follow implements Serializable {
	/** 编号  */
	private Integer id;
	/** 被关注用户  */
	private User followUser;
	/** 用户id  */
	private Integer userId;
	/** 创建时间  */
	private Integer createTime;

	//================================== Constructor =======================================//
	public Follow() {
		if (null == followUser) {
			followUser = new User();
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
	 * @return 被关注用户
	 */
	public User getFollowUser() {
		return followUser;
	}
	/**
	 * @param followUser 被关注用户
	 */
	public void setFollowUser(User followUser) {
		this.followUser = followUser;
	}

	/** 
	 * @param userId 用户id 
	 */ 
	public void setUserId(Integer userId){
		this.userId = userId;
	}

	/** 
	 * @return 用户id 
	 */ 
	public Integer getUserId(){
		return userId;
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
