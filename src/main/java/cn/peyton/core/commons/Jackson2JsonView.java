package cn.peyton.core.commons;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * <h3></h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.core.commons.Jackson2JsonView.java
 * @create date: 2021/11/7 13:39
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Component
public class Jackson2JsonView  implements Serializable {

    //@Bean
    //public MappingJackson2JsonView jsonView() {
    //    return new MappingJackson2JsonView();
    //}
    //
    //@Bean
    //public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
    //    ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
    //    List<View> list = new ArrayList<>();
    //    list.add(jsonView());
    //    resolver.setDefaultViews(list);
    //    return  resolver;
    //}
}
