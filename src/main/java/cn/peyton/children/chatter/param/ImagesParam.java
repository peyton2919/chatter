package cn.peyton.children.chatter.param;


import cn.peyton.children.chatter.pojo.Images;
import cn.peyton.core.inf.BaseConvertBo;

import java.io.Serializable;
/**
 * <h3> 图片 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class ImagesParam implements Serializable {
	/** 编号  */
	private Integer id;
	/** 链接地址  */
	private String url;
	/** 创建时间  */
	private String createTime;
	/** 用户编号  */
	private Integer userId;

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
	 * @param userId 用户编号 
	 */ 
	public void setUserId(Integer userId){
		this.userId = userId;
	}

	/** 
	 * @return 用户编号 
	 */ 
	public Integer getUserId(){
		return userId;
	}

	/**
	 * <h4>对象转成Images对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,url,createTime,userId]
	 * </pre>
	 */
	public Images convert(){
		Images images = new Images(); 
		images.setId(id);
		images.setUrl(url);
		images.setCreateTime(BaseConvertBo.convertStrToInt(createTime));
		images.setUserId(userId);
		return images;
	} 
	/**
	 * <h4>Images对象转成ImagesParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,url,createTime,userId]
	 * </pre>
	 */
	public ImagesParam compat(Images images){ 
		if(null == images){
			return new ImagesParam();
		}
		this.setId(images.getId());
		this.setUrl(images.getUrl());
		this.setCreateTime(BaseConvertBo.convertIntToStr(images.getCreateTime()));
		this.setUserId(images.getUserId());
		return this;
	} 
}
