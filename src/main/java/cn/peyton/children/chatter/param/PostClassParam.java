package cn.peyton.children.chatter.param;


import cn.peyton.children.chatter.pojo.PostClass;
import cn.peyton.core.inf.BaseConvertBo;
import cn.peyton.core.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * <h3> 帖子分类 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class PostClassParam implements Serializable {
	/** 编号  */
	private Integer id;
	/** 类型名称  */
	@NotBlank(message = "名称不能为空")
	private String className;
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
	 * @param className 类型名称 
	 */ 
	public void setClassName(String className){
		this.className = className;
	}

	/** 
	 * @return 类型名称 
	 */ 
	public String getClassName(){
		return className;
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
	 * <h4>对象转成PostClass对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,className,status,createTime]
	 * </pre>
	 */
	public PostClass convert(){
		PostClass postClass = new PostClass(); 
		postClass.setId(id);
		postClass.setClassName(className);
		postClass.setCreateTime(BaseConvertBo.convertStrToInt(createTime));
		return postClass;
	} 
	/**
	 * <h4>PostClass对象转成PostClassParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,className,status,createTime]
	 * </pre>
	 */
	public PostClassParam compat(PostClass postClass){ 
		if(null == postClass){
			return new PostClassParam();
		}
		this.setId(postClass.getId());
		this.setClassName(postClass.getClassName());
		this.setCreateTime(BaseConvertBo.convertIntToStr(postClass.getCreateTime()));
		return this;
	}


}
