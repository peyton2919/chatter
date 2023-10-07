package cn.peyton.children.chatter.bo;

import cn.peyton.children.chatter.param.TopicClassParam;
import cn.peyton.children.chatter.pojo.TopicClass;
import cn.peyton.core.inf.BaseConvertBo;

/**
 * <h3>话题分类 转换类 .bo</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.chatter.bo.TopicClassBo.java
 * @create date: 2022/3/27 22:12
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class TopicClassBo extends BaseConvertBo<TopicClassParam, TopicClass> {

    @Override
    public TopicClassParam compat(TopicClass info) {
        return new TopicClassParam().compat(info);
    }

    @Override
    public TopicClass convert(TopicClassParam info) {
        return info.convert();
    }
}
