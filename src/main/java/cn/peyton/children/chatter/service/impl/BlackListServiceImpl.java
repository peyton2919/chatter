package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.mapper.BlackListMapper;
import cn.peyton.children.chatter.param.BlackListParam;
import cn.peyton.children.chatter.service.BlackListService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 拉黑集 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("blackListService")
public class BlackListServiceImpl implements BlackListService {
	@Resource
	private BlackListMapper blackListMapper;


	@Override
	public boolean add(BlackListParam param) {
		return blackListMapper.insertSelective(param.convert()) > 0 ? true : false;
	}

	@Override
	public boolean isUserIdAndBlackId(Integer userId, Integer blackId) {
		return blackListMapper.checkUserIdAndBlackId(userId,blackId) > 0 ? true : false;
	}

	@Override
	public boolean delete(Integer userId, Integer blackId) {
		return blackListMapper.deleteByUserIdAndBlackId(userId, blackId) > 0 ? true : false;
	}

}
