package cn.peyton.children.chatter.service;

import cn.peyton.children.chatter.param.AdsenseParam;
import cn.peyton.children.chatter.pojo.Adsense;
import cn.peyton.core.page.PageQuery;

import java.util.List;

/**
 * <h3> 广告 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface AdsenseService {

    Adsense findById(Integer id);

    /**
     * <h4>根据 类型 查找 广告对象集合</h4>
     * @param type 类型
     * @param page 分页对象
     * @return
     */
    List<AdsenseParam> findByType(Integer type, PageQuery page);

}
