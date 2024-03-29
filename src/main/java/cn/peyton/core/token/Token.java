package cn.peyton.core.token;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h3>加入此注解,需要 token 验证</h3>
 * <pre>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2022/3/20 22:46
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
@Target({ElementType.METHOD,ElementType.TYPE}) //表明此注解可用在方法上
@Retention(RetentionPolicy.RUNTIME) //运行时有效
public @interface Token {
    /**
     * <h4>用于验证 token </h4>
     * @return
     */
    boolean required() default true;

    //虽然没用到，但是要加上
    Class<?>[] groups() default {};
}
