package cn.peyton.children.chatter.service;

import cn.peyton.children.chatter.param.PostClassParam;

import java.util.List;

/**
 * <h3> 帖子分类 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface PostClassService {

    /**
     * <h4>查找所有文章分类</h4>
     * @return 文章分类传递类对象集合
     */
    List<PostClassParam> finds();

    /**
     * <h4>添加帖子分类</h4>
     * @param param 帖子分类对象
     * @return 添加成功 true
     */
    boolean add(PostClassParam param);

    /**
     * <ht>判断第一名</ht>
     * @param className 分类名称
     * @return 重名返回 true
     */
    boolean isRename(String className);

    PostClassParam findById(Integer id);

}
