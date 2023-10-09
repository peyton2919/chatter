package cn.peyton.children.chatter.param;

import java.util.regex.Pattern;

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
        String reg = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String username ="968875";
        //Pattern pattern = Pattern.compile(username);
        //Matcher matcher = pattern.matcher(Regulation.REGEX_EMAIL_ALL);
        //boolean b = matcher.matches();
        //System.out.println(b);

        Boolean bbb = Pattern.matches(reg, username);
        System.out.println(bbb);
    }
}
