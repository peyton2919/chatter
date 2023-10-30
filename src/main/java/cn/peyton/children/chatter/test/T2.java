package cn.peyton.children.chatter.test;

import com.alibaba.fastjson2.JSON;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.test.T2
 * @date 2023年10月18日 11:51
 * @version 1.0.0
 * </pre>
 */
public class T2 {
    public static void main(String[] args) throws Exception {
        Stu entity = new Stu();
        entity.setAge(15);
        entity.setId(1);
        entity.setName("张三");
        //动态设置属性字段
        Map<String, Object> addProperties = new HashMap() {{
            put("sex", "男");
            put("telephone", "123456789");
        }};
        //获取实体中给属性的值
        Object target = ReflectUtil1.getObject(entity, addProperties);

        System.out.println(JSON.toJSONString(target));
        //System.out.println(ReflectUtil.getFieldValueByName("id", target));
        //System.out.println(ReflectUtil.getFieldValueByName("name", target));
        //System.out.println(ReflectUtil.getFieldValueByName("age", target));
        //System.out.println(ReflectUtil.getFieldValueByName("sex", target));
        //System.out.println(ReflectUtil.getFieldValueByName("telephone", target));
    }

    public static Object deleteProperty(Object obj, String fieldName) throws Exception {

        Class<?> clazz = obj.getClass();

        Field field = clazz.getDeclaredField("$cglib_prop_"+fieldName);
        field.setAccessible(true);
        field.set(obj, null);//将属性置空

        return obj;
    }


}
