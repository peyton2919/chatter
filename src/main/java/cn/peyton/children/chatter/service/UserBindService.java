package cn.peyton.children.chatter.service;

import cn.peyton.children.chatter.param.UserBindParam;

import java.util.List;

/**
 * <h3> 第三方登录信息 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface UserBindService {

    /**
     * <h4>判断 第三方账号 是否被 他人绑定</h4>
     *
     * @param userId 用户编号
     * @param type   账号类型 {qq,weixin,xinaweibo}
     * @param openId 第三方账号
     * @return true 表示 可用 没有绑定过; false 表示 取反;
     */
    boolean isBindOther(int userId, String openId, String type);

    /**
     * <h4>插入 用户绑定</h4>
     * @param param 用户绑定传参对象
     * @return 对象 表示 插入成功 表示 ; null 取反;
     */
    UserBindParam create(UserBindParam param);

    /**
     * <h>根据用户编号 查找 用户绑定对象</h>
     * @param id 用户编号
     * @return
     */
    List<UserBindParam> findByUserId(Integer id);

    /**
     * <h4>根据openId和type 查找 用户绑定</h4>
     * @param openId
     * @param type
     * @return 用户绑定对象
     */
    UserBindParam findByOpenIdAndType(String openId, String type);
}
