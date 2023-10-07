package cn.peyton.children.chatter.bo;

import cn.peyton.children.chatter.param.AdsenseParam;
import cn.peyton.children.chatter.pojo.Adsense;
import cn.peyton.core.inf.BaseConvertBo;

/**
 * <h3>广告 转换类 .bo</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @project name: plum
 * @class name: cn.peyton.plum.community.bo.AdsenseBo.java
 * @create date: 2021/11/9 12:56
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class AdsenseBo extends BaseConvertBo<AdsenseParam, Adsense> {
    @Override
    public AdsenseParam compat(Adsense info) {
        return new AdsenseParam().compat(info);
    }

    @Override
    public Adsense convert(AdsenseParam info) {
        return info.convert();
    }
}
