package cn.peyton.core.inf;

import cn.peyton.core.json.JSONResult;
import org.springframework.stereotype.Controller;

import java.io.Serializable;

/**
 * <h3>定义基础方法 .controller </h3>
 * <pre>
 *     定义了一些基础的方法 T: 当前 对象; K 当前 对象主键
 *     index(); 首页
 *     add(T t); 创建对象
 *     edit(T t); 编辑对象
 *     save(T t); 保存对象
 *     update(T t); 更新对象
 *     delete(K k); 删除对象
 *     getT(K k); 查找对象
 * </pre>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.controller.common.BaseController.java
 * @create date: 2022/3/26 22:57
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Controller
public class BaseController<T,K> implements Serializable {
    /**
     *  <h4>首页</h4>
     * @return
     */
    public JSONResult<T> index(){
        return JSONResult.success();
    };

    /**
     * <H4>创建 对象</H4>
     * @param t 对象
     * @return
     */
    public JSONResult<T> add(T t) {

        return JSONResult.success(t);
    }

    /**
     * <H4>编辑 对象</H4>
     * @param t 对象
     * @return
     */
    public JSONResult<T> edit(T t) {

        return JSONResult.success(t);
    }

    /**
     * <H4>更新 对象</H4>
     * @param t 对象
     * @return
     */
    public JSONResult<T> update(T t) {

        return JSONResult.success(t);
    }

    /**
     * <H4>删除 对象</H4>
     * @param k 对象主键
     * @return
     */
    public JSONResult<T> delete(K k) {

        return JSONResult.success();
    }

    /**
     * <H4>保存 对象</H4>
     * @param t 对象
     * @return
     */
    public JSONResult<T> save(T t) {

        return JSONResult.success(t);
    }

    /**
     * <H4>查找 对象</H4>
     * @param k 对象主键
     * @return
     */
    public JSONResult<T> getT(K k) {

        return JSONResult.success();
    }
}
