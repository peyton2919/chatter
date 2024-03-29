package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.aop.timestamp.AutoWriteTimestamp;
import cn.peyton.children.chatter.bo.PostBo;
import cn.peyton.children.chatter.mapper.PostMapper;
import cn.peyton.children.chatter.mapper.SupportMapper;
import cn.peyton.children.chatter.param.PostParam;
import cn.peyton.children.chatter.pojo.Post;
import cn.peyton.children.chatter.pojo.Support;
import cn.peyton.children.chatter.service.PostService;
import cn.peyton.core.page.PageQuery;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 帖子 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("postService")
public class PostServiceImpl implements PostService {
	@Resource
	private PostMapper postMapper;


	@Resource
	private SupportMapper supportMapper;

	@AutoWriteTimestamp
	@Override
	public boolean add(PostParam param) {
		Post _post = param.convert();
		int result = postMapper.insertSelective(_post);
		if (result > 0) {
			param.compat(_post);
			return true;
		}
		return false;
	}

	@Override
	public boolean isPost(Integer id) {
		return postMapper.checkPost(id) > 0 ? true : false;
	}

	@Override
	public List<PostParam> findByClassId(int postClassId,int userId, PageQuery page) {
		List<Post> posts = postMapper.findByClassId(postClassId, page);
		if (null != posts && posts.size() > 0) {
			for (int i = 0; i < posts.size(); i++) {
				Support support = supportMapper.findByPostIdAndUserId(posts.get(i).getId(), userId);
				posts.get(i).setSupport(support);
			}
		}
		return new PostBo().adapter(posts) ;
	}

	@Override
	public List<PostParam> search(String keyword, PageQuery page) {

		return new PostBo().adapter(postMapper.search(keyword,page));
	}

	@Override
	public PostParam findByPrimaryKey(Integer id) {

		return new PostBo().compat(postMapper.selectByPrimaryKey(id));
	}

	@Override
	public List<PostParam> findByTopicId(int topicId, PageQuery page,int type) {
		return new PostBo().adapter(postMapper.findByTopicId(topicId,page,type));
	}

	@Override
	public List<PostParam> findByUserId(int userId, PageQuery page) {
		return new PostBo().adapter(postMapper.findByUserId(userId,page));
	}

	@Override
	public List<PostParam> findByPKUserId(int userId, PageQuery page) {
		return new PostBo().adapter(postMapper.findByPKUserId(userId,page));
	}
}
