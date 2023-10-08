package cn.peyton.children.chatter.aop.timestamp;

import cn.peyton.core.err.child.GlobalException;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.toolkit.DateTools;
import cn.peyton.core.toolkit.HttpServletRequestTools;
import cn.peyton.core.toolkit.HttpServletResponseTools;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * <h4>aop 创建 10位的时间戳 切面类</h4>
 * <pre>
 *     处理流程:
 *     1. 数据库 创建为 int(11) 时间 字段;
 *     2. 对象有 pojo (对应数据层)与param（对应视图层)：
 *          pojo 对象 时间字段为 int 类型;
 *          param 对象 时间字段为 String 类型;
 *     3. 切面 注解{@Timestamp}在 service.impl 下的方法 添加或更新 上;
 *     4. @Timestamp 下 value 值为要创建的时间戳 的字段;
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.aop.timestamp.TimestampAspect
 * @date 2023年10月07日 21:14
 * @version 1.0.0
 * </pre>
 */
@Aspect
@Component
@Slf4j
public class TimestampAspect {

    @Pointcut("@annotation(cn.peyton.children.chatter.aop.timestamp.Timestamp)")
    public void timePointCut() {  }

    @Around("timePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        HttpServletResponse response = HttpServletResponseTools.getResponse();
        HttpServletRequest request = HttpServletRequestTools.getRequest();

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Annotation[] _annos = method.getAnnotations();
        String fieldName = null;
        for (Annotation _anno : _annos) {
            if (_anno instanceof Timestamp){
                Timestamp _tt = (Timestamp) _anno;
                if (null == _tt.value() || "".equals(_tt.value())) {
                    fieldName = "createTime";
                }
                fieldName =_tt.value();
                break;
            }
        }
        Object[] _args = point.getArgs();
        if (null != _args && _args.length > 0) {
            Field field = null;
            String _name = _args[0].getClass().getName();
            _name = _name.substring(_name.lastIndexOf('.') + 1);
            try {
                field = _args[0].getClass().getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                log.error("cn.peyton.children.chatter.aop.timestamp.TimestampAspect -> 异常 【NoSuchFieldException】");
                return JSONResult.fail(400999, "获取当前对象{" + _name + "}的{" + fieldName + "}属性名称错误");
            }
            field.setAccessible(true);
            try {
                field.set(_args[0], DateTools.timestampToStrDate(new Date()));
            } catch (IllegalAccessException e) {
                log.error("cn.peyton.children.chatter.aop.timestamp.TimestampAspect -> 异常 【IllegalAccessException】");
                return JSONResult.fail(400999, "设置当前对象{" + _name + "}的{" + fieldName + "}属性值错误");
            }
        }
        return point.proceed();
    }

    //@Before("execution(* cn.peyton.children.*.add*(..))")
    //@Before("timePointCut()")
    //@Before(value = "timePointCut()")
    public Object before(JoinPoint point)  {
        HttpServletResponse response = HttpServletResponseTools.getResponse();
        HttpServletRequest request = HttpServletRequestTools.getRequest();

        Object result = point.getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Annotation[] _annos = method.getAnnotations();
        String fieldName = null;
        for (Annotation _anno : _annos) {
            if (_anno instanceof Timestamp){
                Timestamp _tt = (Timestamp) _anno;
                if (null == _tt.value() || "".equals(_tt.value())) {
                    fieldName = "createTime";
                }
                fieldName =_tt.value();
                break;
            }
        }
        Object[] _args = point.getArgs();
        if (null != _args && _args.length > 0) {
            Field field = null;
            try {
                field = _args[0].getClass().getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                log.error("cn.peyton.children.chatter.aop.timestamp.Timestamp -> 异常 【NoSuchFieldException】");
                throw new GlobalException(response,null,null);
            }
            field.setAccessible(true);
            try {
                field.set(_args[0], DateTools.timestampToStrDate(new Date()));
            } catch (IllegalAccessException e) {
                log.error("cn.peyton.children.chatter.aop.timestamp.Timestamp -> 异常 【IllegalAccessException】");
                throw new GlobalException(e);
            }
        }
        log.info("<=====================================================");
        log.info("请求来源： =》" + request.getRemoteAddr());
        log.info("请求URL：" + request.getRequestURL().toString());
        log.info("请求方式：" + request.getMethod());
        log.info("响应方法：" + signature.getDeclaringTypeName() + "." + signature.getName());
        log.info("请求参数：" + Arrays.toString(_args));
        log.info("响应码：" + response.getStatus());
        log.info("------------------------------------------------------");
        return result;
    }
}


