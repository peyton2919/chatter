package cn.peyton.children.chatter.bo;

import cn.peyton.children.chatter.param.FollowParam;
import cn.peyton.children.chatter.pojo.Follow;
import cn.peyton.core.inf.BaseConvertBo;

/**
 * <h3>粉丝 关注 转换类 .bo</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.chatter.bo.FollowBo.java
 * @create date: 2022/3/25 14:20
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class FollowBo extends BaseConvertBo<FollowParam, Follow> {
    @Override
    public FollowParam compat(Follow info) {
        return new FollowParam().compat(info);
    }

    @Override
    public Follow convert(FollowParam info) {
        return info.convert();
    }
}
