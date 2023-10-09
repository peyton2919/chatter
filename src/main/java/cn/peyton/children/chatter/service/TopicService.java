package cn.peyton.children.chatter.service;

import cn.peyton.children.chatter.param.TopicParam;
import cn.peyton.core.page.PageQuery;

import java.util.List;

/**
 * <h3> 话题 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface TopicService {

    /**
     * <h4>添加话题</h4>
     * @param param 话题对象
     * @return
     */
    boolean add(TopicParam param);

    /**
     * <h4>判断 重名</h4>
     * @param title 标题
     * @param classId 话题分类id
     * @return 重名返回 true
     */
    boolean isRename(String title, Integer classId);

    /**
     * <h4>获取指定话题分类下的话题列表</h4>
     * @param topicClassId 话题分类编号
     * @param page 分页对象
     * @return
     */
    List<TopicParam> findByTopicId(int topicClassId, PageQuery page);

    /**
     * <h4>获取 热门的话题 </h4>
     * @param topicClassId 话题分类编号
     * @param page 分页对象
     * @return
     */
    List<TopicParam> findByHot(int topicClassId,PageQuery page);

    /**
     * <h4>搜索话题</h4>
     * @param keyword 关键字
     * @param page 分页对象
     * @return
     */
    List<TopicParam> search(String keyword, PageQuery page);
}
