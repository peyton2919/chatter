package cn.peyton.children.chatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@ConfigurationProperties(prefix = "user", ignoreUnknownFields = false)
@PropertySource(value = "classpath:i18n/login.properties",encoding = "UTF-8")
public class ChatterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatterApplication.class, args);

    }

}
