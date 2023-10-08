package cn.peyton.children.chatter.param;


import cn.peyton.children.chatter.bo.UserBo;
import cn.peyton.children.chatter.pojo.Follow;
import cn.peyton.core.inf.BaseConvertBo;

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
	/** 被关注用户  */
	private UserParam followUserParam;
	/** 用户id  */
	private Integer userId;
	/** 创建时间  */
	private String createTime;

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
	 * @return 被关注用户
	 */
	public UserParam getFollowUserParam() {
		return followUserParam;
	}

	/**
	 * @param followUserParam 被关注用户
	 */
	public void setFollowUserParam(UserParam followUserParam) {
		this.followUserParam = followUserParam;
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
	 * <h4>对象转成Follow对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,followId,userId,createTime]
	 * </pre>
	 */
	public Follow convert(){
		Follow follow = new Follow(); 
		follow.setId(id);
		follow.setFollowUser(new UserBo().convert(this.getFollowUserParam()));
		follow.setUserId(userId);
		follow.setCreateTime(BaseConvertBo.convertStrToInt(createTime));
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
		this.setFollowUserParam(new UserBo().compat(follow.getFollowUser()));
		this.setUserId(follow.getUserId());
		this.setCreateTime(BaseConvertBo.convertIntToStr(follow.getCreateTime()));
		return this;
	} 
}
