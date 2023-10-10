package cn.peyton.children.chatter.service;

import cn.peyton.children.chatter.param.ImagesParam;
import cn.peyton.children.chatter.param.UserParam;

import java.util.List;

/**
 * <h3> 图片 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface ImagesService {

    /**
     * <h4>批量插入</h4>
     * @param imagesList 图片对象集合
     * @return 刚插入的图片对象集合
     */
    List<ImagesParam> insertBatch(List<ImagesParam> imagesList, UserParam userParam, String name, Integer num);
}
