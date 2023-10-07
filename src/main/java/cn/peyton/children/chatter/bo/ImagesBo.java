package cn.peyton.children.chatter.bo;

import cn.peyton.children.chatter.param.ImagesParam;
import cn.peyton.children.chatter.pojo.Images;
import cn.peyton.core.inf.BaseConvertBo;

/**
 * <h3>图片 转换类 .bo</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.chatter.bo.ImagesBo.java
 * @create date: 2022/3/28 15:48
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class ImagesBo extends BaseConvertBo<ImagesParam, Images> {
    @Override
    public ImagesParam compat(Images info) {
        return new ImagesParam().compat(info);
    }

    @Override
    public Images convert(ImagesParam info) {
        return info.convert();
    }
}
