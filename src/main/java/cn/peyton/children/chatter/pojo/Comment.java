package cn.peyton.children.chatter.pojo;


import java.io.Serializable;
/**
 * <h3> 评论 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class Comment implements Serializable {
	/** 编号  */
	private Integer id;
	/** 发布人  */
	private Integer userId;
	/** 回复id  */
	private Integer fId;
	/** 被回复数  */
	private Integer fnum;
	/** 数据  */
	private String data;
	/** 创建时间  */
	private Integer createTime;
	/** post编号  */
	private Integer postId;

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
	 * @param fId 回复id 
	 */ 
	public void setFId(Integer fId){
		this.fId = fId;
	}

	/** 
	 * @return 回复id 
	 */ 
	public Integer getFId(){
		return fId;
	}

	/** 
	 * @param fnum 被回复数 
	 */ 
	public void setFnum(Integer fnum){
		this.fnum = fnum;
	}

	/** 
	 * @return 被回复数 
	 */ 
	public Integer getFnum(){
		return fnum;
	}

	/** 
	 * @param data 数据 
	 */ 
	public void setData(String data){
		this.data = data;
	}

	/** 
	 * @return 数据 
	 */ 
	public String getData(){
		return data;
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
	 * @param postId post编号 
	 */ 
	public void setPostId(Integer postId){
		this.postId = postId;
	}

	/** 
	 * @return post编号 
	 */ 
	public Integer getPostId(){
		return postId;
	}

}
