package cn.peyton.children.chatter.test;

import java.io.Serializable;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.test.Stu
 * @date 2023年10月18日 11:52
 * @version 1.0.0
 * </pre>
 */
public class Stu implements Serializable {
    //ID
    private int id;
    //名字
    private String name;
    //年龄
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
