package cn.peyton.core.toolkit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.core.toolkit.LogTools
 * @date 2023年10月09日 9:30
 * @version 1.0.0
 * </pre>
 */
@Slf4j
@Component
public class LogTools  implements Serializable {

    /**
     * <4>错误写入log </4>
     * @param depict 异常描述
     */
    public static void error(Object depict) {
        log.error("[<自定义异常>] 在类: {},方法名: {},所在应类行号: {}。原因: 【{}】",
                Thread.currentThread().getStackTrace()[1].getClassName(),
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                Thread.currentThread().getStackTrace()[1].getLineNumber(),depict);
    }
}
