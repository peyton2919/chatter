package cn.peyton.children.chatter.mapper;

import cn.peyton.children.chatter.pojo.Adsense;
import cn.peyton.core.page.PageQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <h3> 广告 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月27日 13:35:20
 * @version 1.0.0
 * </pre>
*/
public interface AdsenseMapper {
	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(Adsense record);

	/**
	 * <h4>根据 主键 删除 对象</h4>
	 * @param id 主键
	 * @return 受影响的行数
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(Adsense record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	Adsense selectByPrimaryKey(Integer id);

	/**
	 * <h4>根据 类型 查找 广告对象集合</h4>
	 * @param type 类型
	 * @param page 分页对象
	 * @return
	 */
	List<Adsense> findByType(Integer type, PageQuery page);
	/**
	 * <h4>分页查询(全部或关键字模糊查找)</h4>
	 * @param keyword 关键字, 当keyword = null 时为全部查询
	 * @param page 分页对象
	 * @return 对象集合
	 */
	List<Adsense> selectByAllOrKeyword(@Param("keyword") String keyword, @Param("page") PageQuery page);


	/**
	 * <h4>根据对象条件查找</h4>
	 * @param record 对象
	 * @param page 分页对象
	 * @return 对象集合
	 */
	List<Adsense> selectByObj(Adsense record, @Param("page") PageQuery page);


	/**
	 * <h4>查找全部数量(全部或关键字模糊查找)</h4>
	 * @param keyword 关键字, 当keyword = null 时为全部查询
	 * @return 总条数
	 */
	int count(@Param("keyword") String keyword);

	/**
	 * <h4>判断是否重名</h4>
	 * @param record 对象
	 * @return 大于0 表示 重名
	 */
	int isRename(Adsense record);

	/**
	 * <h4>更新状态</h4>
	 * @param id 主键
	 * @param status 状态值
	 * @return 受影响行数 大于0 表示 成功
	 */
	int upStatus(@Param("id")Integer id, @Param("status") Integer status);

	// ==================================== new create method ==================================== //


}
