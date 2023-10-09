package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.aop.timestamp.AutoWriteTimestamp;
import cn.peyton.children.chatter.bo.TopicClassBo;
import cn.peyton.children.chatter.mapper.TopicClassMapper;
import cn.peyton.children.chatter.param.TopicClassParam;
import cn.peyton.children.chatter.pojo.TopicClass;
import cn.peyton.children.chatter.service.TopicClassService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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
	
	@Override
	public List<TopicClassParam> finds() {
		return new TopicClassBo().adapter(topicClassMapper.finds());
	}

	@AutoWriteTimestamp
	@Override
	public boolean add(TopicClassParam param) {
		TopicClass _tc = param.convert();
		int _result = topicClassMapper.insertSelective(_tc);
		if (_result > 0) {
			param.compat(_tc);
			return true;
		}
		return false;
	}

	@Override
	public boolean isRename(String className) {
		return topicClassMapper.isRename(className) > 0 ? true : false;
	}
}
