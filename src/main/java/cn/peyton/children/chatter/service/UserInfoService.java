package cn.peyton.children.chatter.service;

import cn.peyton.children.chatter.param.UserInfoParam;

/**
 * <h3> 用户资料 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface UserInfoService {

    /**
     *
     * @param param
     * @return
     */
    boolean updateUserInfo(UserInfoParam param);

    /**
     * <h4>根据用户ID 查找 用户扩展对象</h4>
     * @param usrId 用户ID
     * @return 用户扩展传递对象
     */
    UserInfoParam findByUserId(Integer usrId);
}
