package cn.peyton.children.chatter.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtilsBean;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.test.ReflectUtil
 * @date 2023年10月18日 12:28
 * @version 1.0.0
 * </pre>
 */
@Slf4j
public class ReflectUtil<T> {

    public static Object getTarget(Object dest, Map<String, Object> addProperties) {

        // get property map
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(dest);
        Map<String, Class> propertyMap = new HashMap<>();
        for (PropertyDescriptor d : descriptors) {
            if (!"class".equalsIgnoreCase(d.getName())) {
                propertyMap.put(d.getName(), d.getPropertyType());
            }
        }
        // add extra properties
        for (Map.Entry<String, Object> entry : addProperties.entrySet()) {
            propertyMap.put(entry.getKey(), entry.getValue().getClass());
        }
//        addProperties.forEach((k, v) -> propertyMap.put(k, v.getClass()));
        // new dynamic bean
        DynamicBean dynamicBean = new DynamicBean(dest.getClass(), propertyMap);
        // add old value
        for (Map.Entry<String, Class> entry : propertyMap.entrySet()) {
            try {
                // filter extra properties
                if (!addProperties.containsKey(entry.getKey())) {
                    dynamicBean.setValue(entry.getKey(), propertyUtilsBean.getNestedProperty(dest, entry.getKey()));
                }
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        ;
        // add extra value
        for (Map.Entry<String, Object> entry : addProperties.entrySet()) {
            try {
                dynamicBean.setValue(entry.getKey(), entry.getValue());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
        ;
        Object target = dynamicBean.getTarget();
        return target;
    }

    //获取实体中属性的值
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            //通过反射获取值
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

}
