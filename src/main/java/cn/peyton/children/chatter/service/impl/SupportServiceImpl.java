package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.mapper.SupportMapper;
import cn.peyton.children.chatter.param.SupportParam;
import cn.peyton.children.chatter.pojo.Support;
import cn.peyton.children.chatter.service.SupportService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 支持 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("supportService")
public class SupportServiceImpl implements SupportService {
	@Resource
	private SupportMapper supportMapper;

	@Override
	public SupportParam isSupport(Integer userId, Integer postId) {
		Support support = supportMapper.checkSupport(userId, postId);
		if (null != support){
			return new SupportParam().compat(support);
		}
		return null;
	}

	@Override
	public SupportParam create(SupportParam param) {
		Support _support = param.convert();
		if (supportMapper.insertSelective(_support) > 0) {
			return new SupportParam().compat(_support);
		}
		return null;
	}

	@Override
	public boolean update(SupportParam param) {
		return supportMapper.updateByPrimaryKeySelective(param.convert()) > 0 ? true : false;
	}

	@Override
	public int findDingAndCaiByPostId(Integer postId, Integer type) {
		return supportMapper.findDingAndCaiByPostId(postId,type);
	}
}
