package cn.peyton.children.chatter.param;


import cn.peyton.children.chatter.pojo.Follow;

import java.io.Serializable;
/**
 * <h3> 关注 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class FollowParam implements Serializable {
	/** 编号  */
	private Integer id;
	/** 关注id  */
	private Integer followId;
	/** 用户id  */
	private Integer userId;
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
	 * @param followId 关注id 
	 */ 
	public void setFollowId(Integer followId){
		this.followId = followId;
	}

	/** 
	 * @return 关注id 
	 */ 
	public Integer getFollowId(){
		return followId;
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

	/**
	 * <h4>对象转成Follow对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,followId,userId,createTime]
	 * </pre>
	 */
	public Follow convert(){
		Follow follow = new Follow(); 
		follow.setId(id);
		follow.setFollowId(followId);
		follow.setUserId(userId);
		follow.setCreateTime(createTime);
		return follow;
	} 
	/**
	 * <h4>Follow对象转成FollowParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,followId,userId,createTime]
	 * </pre>
	 */
	public FollowParam compat(Follow follow){ 
		if(null == follow){
			return new FollowParam();
		}
		this.setId(follow.getId());
		this.setFollowId(follow.getFollowId());
		this.setUserId(follow.getUserId());
		this.setCreateTime(follow.getCreateTime());
		return this;
	} 
}
