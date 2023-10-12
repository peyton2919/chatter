package cn.peyton.children.chatter.bo;

import cn.peyton.children.chatter.param.PostImageParam;
import cn.peyton.children.chatter.pojo.PostImage;
import cn.peyton.core.inf.BaseConvertBo;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.bo.PostImageBo
 * @date 2023年10月11日 14:49
 * @version 1.0.0
 * </pre>
 */
public class PostImageBo extends BaseConvertBo<PostImageParam, PostImage> {
    @Override
    public PostImageParam compat(PostImage info) {
        return new PostImageParam().compat(info);
    }

    @Override
    public PostImage convert(PostImageParam info) {
        return info.convert();
    }
}
