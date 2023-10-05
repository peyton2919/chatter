package cn.peyton.core.err.child;


import cn.peyton.core.json.JSONResult;
import cn.peyton.core.json.JsonMapper;
import cn.peyton.core.toolkit.HttpServletResponseTools;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <h3></h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.core.exception.child.AdviceException.java
 * @create date: 2022/3/22 21:33
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class AdviceException extends  RuntimeException{

    public AdviceException() {
    }

    public AdviceException(String message) {
        super(message);
    }

    public AdviceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdviceException(Throwable cause) {
        super(cause);
    }

    public AdviceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * <h4>验证异常 PrintWriter 写出信息</h4>
     * @param response response 对象
     * @param jsonResult jsonResult 对象{封装的数据}
     */
    public AdviceException(HttpServletResponse response, JSONResult jsonResult) {
        HttpServletResponseTools.returnJson(
                response, JsonMapper.toJSon(jsonResult));
    }

}
