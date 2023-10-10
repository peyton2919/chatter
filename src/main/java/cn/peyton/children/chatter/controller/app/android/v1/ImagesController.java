package cn.peyton.children.chatter.controller.app.android.v1;

import cn.peyton.children.chatter.controller.base.AppController;
import cn.peyton.children.chatter.param.ImagesParam;
import cn.peyton.children.chatter.param.UserParam;
import cn.peyton.children.chatter.service.ImagesService;
import cn.peyton.children.chatter.service.UserService;
import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.enums.PROPERTY;
import cn.peyton.core.img.ImageProcessing;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.toolkit.base.Lists;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <h3> 图片 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@RestController
public class ImagesController extends AppController {
	private final String IMAGES_PRODUCT = "/images/product/";

	@Resource
	private ImagesService imagesService;
	@Resource
	private UserService userService;

	// 上传单图或多图
	@PostMapping(value = "/user/imgs/uploadmore")
	public JSONResult<List<ImagesParam>> uploadMore(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();
		UserParam _userParam = (UserParam) session.getAttribute(PROPERTY.SESSION_USER);
		//todo
		_userParam = userService.findById(1);
		List<ImagesParam> _list = Lists.newArrayList();

		ImagesParam _p = null;
		if (null != files) {
			for (MultipartFile file : files) {
				String _path = ImageProcessing.execute(file.getInputStream(),
						file.getOriginalFilename(), PROPERTY.PATH_IMG_PRODUCT, null);

				_p = new ImagesParam();
				_p.setUserId(_userParam.getId());
				_p.setUrl(IMAGES_PRODUCT + _path);
				_list.add(_p);
			}
			List<ImagesParam> _results = imagesService.insertBatch(_list,_userParam,"测试数据",100);
			return JSONResult.success(_results);
		}

		return JSONResult.fail(HttpStatusCode.ERR_IMAGE_UPLOAD);
	}

}
