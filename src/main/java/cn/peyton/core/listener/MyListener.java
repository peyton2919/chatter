package cn.peyton.core.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * <h3>SpringBoot 整合 Listener方式</h3>
 * <h4>1、以前方式需要在web.xml中配置以下：</h4>
 * <h4>
 *     <listener>
 *         <listener-class>cn.peyton.core.servlet.MyListener</listener-class>
 *     </listener>
 * </h4>
 * <h4>2、注解方式直接的类的头部添加</h4>
 * <h4>@WebListener</h4>
 * <h4>3、需要在启动类中添加 @ServletComponentScan</h4>
 * <h5>启用这个注解意思：在SpringBoot启动会扫描@WebFilter，并将该类实例化</h5>
 * <pre>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2021/11/2 21:47
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
//@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
