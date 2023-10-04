package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.service.ImagesService;
import cn.peyton.children.chatter.mapper.ImagesMapper;
import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;

/**
 * <h3> 图片 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("imagesService")
public class ImagesServiceImpl implements ImagesService {
	@Resource
	private ImagesMapper imagesMapper;

}
