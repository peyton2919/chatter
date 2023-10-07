package cn.peyton.children.chatter.bo;


import cn.peyton.children.chatter.param.PostParam;
import cn.peyton.children.chatter.pojo.Post;
import cn.peyton.core.inf.BaseConvertBo;

/**
 * <h3>文章转换类 .bo</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.chatter.bo.PostBo.java
 * @create date: 2022/3/24 16:04
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class PostBo extends BaseConvertBo<PostParam, Post> {
    @Override
    public PostParam compat(Post info) {
        return new PostParam().compat(info);
    }

    @Override
    public Post convert(PostParam info) {

        return info.convert();
    }
}
