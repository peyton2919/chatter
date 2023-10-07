package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.mapper.AppUpdateMapper;
import cn.peyton.children.chatter.param.AppUpdateParam;
import cn.peyton.children.chatter.service.AppUpdateService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 更新 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("appUpdateService")
public class AppUpdateServiceImpl implements AppUpdateService {
	@Resource
	private AppUpdateMapper appUpdateMapper;

	@Override
	public AppUpdateParam findByNewApp() {
		return new AppUpdateParam().compat(appUpdateMapper.findByNewApp());
	}

	@Override
	public boolean update(AppUpdateParam param) {

		return appUpdateMapper.updateByPrimaryKeySelective(param.convert()) > 0 ? true : false;
	}
}
