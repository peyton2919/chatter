package cn.peyton.children.chatter.bo;

import cn.peyton.children.chatter.param.UserBindParam;
import cn.peyton.children.chatter.pojo.UserBind;
import cn.peyton.core.inf.BaseConvertBo;

/**
 * <h3>用户绑定转换类 .bo</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.chatter.bo.UserBindBo.java
 * @create date: 2022/3/24 22:17
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class UserBindBo extends BaseConvertBo<UserBindParam, UserBind> {
    @Override
    public UserBindParam compat(UserBind info) {
        return new UserBindParam().compat(info);
    }

    @Override
    public UserBind convert(UserBindParam info) {
        return info.convert();
    }
}
