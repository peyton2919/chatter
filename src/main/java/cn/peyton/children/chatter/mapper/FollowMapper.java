package cn.peyton.children.chatter.mapper;

import cn.peyton.children.chatter.pojo.Follow;
import cn.peyton.core.page.PageQuery;

import java.util.List;

/**
 * <h3> 关注 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface FollowMapper {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Follow record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Follow record);

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
	int updateByPrimaryKey(Follow record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Follow record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Follow selectByPrimaryKey(Integer id);


	// ==================================== new create method ==================================== //

	/**
	 * <h4>根据用户编号 查找 粉丝集合</h4>
	 * @param userId 用户 编号
	 * @return 粉丝集合
	 */
	List<Follow> findByUserId(int userId);

	/**
	 * <h4>判断是否关注过</h4>
	 * @param followId 粉丝编号
	 * @param userId 用户编号
	 * @return 1 表示 有关注过; 0 表示 取反;
	 */
	int checkFollow(int followId, int userId);

	/**
	 * <h4>删除 关注对象</h4>
	 * @param userId
	 * @param followId
	 * @return 1 表示 删除成功; 0 表示 取反;
	 */
	int deleteByUserIdAndFollowId(int userId,int followId);

	/**
	 * <h4>互关列表</h4>
	 * @param userId 用户ID
	 * @param page 分页对象
	 * @return 互关列表
	 */
	List<Follow> friends(Integer userId, PageQuery page);

	/**
	 * <h4>粉丝、关注列表</h4>
	 * <pre>
	 *     fens = true
	 *     where follow_id = #{userId}
	 *     fens = false
	 *     where user_id = #{userId}
	 * </pre>
	 * @param userId 用户ID
	 * @param page 分页对象
	 * @param fens true 表示 粉丝列表; false 表示 关注列表
	 * @return 互关列表
	 */
	List<Follow> follows(Integer userId, PageQuery page, boolean fens);
}
