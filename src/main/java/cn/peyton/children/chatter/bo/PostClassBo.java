package cn.peyton.children.chatter.bo;

import cn.peyton.children.chatter.param.PostClassParam;
import cn.peyton.children.chatter.pojo.PostClass;
import cn.peyton.core.inf.BaseConvertBo;

/**
 * <h3>文章分类转换类 .bo</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.chatter.bo.PostClasBo.java
 * @create date: 2022/3/27 22:00
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class PostClassBo extends BaseConvertBo<PostClassParam, PostClass> {

    @Override
    public PostClassParam compat(PostClass info) {
        return new PostClassParam().compat(info);
    }

    @Override
    public PostClass convert(PostClassParam info) {
        return info.convert();
    }
}
