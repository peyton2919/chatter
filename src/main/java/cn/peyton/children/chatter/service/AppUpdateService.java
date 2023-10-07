package cn.peyton.children.chatter.service;

import cn.peyton.children.chatter.param.AppUpdateParam;

/**
 * <h3> 更新 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface AppUpdateService {

    /**
     * <h4>检查有上线的状态</h4>
     * @return
     */
    AppUpdateParam findByNewApp();

    /**
     * <h4>更新版本号</h4>
     * @return true 表示 更新成功; false 表示 取反
     */
    boolean update(AppUpdateParam param);
}
