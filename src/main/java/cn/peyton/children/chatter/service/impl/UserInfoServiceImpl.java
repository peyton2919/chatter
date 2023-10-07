package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.mapper.UserInfoMapper;
import cn.peyton.children.chatter.param.UserInfoParam;
import cn.peyton.children.chatter.pojo.UserInfo;
import cn.peyton.children.chatter.service.UserInfoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 用户资料 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Resource
	private UserInfoMapper userInfoMapper;

	@Override
	public boolean updateUserInfo(UserInfoParam param) {
		UserInfo userInfo = userInfoMapper.findByUserId(param.convert().getUserId());
		int result = 0;
		if (null == userInfo) {
			result = userInfoMapper.insertSelective(param.convert());
		}else {
			param.setId(userInfo.getId());
			result = userInfoMapper.updateByPrimaryKeySelective(param.convert());
		}
		return result > 0 ? true : false;
	}

	@Override
	public UserInfoParam findByUserId(Integer usrId) {
		return new UserInfoParam().compat(userInfoMapper.findByUserId(usrId));
	}
}
