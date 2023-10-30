package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.bo.FollowBo;
import cn.peyton.children.chatter.mapper.FollowMapper;
import cn.peyton.children.chatter.param.FollowParam;
import cn.peyton.children.chatter.pojo.Follow;
import cn.peyton.children.chatter.service.FollowService;
import cn.peyton.core.page.PageQuery;
import cn.peyton.core.toolkit.DateTools;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <h3> 关注 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("followService")
public class FollowServiceImpl implements FollowService {
	@Resource
	private FollowMapper followMapper;

	@Override
	public List<FollowParam> findByUserId(int userId) {
		return new FollowBo().adapter(followMapper.findByUserId(userId));
	}

	@Override
	public boolean isFollow(int followId, int userId) {
		return followMapper.checkFollow(followId, userId) > 0 ? true : false;
	}

	@Override
	public boolean add(int userId, int followId) {
		Follow _follow = new Follow();
		_follow.setCreateTime(DateTools.dateToTimestamp(new Date()));
		_follow.getFollowUser().setId(followId);
		_follow.setUserId(userId);
		return followMapper.insertSelective(_follow) > 0 ? true : false;
	}

	@Override
	public boolean delete(int userId, int followId) {
		return followMapper.deleteByUserIdAndFollowId(userId, followId) > 0 ? true : false;
	}

	@Override
	public List<FollowParam> friends(Integer userId, PageQuery page) {
		return new FollowBo().adapter(followMapper.friends(userId,page));
	}

	@Override
	public List<FollowParam> follows(Integer userId, PageQuery page, boolean fens) {

		return new FollowBo().adapter(followMapper.follows(userId, page, fens));
	}
}
