package cn.peyton.core.enums;

/**
 * <h3></h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.core.enums.ShopStateEnum.java
 * @create date: 2021/11/18 22:55
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public enum ShopStateEnum {
    CHECK(0,"审核中"),
    OFFLINE(-1,"非法店铺"),
    SUCCESS(1,"操作成功"),
    PASS(2,"通过认证"),
    INNER_ERROR(-1001,"内部系统错误"),
    NULL_SHOPID(-1002,"ShopId为空"),
    /**  Shop信息为空 */
    NULL_SHOP(-1003,"Shop信息为空"),

    ;
    /**
     * 结果状态
     */
    private int state;
    /**
     * 状态标识
     */
    private String stateInfo;

    /**
     * <h3>私有的构造函数</h3>
     * @param state 结果状态 状态标识
     * @param stateInfo
     */
    private ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    /**
     * <h3>根据传入的state 返回相应的enum值</h3>
     * @param state
     * @return
     */
    public static ShopStateEnum stateOf(int state) {
        for (ShopStateEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }

    /**
     * <h3>结果状态</h3>
     * @return
     */
    public int getState() {
        return state;
    }

    /**
     * <h3>状态标识</h3>
     * @return
     */
    public String getStateInfo() {
        return stateInfo;
    }
}
