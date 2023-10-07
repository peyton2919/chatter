package cn.peyton.children.chatter.bo;

import cn.peyton.children.chatter.param.FeedbackParam;
import cn.peyton.children.chatter.pojo.Feedback;
import cn.peyton.core.inf.BaseConvertBo;

/**
 * <h3>用户意见反馈转换类 .bo</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.chatter.bo.FeedbackBo.java
 * @create date: 2022/3/30 23:35
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class FeedbackBo extends BaseConvertBo<FeedbackParam, Feedback> {
    @Override
    public FeedbackParam compat(Feedback info) {
        return new FeedbackParam().compat(info);
    }

    @Override
    public Feedback convert(FeedbackParam info) {
        return info.convert();
    }
}
