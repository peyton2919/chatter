package cn.peyton.children.chatter.mapper;

import cn.peyton.children.chatter.pojo.BlackList;

/**
 * <h3> 拉黑集 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface BlackListMapper {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(BlackList record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(BlackList record);

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
	int updateByPrimaryKey(BlackList record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(BlackList record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	BlackList selectByPrimaryKey(Integer id);


	// ==================================== new create method ==================================== //

	/**
	 * <h4>判断 是否已拉黑</h4>
	 * @param userId 用户ID
	 * @param blackId 拉黑用户ID
	 * @return true 表示 已拉黑; false 表示 取反
	 */
	int checkUserIdAndBlackId(Integer userId, Integer blackId);

	/**
	 * <h4>删除已拉黑</h4>
	 * @param userId 用户ID
	 * @param blackId 拉黑用户ID
	 * @return true 表示 删除成功; false 表示 取反
	 */
	int deleteByUserIdAndBlackId(Integer userId, Integer blackId);

}
