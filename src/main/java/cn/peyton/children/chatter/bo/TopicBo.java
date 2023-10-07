package cn.peyton.children.chatter.bo;

import cn.peyton.children.chatter.param.TopicParam;
import cn.peyton.children.chatter.pojo.Topic;
import cn.peyton.core.inf.BaseConvertBo;

/**
 * <h3>话题 传换类 .bo</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.chatter.bo.TopicBo.java
 * @create date: 2022/3/27 22:25
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class TopicBo extends BaseConvertBo<TopicParam, Topic> {

    @Override
    public TopicParam compat(Topic info) {
        return new TopicParam().compat(info);
    }

    @Override
    public Topic convert(TopicParam info) {
        return info.convert();
    }
}
