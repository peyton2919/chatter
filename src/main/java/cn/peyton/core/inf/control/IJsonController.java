package cn.peyton.core.inf.control;


import cn.peyton.core.json.JSONResult;
import cn.peyton.core.page.PageQuery;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;


/**
 * <h3>返回Json数据 Controller .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:25
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public interface IJsonController<K,T> {
    /**
     * <h4>获取对象</h4>
     * @param k 主键
     * @param request 请求对象
     * @return 对象
     */
    T getObject(K k, HttpServletRequest request);

    /**
     * <h4>跳转;用在添加、更新之前跳转</h4>
     * @param t 对象
     * @param mav 模型视图
     * @param request 请求对象
     * @param response 响应对象
     * @return Json数据
     */
    JSONResult<T> change(T t, ModelAndView mav,
                         HttpServletRequest request, HttpServletResponse response);
    /**
     * <h4>添加、更新</h4>
     * @param t 对象
     * @param result springMVC 异常绑定对象
     * @param mav 模型视图
     * @param request 请求对象
     * @param response 响应对象
     * @return Json数据
     */
    JSONResult<T> save(T t, BindingResult result,
                     ModelAndView mav, HttpServletRequest request, HttpServletResponse response);

    /**
     * <h4>删除</h4>
     * @param t 对象
     * @param mav 模型视图
     * @return Json数据
     */
    JSONResult<T> delete(T t, ModelAndView mav);

    /**
     * <h4>查找全部</h4>
     * @param mav 模型视图
     * @param pageQuery 分页绑定对象
     * @return Json数据
     */
    JSONResult<T> findByAll(ModelAndView mav, PageQuery pageQuery) ;
    /**
     * <h4>按模糊名称查找全部</h4>
     * @param likeName 模糊查找名称
     * @param mav 模型视图
     * @param pageQuery  分页绑定对象
     * @return Json数据
     */
    JSONResult<T> findByLikeName(String likeName, ModelAndView mav, PageQuery pageQuery) ;
}
