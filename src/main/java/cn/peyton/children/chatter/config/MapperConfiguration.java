package cn.peyton.children.chatter.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <h4></h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.children.chatter.config.MapperConfiguration
 * @date 2023年10月04日 20:45
 * @version 1.0.0
 * </pre>
 */
@MapperScan("cn.peyton.children.chatter.mapper")
@Configuration
public class MapperConfiguration {
}
