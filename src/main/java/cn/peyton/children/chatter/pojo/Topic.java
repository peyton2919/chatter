package cn.peyton.children.chatter.pojo;


import java.io.Serializable;
/**
 * <h3> 话题 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class Topic implements Serializable {
	/** 编号  */
	private Integer id;
	/** 标题  */
	private String title;
	/** 标题图片  */
	private String titlePic;
	/** 描述  */
	private String desc;
	/** 0 禁用 1启用  */
	private Integer type;
	/** 创建时间  */
	private Integer createTime;
	/** 话题类型编号  */
	private Integer topicClassId;

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
	 * @param desc 描述 
	 */ 
	public void setDesc(String desc){
		this.desc = desc;
	}

	/** 
	 * @return 描述 
	 */ 
	public String getDesc(){
		return desc;
	}

	/** 
	 * @param type 0 禁用 1启用 
	 */ 
	public void setType(Integer type){
		this.type = type;
	}

	/** 
	 * @return 0 禁用 1启用 
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
	 * @param topicClassId 话题类型编号 
	 */ 
	public void setTopicClassId(Integer topicClassId){
		this.topicClassId = topicClassId;
	}

	/** 
	 * @return 话题类型编号 
	 */ 
	public Integer getTopicClassId(){
		return topicClassId;
	}

}
