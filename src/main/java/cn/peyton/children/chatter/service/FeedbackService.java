package cn.peyton.children.chatter.service;

import cn.peyton.children.chatter.param.FeedbackParam;
import cn.peyton.core.page.PageQuery;

import java.util.List;

/**
 * <h3> 反馈 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
 */
public interface FeedbackService {
    /**
     * <h4>添加反馈信息</h4>
     * @param param 反馈对象
     * @return true 表示 添加成功; false 表示 取反
     */
    boolean create(FeedbackParam param);

    /**
     * <h4>获取用户反馈列表</h4>
     * @param page 分页对象
     * @return
     */
    List<FeedbackParam> finds(PageQuery page);

}
