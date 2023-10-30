package cn.peyton.children.chatter.controller.base;

import cn.peyton.children.chatter.param.UserParam;
import cn.peyton.core.json.JSONResult;
import jakarta.servlet.http.HttpServletRequest;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.controller.base.BaseController
 * @date 2023年10月23日 14:42
 * @version 1.0.0
 * </pre>
 */
public abstract class BaseController {
    protected UserParam baseUserParam;

    public abstract <T> JSONResult<T> handleToken(HttpServletRequest request);

    /**
     * <h4>核实 token 并 赋值</h4>
     * <pre>
     *     handleToken 方法实现:
     *     1. 获取 token 值;
     *     2. 核实 token 值;
     *     3. 从 token 中获取 UserParam 对象;
     *     4. 把 UserParam 对象存入JSONResult 返回;
     *
     *     verifyTokenAndVoluation 方法实现
     *     1. 通过判断 jsonResult.getCode() == 200 ;
     *          并把 UserParam 对象赋值给 baseUserParam;
     *          继承 AppController 子类, 可直接调用 baseUserParam;
     * </pre>
     * @param request
     */
    protected void verifyTokenAndVoluation(HttpServletRequest request) {
        JSONResult jsonResult = handleToken(request);
        if (jsonResult.getCode() == 200){
            baseUserParam = (UserParam) jsonResult.getData();
        }
    }
}
