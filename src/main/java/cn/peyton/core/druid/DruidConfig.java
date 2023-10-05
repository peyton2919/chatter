package cn.peyton.core.druid;


import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * <h3></h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.core.druid.DruidConfig.java
 * @create date: 2021/11/1 19:10
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Configuration
public class DruidConfig  implements Serializable {
    //注册数据源，并绑定配置文件中以spring.datasource前缀开头的相关属性
   //@ConfigurationProperties(prefix = "spring.datasource")
   //@Bean
   //public DataSource druid(){
   //    return new DruidDataSource();
   //}
   //
   // /**
   //  * 配置Druid的监控<br>
   //  * 配置一个管理后台的Servlet<br>
   //  * @return
   //  */
   //
   //@Bean
   //public ServletRegistrationBean staViewServlet() {
   //    ServletRegistrationBean<StatViewServlet> bean =
   //            new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
   //    Map<String, String> initParams = new HashMap<>();
   //    //设置servlet初始化参数
   //    initParams.put("loginUsername","admin");//登陆名
   //    initParams.put("loginPassword","123456");//密码
   //    initParams.put("allow","");//默认就是允许所有访问
   //    initParams.put("deny","192.168.15.21");//拒绝相对应的id访问
   //    bean.setInitParameters(initParams);
   //    //加载到容器中
   //    return bean;
   //}
   //
   //@Bean
   //public FilterRegistrationBean webStatFilter(){
   //    FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
   //    bean.setFilter(new WebStatFilter());
   //    Map<String,String> initParams = new HashMap<>();
   //    //设置filter初始化参数、
   //    initParams.put("exclusions","*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");//排除静态资源和请求
   //    bean.setInitParameters(initParams);
   //    //拦截所有请求
   //    bean.setUrlPatterns(Arrays.asList("/*"));
   //    //加载到容器中
   //    return bean;
   //}
}
