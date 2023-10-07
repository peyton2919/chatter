package cn.peyton.children.chatter.mapper;

import cn.peyton.children.chatter.pojo.Support;

/**
 * <h3> 支持 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface SupportMapper {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Support record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Support record);

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
	int updateByPrimaryKey(Support record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Support record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Support selectByPrimaryKey(Integer id);


	// ==================================== new create method ==================================== //

	/**
	 * <h4>判断这条信息有没有顶踩过</h4>
	 *
	 * @param userId 用户编号
	 * @param postId 文章编号
	 * @return
	 */
	Support checkSupport(int userId, int postId);

	/**
	 * <h4>根据文章编号查找顶和踩的数量</h4>
	 * @param postId 文章编号
	 * @param type 查找类型0顶;1踩;
	 * @return 返回 顶或踩的总数
	 */
	int findDingAndCaiByPostId(Integer postId, Integer type);

	/**
	 * <h4>根据文章编号查找顶的数量</h4>
	 * @param postId 文章编号
	 * @return 返回 顶的总数
	 */
	int findDingByPostId(Integer postId);

	/**
	 * <h4>根据文章编号查找踩的数量</h4>
	 * @param postId 文章编号
	 * @return 返回 踩的总数
	 */
	int findCaiByPostId(Integer postId);

}
