/**
 * <h3>SpringBoot 整合 Listener （都用到了MyFilter类）</h3>
 * <pre>
 *     第一种 用注解方式
 *          1、在 WebListener 类头部的添加
 *              @WebListener
 *          2、在启动类头部添加Servlet扫描注解
 *              @ServletComponentScan
 *     第二种 方法
 *     直接在启动类中添加这个方法,不用在任何地方用注解
 *     @Bean
 *     public ServletListenerRegistrationBean<MyListener> getServletListenerRegistrationBean(){
 *         return new ServletListenerRegistrationBean<MyListener> ();
 *     }
 * </pre>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
 */
package cn.peyton.core.listener;