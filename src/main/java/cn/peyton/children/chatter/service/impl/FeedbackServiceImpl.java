package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.bo.FeedbackBo;
import cn.peyton.children.chatter.mapper.FeedbackMapper;
import cn.peyton.children.chatter.param.FeedbackParam;
import cn.peyton.children.chatter.service.FeedbackService;
import cn.peyton.core.page.PageQuery;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 反馈 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {
	@Resource
	private FeedbackMapper feedbackMapper;

	@Override
	public boolean create(FeedbackParam param) {
		return feedbackMapper.insertSelective(param.convert()) > 0 ? true : false;
	}

	@Override
	public List<FeedbackParam> finds(PageQuery page) {
		return new FeedbackBo().adapter(feedbackMapper.finds(page));
	}
}
