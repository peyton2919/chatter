package cn.peyton.children.chatter.param;

import java.lang.reflect.Field;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.param.Demo
 * @date 2023年10月08日 22:35
 * @version 1.0.0
 * </pre>
 */
public class Demo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        UserParam param = new UserParam();
        param.setConfirmPwd("1234");
        param.setPassword("5678");
        param.setId(1);

        Class<?> clazz = param.getClass();
        Field pwField = clazz.getDeclaredField("password");
        pwField.setAccessible(true);
        String _pw = (String) pwField.get(param);

        Field cpwField = clazz.getDeclaredField("confirmPwd");
        cpwField.setAccessible(true);
        String _cpw = (String) cpwField.get(param);
        System.out.println(_pw);
        System.out.println(_cpw);
    }
}
