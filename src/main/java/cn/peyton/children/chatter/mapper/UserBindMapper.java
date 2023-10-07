package cn.peyton.children.chatter.mapper;

import cn.peyton.children.chatter.pojo.UserBind;

import java.util.List;

/**
 * <h3> 第三方登录信息 Mapper 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface UserBindMapper {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(UserBind record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(UserBind record);

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
	int updateByPrimaryKey(UserBind record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(UserBind record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	UserBind selectByPrimaryKey(Integer id);


	// ==================================== new create method ==================================== //

	/**
	 * <h>根据用户编号 查找 用户绑定对象</h>
	 * @param id 用户编号
	 * @return
	 */
	List<UserBind> findByUserId(Integer id);

	/**
	 * <h4>判断 第三方账号 是否被 他人绑定</h4>
	 * @param userId 用户编号
	 * @param openId 第三方账号
	 * @param type 账号类型 {qq,weixin,xinaweibo}
	 * @return true 表示 可用 没有绑定过; false 表示 取反;
	 */
	int checkBindOther(int userId,String openId, String type);

	/**
	 * <h4>根据openId和type 查找 用户绑定</h4>
	 * @param openId
	 * @param type
	 * @return 用户绑定对象
	 */
	UserBind findByOpenIdAndType(String openId,String type);

}
