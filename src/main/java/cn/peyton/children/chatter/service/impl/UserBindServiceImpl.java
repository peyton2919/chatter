package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.bo.UserBindBo;
import cn.peyton.children.chatter.mapper.UserBindMapper;
import cn.peyton.children.chatter.param.UserBindParam;
import cn.peyton.children.chatter.pojo.UserBind;
import cn.peyton.children.chatter.service.UserBindService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 第三方登录信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("userBindService")
public class UserBindServiceImpl implements UserBindService {
	@Resource
	private UserBindMapper userBindMapper;

	@Override
	public boolean isBindOther(int userId, String openId, String type) {

		return userBindMapper.checkBindOther(userId, openId, type) > 0 ? true : false;
	}

	@Override
	public UserBindParam create(UserBindParam param) {
		UserBind userBind = param.convert();
		int result = userBindMapper.insertSelective(userBind);
		if (result > 0) {
			return param.compat(userBind);
		}
		return null;
	}

	@Override
	public List<UserBindParam> findByUserId(Integer id) {
		return new UserBindBo().adapter(userBindMapper.findByUserId(id));
	}

	@Override
	public UserBindParam findByOpenIdAndType(String openId, String type) {
		UserBind _userBind = userBindMapper.findByOpenIdAndType(openId, type);
		return (null != _userBind) ? new UserBindParam().compat(_userBind) : null;
	}
}
