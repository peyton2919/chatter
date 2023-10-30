package cn.peyton.children.chatter.cors;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * <h4>跨域配置类 第一种</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.core.cors.GlobalCorsConfig
 * @date 2023年10月12日 21:32
 * @version 1.0.0
 * </pre>
 */
//@Configuration
public class GlobalCorsConfig {

    //@Bean
    public CorsFilter corsFilter() {
        //1. 添加 CORS 配置信息
        CorsConfiguration config = new CorsConfiguration();
        //放行哪些原始域，即哪些域名可以访问咋们的接口；* 表示所有，不限制；多个时反复添加即可；
        //注意 127.0.0.1 与 localhost 也会仍然不同的地址.
        config.addAllowedOrigin("http://localhost:8080");
        config.addAllowedOrigin("http://127.0.0.1:8080");
        config.addAllowedOrigin("http://192.168.3.116:8080");
        //是否发送 Cookie
        config.setAllowCredentials(true);
        //放行哪些请求方式，GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
        config.addAllowedMethod("*");

        //放行哪些原始请求头部信息，不能设置 *: config.addAllowedHeader();
        //暴露哪些头部信息，不能设置 *: config.addExposedHeader();

        //2. 添加映射路径，即允许对方可以访问本应用下的哪些请求接口，/** 表示所有请求
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", config);

        //3. 返回新的 CorsFilter
        return new CorsFilter(corsConfigurationSource);
    }
}
