package cn.peyton.children.chatter.service;

import cn.peyton.children.chatter.param.UserParam;
import cn.peyton.core.page.PageQuery;

import java.util.List;

/**
 * <h3> 用户信息 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface UserService {

    /**
     * <h4>字符加密</h4>
     * @param pw 需要加密的字段
     * @return 加密后的字段
     */
    String encryptPW(String pw);

    /**
     * <h4>用户注册</h4>
     * @param param 用户传参对象
     * @return 用户传参对象
     */
    UserParam reg(UserParam param);

    /**
     * <h4>根据 手机号 查找 用户</h4>
     * @param phone 手机号
     * @return 用户传参对象
     */
    UserParam findByPhone(String phone);

    /**
     * <h4>用户账户 登录 </h4>
     * @param username 用户名
     * @param password 密码
     * @return 用户传参对象
     */
    UserParam login(String username, String password);

    /**
     * <h>判断用户是否被禁用</h>
     * @param keyword 用户名称
     * @param type 类型 account:表示 用户名称 ; phone: 表示 用户手机
     * @param status 状态 0 表示 禁用 ; 1 表示 可用 ;
     * @return true 表示 查到数据 ; false 表示 没查到数据 ;
     */
    boolean isStatus(String keyword, String type,Integer status);

    /**
     * <h4>判断用户是否重命名</h4>
     * @param username 用户名称
     * @return true 表示 重名 ; false 表示 没重名;
     */
    boolean isRename(String username);

    /**
     * <h4>判断 用户密码</h4>
     * @param username 用户名称
     * @param password 密码
     * @return true 表示 密码正确; false 表示 取反;
     */
    boolean isPassword(String username, String password);

    /**
     * <h4>验证第三方登录是否绑定手机</h4>
     * @param param 用户传参对象
     * @return true 表示 用户已经绑定手机; false 表示 取反;
     */
    boolean otherLoginIsBindPhone(UserParam param);

    /**
     * <h4>根据关键字，分页查找</h4>
     * @param keyword 关键字
     * @param page 分页对象
     * @return 用户对象 集合
     */
    List<UserParam> search(String keyword, PageQuery page);

    /**
     * <h4>更新 手机</h4>
     * @param param 用户传参 对象
     * @return true 表示 更新成功; false 表示 取反;
     */
    boolean updatePhone(UserParam param);

    /**
     * <h4>更新 邮箱</h4>
     * @param param 用户传参 对象
     * @return true 表示 更新成功; false 表示 取反;
     */
    boolean updateEmail(UserParam param);

    /**
     * <h4>判断 手机号码 是否被 他人绑定</h4>
     * @param userId 用户编号
     * @param phone 手机号码
     * @return true 表示 可用 有绑定过; false 表示 取反;
     */
    boolean isBindPhone(Integer userId, String phone);
    /**
     * <h4>判断 手机号码 是否被 他人绑定</h4>
     * @param userId 用户编号
     * @param email 邮箱地址
     * @return true 表示 可用 有绑定过; false 表示 取反;
     */
    boolean isBindEmail(Integer userId, String email);

    /**
     * <h4>更新用户头像</h4>
     * @param id 用户编号
     * @param userPic 头像地址
     * @return true 表示 插入成功; false表示 取反;
     */
    boolean updateUserPic(Integer id, String userPic);

    /**
     * <h4>更新 用户密码</h4>
     * @param id 用户编号
     * @param password 密码
     * @return true 表示 插入成功; false表示 取反;
     */
    boolean updatePassword(Integer id, String password);

    /**
     * <h4>判断用户编号 是否存在</h4>
     * @param userId 用户编号
     * @return  true 表示 用户存在; false 表示 取反;
     */
    boolean isUserId(Integer userId);

    /**
     * <h4>根据 用户 ID 查找密码 </h4>
     * @param id 用户ID
     * @param oldPassword 旧密码
     * @return 为不空 表示 找到密码; 否则 表示 取反
     */
    String findPasswordById(Integer id,String oldPassword);

    /**
     * <h4>根据 ID 查找 用户对象</h4>
     * @param id
     * @return 用户对象
     */
    UserParam findById(Integer id);
}
