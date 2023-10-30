package cn.peyton.children.chatter.aop.img;

import java.lang.annotation.*;

/**
 * <h4>添加图片主机地址</h4>
 * <pre>
 *     用于前后端分离
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.aop.img.ImagePath
 * @date 2023年10月23日 15:55
 * @version 1.0.0
 * </pre>
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ImageHostPath {
    /**
     * <h4>属性名称, 多个用 `,` 隔开</h4>
     * @return
     */
    String name();
}
