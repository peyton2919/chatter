package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.aop.timestamp.Timestamp;
import cn.peyton.children.chatter.bo.PostClassBo;
import cn.peyton.children.chatter.mapper.PostClassMapper;
import cn.peyton.children.chatter.param.PostClassParam;
import cn.peyton.children.chatter.service.PostClassService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 帖子分类 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("postClassService")
public class PostClassServiceImpl implements PostClassService {
	@Resource
	private PostClassMapper postClassMapper;


	@Override
	public List<PostClassParam> finds() {
		return new PostClassBo().adapter(postClassMapper.finds());
	}

	@Timestamp
	@Override
	public int add(PostClassParam param) {

		System.out.println("执行[add]。。。。。。。");
		//param.builder();
		return postClassMapper.insertSelective(param.convert());
	}

	@Override
	public PostClassParam findById(Integer id) {

		return new PostClassBo().compat(postClassMapper.selectByPrimaryKey(id));
	}
}
