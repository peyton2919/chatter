package cn.peyton.children.chatter.service;

import cn.peyton.children.chatter.param.TopicClassParam;

import java.util.List;

/**
 * <h3> 话题分类 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface TopicClassService {

    /**
     * <h4>获取话题分类</h4>
     * @return 话题对象集合
     */
    List<TopicClassParam> finds();
}
