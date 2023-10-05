package cn.peyton.children.chatter.config;

import cn.peyton.children.chatter.interceptor.AdminLoginInterceptor;
import cn.peyton.children.chatter.interceptor.LoginInterceptor;
import jakarta.annotation.Resource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.config.MyWebMvcConfigurer
 * @date 2023年10月04日 22:26
 * @version 1.0.0
 * </pre>
 */
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    private AdminLoginInterceptor adminLoginInterceptor;
    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器，拦截以/admin为前缀的url路径（后台登陆拦截）
        registry.addInterceptor(adminLoginInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/dist/**")
                .excludePathPatterns("/admin/plugins/**");
        // 页面登陆拦截
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/admin/**")
                .excludePathPatterns("/register")
                .excludePathPatterns("/login")
                .excludePathPatterns("/logout")
                .addPathPatterns("/goods/detail/**")
                .addPathPatterns("/shop-cart")
                .addPathPatterns("/shop-cart/**")
                .addPathPatterns("/saveOrder")
                .addPathPatterns("/orders")
                .addPathPatterns("/orders/**")
                .addPathPatterns("/personal")
                .addPathPatterns("/personal/updateInfo")
                .addPathPatterns("/selectPayType")
                .addPathPatterns("/payPage");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:\\upload\\");
        registry.addResourceHandler("/goods-img/**").addResourceLocations("file:D:\\upload\\");
    }
}
