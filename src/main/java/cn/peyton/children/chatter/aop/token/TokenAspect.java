package cn.peyton.children.chatter.aop.token;

import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.token.Token;
import cn.peyton.core.token.TokenTools;
import cn.peyton.core.toolkit.HttpServletRequestTools;
import cn.peyton.core.toolkit.HttpServletResponseTools;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.aop.token.TokenAspect
 * @date 2023年10月11日 8:49
 * @version 1.0.0
 * </pre>
 */
@Aspect
@Component
@Slf4j
public class TokenAspect {
    /**
     * 切面点
     */
    @Pointcut("@annotation(cn.peyton.core.token.Token)")
    public void pointCut() { }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        // 初始化数据
        MethodSignature _signature = (MethodSignature) point.getSignature();
        Method _method = _signature.getMethod();
        HttpServletResponse _response = HttpServletResponseTools.getResponse();
        HttpServletRequest _request = HttpServletRequestTools.getRequest();

        Token _token = _method.getAnnotation(Token.class);
        // 有 @Token 注解，需要认证
        if (null != _token) {
            _response.setCharacterEncoding("UTF-8");
            TokenTools tokenTools = new TokenTools();
            String accessToken = _request.getHeader(TokenTools.Property.ACCESS_TOKEN);
            if (null == accessToken) {
                return JSONResult.fail(HttpStatusCode.ERR_ILLEGAL_TOKEN);
            } else {
                if (!tokenTools.verify(accessToken)) {
                    return JSONResult.fail(HttpStatusCode.ERR_TOKEN_EXPIRE);
                }
            }
        }
        Object[] _args = point.getArgs();
        return point.proceed(_args);
    }
}
