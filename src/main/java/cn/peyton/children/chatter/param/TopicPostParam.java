package cn.peyton.children.chatter.param;


import cn.peyton.children.chatter.pojo.TopicPost;

import java.io.Serializable;
/**
 * <h3> 话题帖子关联 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class TopicPostParam implements Serializable {
	/** 编号  */
	private Integer id;
	/** 话题id  */
	private Integer topicId;
	/** 帖子id  */
	private Integer postId;
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
	 * @param topicId 话题id 
	 */ 
	public void setTopicId(Integer topicId){
		this.topicId = topicId;
	}

	/** 
	 * @return 话题id 
	 */ 
	public Integer getTopicId(){
		return topicId;
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
	 * <h4>对象转成TopicPost对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,topicId,postId,createTime]
	 * </pre>
	 */
	public TopicPost convert(){ 
		TopicPost topicPost = new TopicPost();
		topicPost.setId(id);
		topicPost.setTopicId(topicId);
		topicPost.setPostId(postId);
		topicPost.setCreateTime(createTime);
		return topicPost;
	} 
	/**
	 * <h4>TopicPost对象转成TopicPostParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,topicId,postId,createTime]
	 * </pre>
	 */
	public TopicPostParam compat(TopicPost topicPost){ 
		if(null == topicPost){
			return new TopicPostParam();
		}
		this.setId(topicPost.getId());
		this.setTopicId(topicPost.getTopicId());
		this.setPostId(topicPost.getPostId());
		this.setCreateTime(topicPost.getCreateTime());
		return this;
	} 
}
