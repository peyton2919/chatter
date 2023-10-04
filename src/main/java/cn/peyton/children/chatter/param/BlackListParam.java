package cn.peyton.children.chatter.param;


import cn.peyton.children.chatter.pojo.BlackList;

import java.io.Serializable;
/**
 * <h3> 拉黑集 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class BlackListParam implements Serializable {
	/** 编号  */
	private Integer id;
	/** 拉黑id  */
	private Integer blackId;
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
	 * @param blackId 拉黑id 
	 */ 
	public void setBlackId(Integer blackId){
		this.blackId = blackId;
	}

	/** 
	 * @return 拉黑id 
	 */ 
	public Integer getBlackId(){
		return blackId;
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
	 * <h4>对象转成BlackList对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,blackId,userId,createTime]
	 * </pre>
	 */
	public BlackList convert(){
		BlackList blackList = new BlackList(); 
		blackList.setId(id);
		blackList.setBlackId(blackId);
		blackList.setUserId(userId);
		blackList.setCreateTime(createTime);
		return blackList;
	} 
	/**
	 * <h4>BlackList对象转成BlackListParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,blackId,userId,createTime]
	 * </pre>
	 */
	public BlackListParam compat(BlackList blackList){ 
		if(null == blackList){
			return new BlackListParam();
		}
		this.setId(blackList.getId());
		this.setBlackId(blackList.getBlackId());
		this.setUserId(blackList.getUserId());
		this.setCreateTime(blackList.getCreateTime());
		return this;
	} 
}
