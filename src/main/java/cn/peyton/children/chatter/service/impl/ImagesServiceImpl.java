package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.aop.timestamp.AutoWriteTimestamp;
import cn.peyton.children.chatter.bo.ImagesBo;
import cn.peyton.children.chatter.mapper.ImagesMapper;
import cn.peyton.children.chatter.param.ImagesParam;
import cn.peyton.children.chatter.pojo.Images;
import cn.peyton.children.chatter.service.ImagesService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@AutoWriteTimestamp
	@Override
	public List<ImagesParam> insertBatch(List<ImagesParam> imagesList) {
		//todo
		List<Images> _oImages = new ImagesBo().reverse(imagesList);
		imagesMapper.insertBatch(_oImages);
		return new ImagesBo().adapter(_oImages);
	}
}
