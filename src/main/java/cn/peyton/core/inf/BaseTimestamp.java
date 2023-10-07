package cn.peyton.core.inf;

import cn.peyton.core.toolkit.DateTools;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * <h4>建造 时间格式 生成 10位 时间戳 类</h4>
 * <pre>
 *     类名.builder(); 默认属性名称为 createTime
 *     类名.builder(fieldName); fieldName 属性名称
 *     初始化 createTime（int型10位时间戳）字段赋值
 *     在 service 层实现类在调用 builder 方法
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.core.inf.service.BaseDate
 * @date 2023年10月06日 23:43
 * @version 1.0.0
 * </pre>
 */
public abstract class BaseTimestamp<T> {


    /**
     * <h4>建造 时间格式 </h4>
     * <pre>
     *     类名.build(); 默认属性名称为 createTime
     *     初始化 createTime（int型10位时间戳）字段赋值
     * </pre>
     * @return
     */
    public BaseTimestamp<T> builder(){
        return _builder(null);
    }

    /**
     * <h4>建造 时间格式 </h4>
     * @param fileName 属性名称
     * @return
     */
    public BaseTimestamp<T> builder(String fileName){
        return _builder(fileName);
    }
    //
    //private BaseTimestamp<T> _builder() {
    //
    //}

    private  BaseTimestamp<T> _builder(String fieldName) {
        if(null == fieldName || "".equals(fieldName)){ fieldName = "createTime";}
        Field field = null;
        try {
            field = this.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        field.setAccessible(true);
        try {
            field.set(this, DateTools.timestampToStrDate(new Date()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}
