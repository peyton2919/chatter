package cn.peyton.children.chatter.pojo;


import java.io.Serializable;
/**
 * <h3> 支持 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class Support implements Serializable {
	/** 编号  */
	private Integer id;
	/** 发布人  */
	private Integer userId;
	/** 帖子id  */
	private Integer postId;
	/** 0 顶 1踩  */
	private Integer type;
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
	 * @param userId 发布人 
	 */ 
	public void setUserId(Integer userId){
		this.userId = userId;
	}

	/** 
	 * @return 发布人 
	 */ 
	public Integer getUserId(){
		return userId;
	}

	/** 
	 * @param postId 帖子id 
	 */ 
	public void setPostId(Integer postId){
		this.postId = postId;
	}

	/** 
	 * @return 帖子id 
	 */ 
	public Integer getPostId(){
		return postId;
	}

	/** 
	 * @param type 0 顶 1踩 
	 */ 
	public void setType(Integer type){
		this.type = type;
	}

	/** 
	 * @return 0 顶 1踩 
	 */ 
	public Integer getType(){
		return type;
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
