package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.bo.TopicBo;
import cn.peyton.children.chatter.mapper.TopicMapper;
import cn.peyton.children.chatter.param.TopicParam;
import cn.peyton.children.chatter.service.TopicService;
import cn.peyton.core.page.PageQuery;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 话题 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("topicService")
public class TopicServiceImpl implements TopicService {
	@Resource
	private TopicMapper topicMapper;

	@Override
	public List<TopicParam> findByTopicId(int topicClassId, PageQuery page) {
		return new TopicBo().adapter(topicMapper.findByTopicClassId(topicClassId,page));
	}

	@Override
	public List<TopicParam> findByHot(int topicClassId, PageQuery page) {
		return new TopicBo().adapter(topicMapper.findByHot(topicClassId,page));
	}

	@Override
	public List<TopicParam> search(String keyword, PageQuery page) {
		return new TopicBo().adapter(topicMapper.search(keyword,page));
	}

}
