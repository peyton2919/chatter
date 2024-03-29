package cn.peyton.core.toolkit;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.Serializable;
import java.util.Properties;

/**
 * <h3>properties 工具类</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 16:01
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class PropertyTools implements Serializable {
    private static Properties props;
    private static PropertyTools instance;
    private static String dir;

    private PropertyTools(){
        try {
            Resource re = new ClassPathResource(dir);
            props = PropertiesLoaderUtils.loadProperties(re);

        } catch (Exception e) {

        }
    }

    /**
     * <h4>获取 PropertyUtil 对象</h4>
     * @param dir 路径
     * @return
     */
    public static synchronized PropertyTools getInstance(String dir){
        if (null == instance) {
            PropertyTools.dir = dir;
            instance = new PropertyTools();
        }
        return instance;
    }

    /**
     * <h4>获取 property值</h4>
     * @param key
     * @return
     */
    public String getProperty(String key){
        return props.getProperty(key);
    }

    /**
     * <h4>获取 property值</h4>
     * @param key
     * @param defaultValue 默认值
     * @return
     */
    public String getProperty(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }
}
