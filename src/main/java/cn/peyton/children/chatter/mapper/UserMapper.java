package cn.peyton.children.chatter.mapper;

import cn.peyton.children.chatter.pojo.User;
import cn.peyton.core.page.PageQuery;

import java.util.List;

/**
 * <h3> 用户信息 Mapper 接口</h3>
 * <pre>
 *     1. 创建时间 create_time 需要自动创建 int（10)类
 *     2. 状态 status {0,1} 0不可用 1可用
 *     3.
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface UserMapper {
	/**
	 * <h4>插入 对象</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insert(User record);

	/**
	 * <h4>插入 对象[根据属性是否有值 插入]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int insertSelective(User record);

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
	int updateByPrimaryKey(User record);

	/**
	 * <h4>更新 对象[根据属性是否有值 更新]</h4>
	 * @param record 对象
	 * @return 受影响的行数
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * <h4>根据 主键 查找 对象</h4>
	 * @param id 主键
	 * @return 对象
	 */
	User selectByPrimaryKey(Integer id);


	// ==================================== new create method ==================================== //

	/**
	 * <h4>根据 用户编号 查找 用户传递类 对象</h4>
	 * <pre>
	 *     只返回: id,username,userPic,phone,email,createTime
	 *     条件: status = 1
	 * </pre>
	 * @param id 用户编号
	 * @return
	 */
	User findSimpleById(Integer id);

	/**
	 * <h4>扩展查找</h4>
	 * <pre>
	 *     找到: user 对象中去除状态{status}、密码{password}这二个值;
	 *          userInfo这二个对象;
	 * </pre>
	 * @param id 用户ID
	 * @return
	 */
	User findByExpand(Integer id);
	/**
	 * <h4>根据 手机号 查找 用户</h4>
	 * @param phone 手机号
	 * @return 用户对象
	 */
	User findByPhone(String phone);

	/**
	 * <h4>用户账户 登录 </h4>
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @param loginType 登录类型
	 * @return 用户对象
	 */
	User login(String username, String password, String loginType);

	/**
	 * <h4>判断用户是否被禁用</h4>
	 * @param keyword 用户名称
	 * @param type 类型 account:表示 用户名称 ; phone: 表示 用户手机
	 * @param status 状态 0 表示 禁用 ; 1 表示 可用 ;
	 * @return 0 表示 没查到数据行 ; 大于 0 表示 有查到数据行;
	 */
	int checkStatus(String keyword, String type,Integer status);

	/**
	 * <h4>判断用户是否重命名</h4>
	 * @param user 用户对象
	 * @return 0 表示 没查到数据行 ; 大于 0 表示 有查到数据行;
	 */
	int checkRename(User user);

	/**
	 * <h4>判断用户是否重命名</h4>
	 * @param keyword 关键字
	 * @param type 三种 username phone email
	 * @return
	 */
	int checkSimpleRename(String keyword, String type);
	/**
	 * <h4>判断 用户密码</h4>
	 * @param username 用户名称
	 * @param password 密码
	 * @return 返回受影响的行数 1 表示查到数; 0 表示取反;
	 */
	int checkPassword(String username, String password);

	/**
	 * TODO
	 * <h4>验证第三方登录是否绑定手机</h4>
	 * @param user 用户传参对象
	 * @return 返回受影响的行数; 1 表示查到数; 0 表示取反;
	 */
	int checkLoginIsBindPhone(User user);

	/**
	 * <h4>根据关键字，分页查找</h4>
	 * @param keyword 关键字
	 * @param page 分页对象
	 * @return 用户对象 集合
	 */
	List<User> search(String keyword, PageQuery page);

	/**
	 * <h4>更新 手机</h4>
	 *
	 * @param user 用户传参 对象
	 * @return 1 表示 更新成功; 0 表示 取反;
	 */
	int updatePhone(User user);

	/**
	 * <h4>更新 邮箱</h4>
	 *
	 * @param user 用户 对象
	 * @return 1 表示 更新成功; 0 表示 取反;
	 */
	int updateEmail(User user);

	/**
	 * <h4>更新 名称</h4>
	 * @param id 编号
	 * @param username 名称
	 * @return 1 表示 更新成功; 0 表示 取反;
	 */
	int updateName(Integer id, String username);

	/**
	 * <h4>判断 手机号码 是否被 他人绑定</h4>
	 * @param userId 用户编号
	 * @param phone 手机号码
	 * @return 1 表示 可用 有绑定过; false 表示 取反;
	 */
	int checkBindPhone(int userId, String phone);
	/**
	 * <h4>判断 手机号码 是否被 他人绑定</h4>
	 * @param userId 用户编号
	 * @param email 邮箱地址
	 * @return 1 表示 可用 有绑定过; false 表示 取反;
	 */
	int checkBindEmail(int userId, String email);

	/**
	 * <h4>判断用户编号 是否存在</h4>
	 * @param userId 用户编号
	 * @return 1 表示 用户存在; false 表示 取反;
	 */
	int checkUserId(int userId);

	/**
	 * <h4>更新用户头像</h4>
	 * @param id 用户编号
	 * @param userPic 头像地址
	 * @return 1 表示 插入成功; 0表示 取反;
	 */
	int updateUserPic(int id, String userPic);

	/**
	 * <h4>更新 用户密码</h4>
	 * @param id 用户编号
	 * @param password 密码
	 * @return 1 表示 插入成功; 0表示 取反;
	 */
	int updatePassword(int id, String password);

	/**
	 * <h4>用户关联粉丝表 根据用户编号 查找 用户对象集合</h4>
	 * @param userId
	 * @return
	 */
	List<User> findUserAndFollowByUserId(int userId);

	/**
	 * <h4>根据 用户 ID 查找密码 </h4>
	 * @param id 用户ID
	 * @return 密码
	 */
	String findPasswordById(Integer id);
}
