package cn.peyton.children.chatter.mapper;

import cn.peyton.children.chatter.pojo.Comment;

import java.util.List;

/**
 * <h3> 评论 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface CommentMapper {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Comment record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Comment record);

	/**
	 * <h4>根据 主键 删除 对象</h4>
	 * @param id 主键
	 * @return 受影响的行数
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * <h4>更新 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKey(Comment record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Comment record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Comment selectByPrimaryKey(Integer id);


	// ==================================== new create method ==================================== //

	/**
	 * <h4>判断评论父ID不为0</h4>
	 * @param fId 评论父ID
	 * @return 1 表示 该评论存在; 0 表示取反
	 */
	int checkCommentByFId(Integer fId);

	/**
	 * <h4>判断评论父ID与文章ID是否存在</h4>
	 * <pre>
	 *     条件 where id= fId and postId = postId
	 * </pre>
	 * @param fId 评论父ID
	 * @param postId 文章ID
	 * @return 1 表示 该评论存在; 0 表示取反
	 */
	int checkCommentByFIdAndPostId(Integer fId, Integer postId);

	/**
	 * <h4>更新评论被回复数</h4>
	 * @param id 评论 ID
	 * @return 1 表示 更新成功; 0 表示 取反
	 */
	int updateFnumInt(int id);

	/**
	 * <h4>根据文章ID 查找 评论对象集合</h4>
	 * @param postId  文章ID
	 * @return 评论对象集合
	 */
	List<Comment> findByPostId(Integer postId);

	/**
	 * <h4>根据文章ID 查找 评论数</h4>
	 * @param postId
	 * @return 条数
	 */
	int countByPostId(Integer postId);
}
