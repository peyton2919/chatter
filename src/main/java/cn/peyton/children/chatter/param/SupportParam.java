package cn.peyton.children.chatter.param;


import cn.peyton.children.chatter.pojo.Support;
import cn.peyton.core.inf.BaseConvertBo;
import cn.peyton.core.validator.constraints.Size;

import java.io.Serializable;
/**
 * <h3> 支持 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class SupportParam implements Serializable {
	/** 编号  */
	private Integer id;
	/** 发布人  */
	private Integer userId;
	/** 帖子id  */
	private Integer postId;
	/** 0 顶 1踩  */
	@Size(min = 0,max = 1,message = "数值超出规定范围！")
	private Integer type;
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
	 * <h4>对象转成Support对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,userId,postId,type,createTime]
	 * </pre>
	 */
	public Support convert(){ 
		Support support = new Support();
		support.setId(id);
		support.setUserId(userId);
		support.setPostId(postId);
		support.setType(type);
		support.setCreateTime(BaseConvertBo.convertStrToInt(createTime));
		return support;
	} 
	/**
	 * <h4>Support对象转成SupportParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,userId,postId,type,createTime]
	 * </pre>
	 */
	public SupportParam compat(Support support){ 
		if(null == support){
			return new SupportParam();
		}
		this.setId(support.getId());
		this.setUserId(support.getUserId());
		this.setPostId(support.getPostId());
		this.setType(support.getType());
		this.setCreateTime(BaseConvertBo.convertIntToStr(support.getCreateTime()));
		return this;
	} 
}
