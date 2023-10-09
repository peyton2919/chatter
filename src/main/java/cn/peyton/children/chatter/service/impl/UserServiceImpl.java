package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.aop.timestamp.AutoWriteTimestamp;
import cn.peyton.children.chatter.bo.UserBo;
import cn.peyton.children.chatter.mapper.UserInfoMapper;
import cn.peyton.children.chatter.mapper.UserMapper;
import cn.peyton.children.chatter.param.UserInfoParam;
import cn.peyton.children.chatter.param.UserParam;
import cn.peyton.children.chatter.pojo.User;
import cn.peyton.children.chatter.pojo.UserInfo;
import cn.peyton.children.chatter.service.UserService;
import cn.peyton.core.cipher.BaseCipher;
import cn.peyton.core.page.PageQuery;
import cn.peyton.core.toolkit.StringTools;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <h3> 用户信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("userService")
public class UserServiceImpl implements UserService {

	/** MD5 加密 key */
	private final static String KEY_PASSWORD_ENCODER = "userControllerPassword";

	@Resource
	private UserMapper userMapper;
	@Resource
	private UserInfoMapper userInfoMapper;


	@Override
	public String encryptPW(String pw) {
		return BaseCipher.encoderMD5(pw,KEY_PASSWORD_ENCODER);
	}

	@AutoWriteTimestamp
	@Override
	@Transactional(rollbackFor = Exception.class)
	public UserParam reg(UserParam param) {
		// 密码加密
		param.setPassword(BaseCipher.encoderMD5(param.getPassword(),KEY_PASSWORD_ENCODER));
		User user = param.convert();
		int result = userMapper.insertSelective(user);
		//判断插入数据成功，给用户参数对象赋值，其中把密码 设 空
		if(result>0){
			//param.setId(user.getId());
			//param.setPassword("");
			//param.setConfirmPwd("");
			//todo 并注册 userInfo
			UserInfo _info = new UserInfo();
			_info.setUserId(user.getId());
			result = userInfoMapper.insertSelective(_info);
			param.setUserInfoParam(new UserInfoParam().compat(_info));
		}
		return (result>0)?param:null;
	}

	@Override
	public UserParam findByPhone(String phone) {
		User user = userMapper.findByPhone(phone);
		return (null != user) ? new UserParam().compat(user) : null;
	}

	@Override
	public UserParam login(String username, String password, String loginType) {
		User user = userMapper.login(username, BaseCipher.encoderMD5(password, KEY_PASSWORD_ENCODER), loginType);
		if (null == user) {
			return null;
		}
		return new UserParam().compat(user);
	}

	@Override
	public boolean isStatus(String keyword, String type,Integer status) {
		return userMapper.checkStatus(keyword, type, status) > 0 ? true : false;
	}

	@Override
	public boolean isRename(UserParam userParam) {
		return userMapper.checkRename(userParam.convert()) > 0 ? true:false;
	}

	@Override
	public String isSimpleRename(UserParam userParam) {
		int result = userMapper.checkSimpleRename(userParam.getUsername(), "username");
		if (result >0){
			return "该用户名称已经存在,请重新输入。";
		}
		if (!StringTools.isEmpty(userParam.getPhone())) {
			result = userMapper.checkSimpleRename(userParam.getPhone(), "phone");
		}
		if (result >0){
			return "该手机号码已经存在,请重新输入。";
		}
		if (!StringTools.isEmpty(userParam.getEmail())) {
			result = userMapper.checkSimpleRename(userParam.getEmail(), "email");
		}
		if (result > 0) {
			return "该邮箱号已经存在,请重新输入。";
		}
		return null;
	}

	@Override
	public boolean isPassword(String username, String password) {
		return false;
	}

	@Override
	public boolean otherLoginIsBindPhone(UserParam param) {
		return false;
	}

	@Override
	public List<UserParam> search(String keyword, PageQuery page) {
		return new UserBo().adapter(userMapper.search(keyword,page));
	}

	@Override
	public boolean updatePhone(UserParam param) {
		return userMapper.updatePhone(param.convert()) > 0 ? true : false;
	}

	@Override
	public boolean updateEmail(UserParam param) {
		return userMapper.updateEmail(param.convert()) > 0 ? true : false;
	}

	@Override
	public boolean isBindPhone(Integer userId, String phone) {
		return userMapper.checkBindPhone(userId, phone) > 0 ? true : false;
	}

	@Override
	public boolean isBindEmail(Integer userId, String email) {
		return userMapper.checkBindEmail(userId,email) > 0 ? true : false;
	}

	@Override
	public boolean updateUserPic(Integer id, String userPic) {
		return userMapper.updateUserPic(id, userPic) > 0 ? true : false;
	}

	@Override
	public boolean updatePassword(Integer id, String password) {
		return userMapper.updatePassword(id, encryptPW(password)) > 0 ? true : false;
	}

	@Override
	public boolean isUserId(Integer userId) {
		return userMapper.checkUserId(userId) > 0 ? true : false;
	}

	@Override
	public String findPasswordById(Integer id,String oldPassword) {
		String _pw = userMapper.findPasswordById(id);
		if (null == _pw) { return null; }
		if (_pw.equals(BaseCipher.encoderMD5(oldPassword,KEY_PASSWORD_ENCODER))){
			return _pw;
		}
		return null;
	}

	@Override
	public UserParam findById(Integer id) {
		User _user = userMapper.selectByPrimaryKey(id);
		return (null == _user) ? null : new UserParam().compat(_user);
	}
}
