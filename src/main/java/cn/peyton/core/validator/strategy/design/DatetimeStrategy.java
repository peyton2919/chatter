package cn.peyton.core.validator.strategy.design;

import cn.peyton.core.toolkit.CheckedTools;
import cn.peyton.core.validator.Regulation;
import cn.peyton.core.validator.constraints.Datetime;
import cn.peyton.core.validator.strategy.AbstractValidator;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * <h3>注解的元素为 日期时间 策略类 [可匹配2月28与29]</h3>
 * <pre>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2018/11/16 16:05
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
public class DatetimeStrategy extends AbstractValidator {

    @Override
    public void compare(Annotation annotation, String name, String type, Object value, Map<String, String> map) {
        Datetime datetime = (Datetime) annotation;
        message = datetime.message();
        if (CheckedTools.isEmpty(value)) {
            if (regex(value.toString(), Regulation.REGEX_DATETIME)) {
                map.put(name, message);
            }
        }
    }
}
