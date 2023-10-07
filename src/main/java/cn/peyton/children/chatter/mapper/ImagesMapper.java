package cn.peyton.children.chatter.mapper;

import cn.peyton.children.chatter.pojo.Images;

import java.util.List;

/**
 * <h3> 图片 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface ImagesMapper {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Images record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Images record);

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
	int updateByPrimaryKey(Images record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Images record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Images selectByPrimaryKey(Integer id);


	// ==================================== new create method ==================================== //

	/**
	 * <h4>批量插入</h4>
	 * @param imagesList 图片对象集合
	 * @return 返回受影响的行数
	 */
	int insertBatch(List<Images> imagesList);

	/**
	 * <h>根据 帖子ID 查找 集合</h>
	 * @param postId 帖子ID
	 * @return
	 */
	List<Images> selectByExpand(int postId);
}
