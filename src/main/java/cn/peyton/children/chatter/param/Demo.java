package cn.peyton.children.chatter.param;

import java.util.ArrayList;
import java.util.List;

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
        List<String> _l1 = new ArrayList<>();
        _l1.add("1");
        _l1.add("2");
        _l1.add("3");

        //for (String _l : _l1) {
        //    System.out.println(_l);
        //}
        _l1.clear();
        List<String> _l2 = new ArrayList<>();
        _l2.add("4");
        _l2.add("5");
        _l2.add("6");

        _l1 = _l2;

        for (String _l : _l1) {
            System.out.println(_l);
        }



    }
}
