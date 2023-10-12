package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.aop.timestamp.AutoWriteTimestamp;
import cn.peyton.children.chatter.bo.PostImageBo;
import cn.peyton.children.chatter.param.PostImageParam;
import cn.peyton.children.chatter.service.PostImageService;
import cn.peyton.children.chatter.mapper.PostImageMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

import java.util.List;

/**
 * <h3> 帖子图片关联 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("postImageService")
public class PostImageServiceImpl implements PostImageService {
	@Resource
	private PostImageMapper postImageMapper;

	@AutoWriteTimestamp
	@Override
	public List<PostImageParam> insertBatch(List<PostImageParam> postImageParamList) {
		PostImageBo _bo = new PostImageBo();
		List _postImages = _bo.reverse(postImageParamList);
		int result = postImageMapper.insertBatch(_postImages);
		if (result > 0) {
			return _bo.adapter(_postImages);

		}
		return null;
	}
}
