package cn.peyton.core.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * <h3>SpringBoot 整合Servlet方式</h3>
 * <h4>1、以前方式需要在web.xml中配置以下：</h4>
 * <h4>
 *     <servlet>
 *         <servlet-name>MyServlet</servlet-name>
 *         <servlet-class>cn.peyton.plum.core.servlet.Myservlet</servlet-class>
 *     </servlet>
 * </h4>
 * <h4>
 *     <servlet-mapping>
 *          <servlet-name>MyServlet</servlet-name>
 *          <url-pattern>/*</url-pattern>
 *     </servlet-mapping>
 * </h4>
 * <h4>2、注解方式直接的类的头部添加</h4>
 * <h4>@WebServlet(name = "MyServlet",urlPatterns = "/*")</h4>
 * <h4>3、需要在启动类中添加 @ServletComponentScan</h4>
 * <h5>启用这个注解意思：在SpringBoot启动会扫描@WebServlet注解，并将该类实例化</h5>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.core.servlet.MyServlet.java
 * @create date: 2021/11/2 21:07
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
//@WebServlet(name = "MyServlet",urlPatterns = "/*")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
