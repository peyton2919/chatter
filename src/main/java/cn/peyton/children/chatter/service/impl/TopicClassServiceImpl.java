package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.service.TopicClassService;
import cn.peyton.children.chatter.mapper.TopicClassMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * <h3> 话题分类 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("topicClassService")
public class TopicClassServiceImpl implements TopicClassService {
	@Resource
	private TopicClassMapper topicClassMapper;

}