package cn.peyton.children.chatter.bo;

import cn.peyton.children.chatter.param.UserParam;
import cn.peyton.children.chatter.pojo.User;
import cn.peyton.core.inf.BaseConvertBo;

/**
 * <h3>用户转换类 .bo</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.chatter.bo.UserBo.java
 * @create date: 2022/3/24 16:38
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class UserBo extends BaseConvertBo<UserParam, User> {
    @Override
    public UserParam compat(User info) {
        return new UserParam().compat(info);
    }

    @Override
    public User convert(UserParam info) {
        return info.convert();
    }
}
