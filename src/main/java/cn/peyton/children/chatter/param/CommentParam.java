package cn.peyton.children.chatter.param;


import cn.peyton.children.chatter.pojo.Comment;

import java.io.Serializable;
/**
 * <h3> 评论 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class CommentParam implements Serializable {
	/** 编号  */
	private Integer id;
	/** 发布人 用户对象userId  */
	private UserParam userParam;
	/** 评论父编号 0表示一级评论 不是0表示回复 */
	private Integer fId;
	/** 这条评论被回复数数 ;用来判断有没有下级  */
	private Integer fnum;
	/** 数据  */
	private String data;
	/** 创建时间  */
	private Integer createTime;
	/** post编号  */
	private Integer postId;

	//================================== Constructor =======================================//
	public CommentParam() {
		if (null == userParam) {
			userParam = new UserParam();
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
	 * @param userParam 发布人 用户对象userId
	 */
	public void setUserParam(UserParam userParam) {
		this.userParam = userParam;
	}

	/**
	 * @return 发布人 用户对象userId
	 */
	public UserParam getUserParam() {
		return userParam;
	}

	/**
	 * @param fId 评论父编号 0表示一级评论 不是0表示回复
	 */
	public void setFId(Integer fId) {
		this.fId = fId;
	}

	/**
	 * @return 评论父编号 0表示一级评论 不是0表示回复
	 */
	public Integer getFId() {
		return fId;
	}

	/**
	 * @param fnum 这条评论被回复数数 ;用来判断有没有下级
	 */
	public void setFnum(Integer fnum){
		this.fnum = fnum;
	}

	/**
	 * @return 这条评论被回复数数 ;用来判断有没有下级
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

	/**
	 * <h4>对象转成Comment对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,userId,fId,fnum,data,createTime,postId]
	 * </pre>
	 */
	public Comment convert(){
		Comment comment = new Comment(); 
		comment.setId(id);
		comment.setUser(getUserParam().convert());
		comment.setFId(fId);
		comment.setFnum(fnum);
		comment.setData(data);
		comment.setCreateTime(createTime);
		comment.setPostId(postId);
		return comment;
	} 
	/**
	 * <h4>Comment对象转成CommentParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,userId,fId,fnum,data,createTime,postId]
	 * </pre>
	 */
	public CommentParam compat(Comment comment){ 
		if(null == comment){
			return new CommentParam();
		}
		this.setId(comment.getId());
		this.setUserParam(new UserParam().compat(comment.getUser()));
		this.setFId(comment.getFId());
		this.setFnum(comment.getFnum());
		this.setData(comment.getData());
		this.setCreateTime(comment.getCreateTime());
		this.setPostId(comment.getPostId());
		return this;
	} 
}
