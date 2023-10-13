package cn.peyton.children.chatter.param;

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
        String str = "sk中国{  #s= }3";
        boolean contains = isP(str);

        System.out.println(contains);
    }

    public static boolean isP(String str) {
        int _first = 0, _second = 0, _third = 0;
        _first = str.indexOf('{');
        _second = str.indexOf('#');
        if (_second <=_first){
            return false;
        }
        _third = str.indexOf('}');
        if (_third > (_second + 3)) {
            return true;
        }
        return false;
    }
}
