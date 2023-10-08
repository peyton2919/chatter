package cn.peyton.children.chatter.param;


import cn.peyton.children.chatter.pojo.TopicClass;
import cn.peyton.core.inf.BaseConvertBo;

import java.io.Serializable;
/**
 * <h3> 话题分类 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class TopicClassParam implements Serializable {
	/** 编号  */
	private Integer id;
	/** 名称  */
	private String className;
	/** 0 禁用 1启用  */
	private Integer status;
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
	 * <h4>对象转成TopicClass对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,className,status,createTime]
	 * </pre>
	 */
	public TopicClass convert(){
		TopicClass topicClass = new TopicClass(); 
		topicClass.setId(id);
		topicClass.setClassName(className);
		topicClass.setStatus(status);
		topicClass.setCreateTime(BaseConvertBo.convertStrToInt(createTime));
		return topicClass;
	} 
	/**
	 * <h4>TopicClass对象转成TopicClassParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,className,status,createTime]
	 * </pre>
	 */
	public TopicClassParam compat(TopicClass topicClass){ 
		if(null == topicClass){
			return new TopicClassParam();
		}
		this.setId(topicClass.getId());
		this.setClassName(topicClass.getClassName());
		this.setStatus(topicClass.getStatus());
		this.setCreateTime(BaseConvertBo.convertIntToStr(topicClass.getCreateTime()));
		return this;
	} 
}
