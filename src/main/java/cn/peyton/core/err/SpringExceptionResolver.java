package cn.peyton.core.err;


import cn.peyton.core.json.JSONResult;
import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.err.child.GlobalException;
import cn.peyton.core.err.child.ParamException;
import cn.peyton.core.err.child.TransactionalException;
import cn.peyton.core.err.child.ValidationException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


/**
 * <h3>全局异常类</h3>
 * <pre>
 *     要在spring [spring-servlet.xml]中配置这个异常
 *     <bean class="cn.peyton.core.err.SpringExceptionResolver"/>
 * </pre>
 * <pre>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2018/11/16 16:05
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */

@Slf4j
//@Configuration
public class SpringExceptionResolver implements HandlerExceptionResolver {
    /** json 结束 */
    private static final String JSON = ".json";
    /** page 结束 */
    private static final String PAGE = ".page";

    @Override
    @ExceptionHandler(value = {Exception.class})
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object obj, Exception ex) {
        String url = request.getRequestURL().toString();
        ModelAndView mv = null;
        String defaultMsg = "（╯＾╰） 系统未知异常,请联系管理员。";

        //.json [Json请求], .page[页面请求]
        //这里我们要求项目中所有请求json数据，都使用 .json 结尾
        if (url.endsWith(JSON)) {
            if (ex instanceof GlobalException || ex instanceof ValidationException) {
                JSONResult result = JSONResult.fail(HttpStatusCode.CUSTOMIZE_EXCEPTION_ERROR.getCode() , "（╯＾╰） " + ex.getMessage());
                mv = new ModelAndView("jsonView", result.toMap());
            }else if (ex instanceof TransactionalException){
                JSONResult result = JSONResult.fail(HttpStatusCode.CUSTOMIZE_EXCEPTION_ERROR.getCode() , "（╯＾╰） 添加或更新处理出错了。");
                mv = new ModelAndView("jsonView", result.toMap());
            }else if (ex instanceof ParamException){
                JSONResult result = JSONResult.fail(HttpStatusCode.CUSTOMIZE_EXCEPTION_ERROR.getCode() , "（╯＾╰） " + ex.getMessage());
                mv = new ModelAndView("jsonView", result.toMap());
            }else {
                log.error("未知Json异常, url: {}" , url,ex);
                JSONResult result = JSONResult.fail(HttpStatusCode.CUSTOMIZE_EXCEPTION_ERROR.getCode() , defaultMsg);
                mv = new ModelAndView("jsonView", result.toMap());
            }
            //这里我们要求项目中所有请求page页面，都使用 .page 结尾
        } else if(url.endsWith(PAGE)){
            log.error("未知页面异常, url: {}" , url ,ex);
            JSONResult result = JSONResult.fail(HttpStatusCode.CUSTOMIZE_EXCEPTION_ERROR.getCode() , defaultMsg);
            //这里的exception 是一个jsp页面
            mv = new ModelAndView("exception", result.toMap());
        }else {
            log.error("未知异常, url: {}" , url,ex);
            JSONResult result = JSONResult.fail(HttpStatusCode.CUSTOMIZE_EXCEPTION_ERROR.getCode() , defaultMsg);
            mv = new ModelAndView("index", result.toMap());
        }
        return mv;
    }
}
