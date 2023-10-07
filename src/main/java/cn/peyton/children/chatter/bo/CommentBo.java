package cn.peyton.children.chatter.bo;

import cn.peyton.children.chatter.param.CommentParam;
import cn.peyton.children.chatter.pojo.Comment;
import cn.peyton.core.inf.BaseConvertBo;

/**
 * <h3>文章评论 转换类 .bo</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.chatter.bo.CommentBo.java
 * @create date: 2022/3/26 15:21
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class CommentBo extends BaseConvertBo<CommentParam, Comment> {
    @Override
    public CommentParam compat(Comment info) {
        return new CommentParam().compat(info);
    }

    @Override
    public Comment convert(CommentParam info) {
        return info.convert();
    }
}
