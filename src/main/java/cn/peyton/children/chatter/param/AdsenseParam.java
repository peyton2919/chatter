package cn.peyton.children.chatter.param;


import cn.peyton.children.chatter.pojo.Adsense;

import java.io.Serializable;
/**
 * <h3> 广告 参数 传递类[用来展示数据]类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public class AdsenseParam implements Serializable {
	/** 编号  */
	private Integer id;
	/** 地址  */
	private String src;
	/** 链接地址  */
	private String url;
	/** 0 动态轮播图 1个人中心  */
	private Integer type;
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
	 * @param src 地址 
	 */ 
	public void setSrc(String src){
		this.src = src;
	}

	/** 
	 * @return 地址 
	 */ 
	public String getSrc(){
		return src;
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
	 * @param type 0 动态轮播图 1个人中心 
	 */ 
	public void setType(Integer type){
		this.type = type;
	}

	/** 
	 * @return 0 动态轮播图 1个人中心 
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
	 * <h4>对象转成Adsense对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,src,url,type,createTime]
	 * </pre>
	 */
	public Adsense convert(){
		Adsense adsense = new Adsense(); 
		adsense.setId(id);
		adsense.setSrc(src);
		adsense.setUrl(url);
		adsense.setType(type);
		adsense.setCreateTime(createTime);
		return adsense;
	} 
	/**
	 * <h4>Adsense对象转成AdsenseParam对象<h4> 
	 * <pre>
	 * 	 转换字段如下:
	 * 	 [id,src,url,type,createTime]
	 * </pre>
	 */
	public AdsenseParam compat(Adsense adsense){ 
		if(null == adsense){
			return new AdsenseParam();
		}
		this.setId(adsense.getId());
		this.setSrc(adsense.getSrc());
		this.setUrl(adsense.getUrl());
		this.setType(adsense.getType());
		this.setCreateTime(adsense.getCreateTime());
		return this;
	} 
}
