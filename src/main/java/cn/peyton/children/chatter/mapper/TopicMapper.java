package cn.peyton.children.chatter.mapper;

import cn.peyton.children.chatter.pojo.Topic;
import cn.peyton.core.page.PageQuery;

import java.util.List;

/**
 * <h3> 话题 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface TopicMapper {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(Topic record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Topic record);

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
	int updateByPrimaryKey(Topic record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Topic record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Topic selectByPrimaryKey(Integer id);


	// ==================================== new create method ==================================== //

	/**
	 * <h4>获取热门话题</h4>
	 * @return
	 */
	List<Topic> finds();

	/**
	 * <h4>获取指定话题分类下的话题列表</h4>
	 * @param topicClassId 话题分类编号
	 * @param page 分页对象
	 * @return
	 */
	List<Topic> findByTopicClassId(int topicClassId, PageQuery page);

	/**
	 * <h4>获取 热门的话题 </h4>
	 * @param topicClassId 话题分类编号
	 * @param page 分页对象
	 * @return
	 */
	List<Topic> findByHot(int topicClassId, PageQuery page);

	/**
	 * <h4>搜索话题</h4>
	 * @param keyword 关键字
	 * @param page 分页对象
	 * @return
	 */
	List<Topic> search(String keyword, PageQuery page);

}
