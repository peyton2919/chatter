package cn.peyton.children.chatter.handler;

/**
 * <h4>全局异常处理</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.handler.GlobalExceptionHandler
 * @date 2023年10月05日 20:20
 * @version 1.0.0
 * </pre>
 */

import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.err.child.ValidationException;
import cn.peyton.core.json.JSONResult;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.handler.GlobalExceptionHandler
 * @date 2023年10月05日 20:20
 * @version 1.0.0
 * </pre>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    //public <T> JSONResult<T> handleException(Exception e){
    //    return JSONResult.fail(HttpStatusCode.FAIL, e.getMessage());
    //}

    @ExceptionHandler(ValidationException.class)
    public JSONResult exceptionHandle(ValidationException e, HttpServletResponse response) {
        return JSONResult.fail(HttpStatusCode.FAIL.getMsg());
    }
}
