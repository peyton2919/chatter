package cn.peyton.children.chatter.service;

import cn.peyton.children.chatter.param.PostImageParam;

import java.util.List;

/**
 * <h3> 帖子图片关联 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface PostImageService {

    /**
     * <h4>批量插入</h4>
     *
     * @param postImageParamList 图片对象集合
     * @return 当前图片对象集合
     */
    List<PostImageParam> insertBatch(List<PostImageParam> postImageParamList);

}
