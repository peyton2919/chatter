package cn.peyton.children.chatter.service;

import cn.peyton.children.chatter.param.CommentParam;

import java.util.List;

/**
 * <h3> 评论 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface CommentService {

    /**
     * <h4>根据 文章评论 ID</h4>
     * @param id
     * @return
     */
    CommentParam findById(int id);

    /**
     * <h4>判断评论父ID不为0</h4>
     * @param fId 评论父ID
     * @return true 表示 该评论存在; false 表示取反
     */
    boolean isCommentByFId(Integer fId);

    /**
     * <h4>判断评论父ID与文章ID是否存在</h4>
     * <pre>
     *     条件 where id= fId and postId = postId
     * </pre>
     * @param fId 评论父ID
     * @param postId 文章ID
     * @return true 表示 该评论存在; false 表示取反
     */
    boolean isCommentByFIdAndPostId(Integer fId, Integer postId);

    /**
     * <h4>创建评论</h4>
     * @param param 评论传递对象
     * @return 返回带ID 评论传递对象
     */
    CommentParam create(CommentParam param);

    /**
     * <h4>更新评论被回复数</h4>
     * @param id 评论 ID
     * @return true 表示 更新成功; false 表示 取反
     */
    boolean updateFnumInt(int id);

    /**
     * <h4>根据文章ID 查找 评论对象集合</h4>
     * @param postId  文章ID
     * @return 评论对象集合
     */
    List<CommentParam> findByPostId(Integer postId);
}
