package cn.peyton.children.chatter.pojo;


import java.io.Serializable;
/**
 * <h3> 话题分类 实体类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class TopicClass implements Serializable {
	/** 编号  */
	private Integer id;
	/** 名称  */
	private String className;
	/** 0 禁用 1启用  */
	private Integer status;
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
	 * @param className 名称 
	 */ 
	public void setClassName(String className){
		this.className = className;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getClassName(){
		return className;
	}

	/** 
	 * @param status 0 禁用 1启用 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 0 禁用 1启用 
	 */ 
	public Integer getStatus(){
		return status;
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
