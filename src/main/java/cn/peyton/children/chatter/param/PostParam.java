package cn.peyton.children.chatter.param;


import cn.peyton.children.chatter.pojo.Post;

import java.io.Serializable;
/**
 * <h3> 帖子 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class PostParam implements Serializable {
	/** 编号  */
	private Integer id;
	/** 发布人  */
	private Integer userId;
	/** 标题  */
	private String title;
	/** 标题图片  */
	private String titlePic;
	/** 内容  */
	private String content;
	/** 分享数  */
	private Integer shareNum;
	/** 路径  */
	private String path;
	/** 0 图文 1分享  */
	private Integer type;
	/** 创建时间  */
	private Integer createTime;
	/** post类型编号  */
	private Integer postClassId;
	/** 共享编号  */
	private Integer shareId;
	/** 1开放，0仅自己可见  */
	private Integer isOpen;

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
	 * @param title 标题 
	 */ 
	public void setTitle(String title){
		this.title = title;
	}

	/** 
	 * @return 标题 
	 */ 
	public String getTitle(){
		return title;
	}

	/** 
	 * @param titlePic 标题图片 
	 */ 
	public void setTitlePic(String titlePic){
		this.titlePic = titlePic;
	}

	/** 
	 * @return 标题图片 
	 */ 
	public String getTitlePic(){
		return titlePic;
	}

	/** 
	 * @param content 内容 
	 */ 
	public void setContent(String content){
		this.content = content;
	}

	/** 
	 * @return 内容 
	 */ 
	public String getContent(){
		return content;
	}

	/** 
	 * @param shareNum 分享数 
	 */ 
	public void setShareNum(Integer shareNum){
		this.shareNum = shareNum;
	}

	/** 
	 * @return 分享数 
	 */ 
	public Integer getShareNum(){
		return shareNum;
	}

	/** 
	 * @param path 路径 
	 */ 
	public void setPath(String path){
		this.path = path;
	}

	/** 
	 * @return 路径 
	 */ 
	public String getPath(){
		return path;
	}

	/** 
	 * @param type 0 图文 1分享 
	 */ 
	public void setType(Integer type){
		this.type = type;
	}

	/** 
	 * @return 0 图文 1分享 
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

	/** 
	 * @param postClassId post类型编号 
	 */ 
	public void setPostClassId(Integer postClassId){
		this.postClassId = postClassId;
	}

	/** 
	 * @return post类型编号 
	 */ 
	public Integer getPostClassId(){
		return postClassId;
	}

	/** 
	 * @param shareId 共享编号 
	 */ 
	public void setShareId(Integer shareId){
		this.shareId = shareId;
	}

	/** 
	 * @return 共享编号 
	 */ 
	public Integer getShareId(){
		return shareId;
	}

	/** 
	 * @param isOpen 1开放，0仅自己可见 
	 */ 
	public void setIsOpen(Integer isOpen){
		this.isOpen = isOpen;
	}

	/** 
	 * @return 1开放，0仅自己可见 
	 */ 
	public Integer getIsOpen(){
		return isOpen;
	}

	/**
	 * <h4>对象转成Post对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,userId,title,titlePic,content,shareNum,path,type,createTime,postClassId,shareId,isOpen]
	 * </pre>
	 */
	public Post convert(){
		Post post = new Post(); 
		post.setId(id);
		post.setUserId(userId);
		post.setTitle(title);
		post.setTitlePic(titlePic);
		post.setContent(content);
		post.setShareNum(shareNum);
		post.setPath(path);
		post.setType(type);
		post.setCreateTime(createTime);
		post.setPostClassId(postClassId);
		post.setShareId(shareId);
		post.setIsOpen(isOpen);
		return post;
	} 
	/**
	 * <h4>Post对象转成PostParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,userId,title,titlePic,content,shareNum,path,type,createTime,postClassId,shareId,isOpen]
	 * </pre>
	 */
	public PostParam compat(Post post){ 
		if(null == post){
			return new PostParam();
		}
		this.setId(post.getId());
		this.setUserId(post.getUserId());
		this.setTitle(post.getTitle());
		this.setTitlePic(post.getTitlePic());
		this.setContent(post.getContent());
		this.setShareNum(post.getShareNum());
		this.setPath(post.getPath());
		this.setType(post.getType());
		this.setCreateTime(post.getCreateTime());
		this.setPostClassId(post.getPostClassId());
		this.setShareId(post.getShareId());
		this.setIsOpen(post.getIsOpen());
		return this;
	} 
}
