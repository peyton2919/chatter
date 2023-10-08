package cn.peyton.children.chatter.param;


import cn.peyton.children.chatter.pojo.AppUpdate;
import cn.peyton.core.inf.BaseConvertBo;
import cn.peyton.core.validator.constraints.NotBlank;

import java.io.Serializable;
/**
 * <h3> 更新 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class AppUpdateParam implements Serializable {
	/** 编号  */
	private Integer id;
	/** 链接地址  */
	private String url;
	/** 版本号  */
	@NotBlank(message = "版本号不能为空！")
	private String version;
	/** 0未上线 1上线  */
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
	 * @param url 链接地址 
	 */ 
	public void setUrl(String url){
		this.url = url;
	}

	/** 
	 * @return 链接地址 
	 */ 
	public String getUrl(){
		return url;
	}

	/** 
	 * @param version 版本号 
	 */ 
	public void setVersion(String version){
		this.version = version;
	}

	/** 
	 * @return 版本号 
	 */ 
	public String getVersion(){
		return version;
	}

	/** 
	 * @param status 0未上线 1上线 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 0未上线 1上线 
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
	 * <h4>对象转成AppUpdate对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,url,version,status,createTime]
	 * </pre>
	 */
	public AppUpdate convert(){
		AppUpdate appUpdate = new AppUpdate(); 
		appUpdate.setId(id);
		appUpdate.setUrl(url);
		appUpdate.setVersion(version);
		appUpdate.setStatus(status);
		appUpdate.setCreateTime(BaseConvertBo.convertStrToInt(createTime));
		return appUpdate;
	} 
	/**
	 * <h4>AppUpdate对象转成AppUpdateParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,url,version,status,createTime]
	 * </pre>
	 */
	public AppUpdateParam compat(AppUpdate appUpdate){ 
		if(null == appUpdate){
			return new AppUpdateParam();
		}
		this.setId(appUpdate.getId());
		this.setUrl(appUpdate.getUrl());
		this.setVersion(appUpdate.getVersion());
		this.setStatus(appUpdate.getStatus());
		this.setCreateTime(BaseConvertBo.convertIntToStr(appUpdate.getCreateTime()));
		return this;
	} 
}
