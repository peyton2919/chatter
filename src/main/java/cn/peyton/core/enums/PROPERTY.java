package cn.peyton.core.enums;/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.core.enums.PROPERTY
 * @date 2023年10月06日 15:41
 * @version 1.0.0
 * </pre>
 */

/**
 * <h4>参数固定值</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.core.enums.PROPERTY
 * @date 2023年10月06日 15:41
 * @version 1.0.0
 * </pre>
 */
public interface PROPERTY {
    /**
     * @return 获取 class目录
     */
    static String getLocation() {
        return Thread.currentThread().getContextClassLoader().getResource("").getPath();
    }
    /** 用户登录 类型为 账户 */
    String ACCOUNT = "account";
    /** 用户登录 类型为 手机 */
    String PHONE = "phone";
    /** 用户登录 类型为 第三方 */
    String OTHER = "other";
    /** 用户登录 类型为 邮箱 */
    String EMAIL = "email";
    /** 用户登录成功时，存在 session中的 用户传参对象 key */
    String SESSION_USER = "SESSION_USER_PARAM_2203231855";
}
