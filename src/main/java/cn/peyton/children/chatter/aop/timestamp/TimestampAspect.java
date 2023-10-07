package cn.peyton.children.chatter.aop.timestamp;

import cn.peyton.core.toolkit.DateTools;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
public class TimestampAspect {
    @Pointcut("@annotation(cn.peyton.children.chatter.aop.timestamp.Timestamp)")
    public void timePointCut() {

    }

    //@Before("execution(* cn.peyton.children.*.add*(..))")
    @Before("timePointCut()")
    public Object around(JoinPoint point) throws Throwable {
        Object result = point.getClass();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Annotation[] as =method.getAnnotations();
        String fieldName = null;
        for (Annotation _a : as) {
            if (_a instanceof Timestamp){
                Timestamp _t = (Timestamp) _a;
                if (null == _t.value() || "".equals(_t.value())) {
                    fieldName = "createTime";
                }
                fieldName =_t.value();
                break;
            }
        }
        Object[] args = point.getArgs();
        if (null != args && args.length > 0) {
            Field field = null;
            try {
                field = args[0].getClass().getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
            field.setAccessible(true);
            try {
                field.set(args[0], DateTools.timestampToStrDate(new Date()));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
