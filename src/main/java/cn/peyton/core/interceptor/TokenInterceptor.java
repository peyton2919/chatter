package cn.peyton.core.interceptor;

import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.json.JsonMapper;
import cn.peyton.core.token.Token;
import cn.peyton.core.token.TokenTools;
import cn.peyton.core.toolkit.HttpServletResponseTools;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;

/**
 * <h3></h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.core.token.AuthHandlerInterceptor.java
 * @create date: 2022/3/20 22:17
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request
                , HttpServletResponse response, Object handler) throws Exception {
        log.info("===============  进入拦截器{TokenInterceptor}  ===============");
        //如果不是映射到方法直接通过，可以访问资源
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Token methodAnnotation = method.getAnnotation(Token.class);


        // 有 @Token 注解，需要认证
        if (null != methodAnnotation) {
            response.setCharacterEncoding("UTF-8");
            TokenTools tokenTools = new TokenTools();
            String accessToken = request.getHeader(TokenTools.Property.ACCESS_TOKEN);
            if (null == accessToken) {
                response.setStatus(200);

                HttpServletResponseTools.returnJson(
                        response, JsonMapper.toJSon(JSONResult.error(HttpStatusCode.ERR_ILLEGAL_TOKEN.getMsg())));
                return false;
            } else {
                if (!tokenTools.verify(accessToken)) {
                    //
                    response.setStatus(200);
                    HttpServletResponseTools.returnJson(
                            response, JsonMapper.toJSon(JSONResult.fail(HttpStatusCode.ERR_TOKEN_EXPIRE.getMsg())));
                    return false;
                }
            }
        }
        return true;
    }


}
