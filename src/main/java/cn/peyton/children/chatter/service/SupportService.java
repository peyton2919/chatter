package cn.peyton.children.chatter.service;

import cn.peyton.children.chatter.param.SupportParam;

/**
 * <h3> 支持 Service 接口</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
public interface SupportService {

    /**
     * <h4>判断这条信息有没有顶踩过</h4>
     * @param userId 用户编号
     * @param postId 文章编号
     * @return
     */
    SupportParam isSupport(Integer userId, Integer postId);

    /**
     * <h4>创建顶踩</h4>
     * @return true 表示 创建成功  false 表示 取反
     */
    SupportParam create(SupportParam param);

    /**
     * <h4>更新顶踩</h4>
     * @param param
     * @return true 表示 更新成功  false 表示 取反
     */
    boolean update(SupportParam param);

    /**
     * <h4>根据文章编号查找顶和踩的数量</h4>
     * @param postId 文章编号
     * @param type 查找类型0顶;1踩;
     * @return 返回 顶或踩的总数
     */
    int findDingAndCaiByPostId(Integer postId, Integer type);
}
