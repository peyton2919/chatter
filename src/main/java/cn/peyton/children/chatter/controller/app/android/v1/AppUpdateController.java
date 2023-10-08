package cn.peyton.children.chatter.controller.app.android.v1;

import cn.peyton.children.chatter.param.AppUpdateParam;
import cn.peyton.children.chatter.service.AppUpdateService;
import cn.peyton.core.enums.HttpStatusCode;
import cn.peyton.core.json.JSONResult;
import cn.peyton.core.validator.Valid;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 更新 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@RestController
public class AppUpdateController {

	@Resource
	private AppUpdateService appUpdateService;

	// 检查更新
	@Valid
	@PostMapping("/update")
	public JSONResult<AppUpdateParam> update(AppUpdateParam param) {
		//查询 最新一条数据并 status =1
		AppUpdateParam _param = appUpdateService.findByNewApp();
		if (null == _param) {
			return JSONResult.fail(HttpStatusCode.ERR_NOT_UPDATE_APP.getMsg());
		}
		if (_param.getVersion().equals(param.getVersion())) {
			return JSONResult.fail(HttpStatusCode.ERR_NOT_UPDATE_APP.getMsg());
		}
		//todo 逻辑需要处理数值大小
		_param.setVersion(param.getVersion());
		// todo
		//_param.setCreateTime(new Date());
		if (appUpdateService.update(_param)) {
			return JSONResult.success(HttpStatusCode.SUCCESS_OPERATE_UPDATE.getMsg());
		}

		return JSONResult.fail(HttpStatusCode.ERR_OPERATE_UPDATE.getMsg());
	}
}
