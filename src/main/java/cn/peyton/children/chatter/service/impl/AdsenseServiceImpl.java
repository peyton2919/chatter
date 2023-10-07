package cn.peyton.children.chatter.service.impl;

import cn.peyton.children.chatter.bo.AdsenseBo;
import cn.peyton.children.chatter.mapper.AdsenseMapper;
import cn.peyton.children.chatter.param.AdsenseParam;
import cn.peyton.children.chatter.pojo.Adsense;
import cn.peyton.children.chatter.service.AdsenseService;
import cn.peyton.core.page.PageQuery;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 广告 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年10月04日 20:11:31
 * @version 1.0.0
 * </pre>
*/
@Service("adsenseService")
public class AdsenseServiceImpl implements AdsenseService {
	@Resource
	private AdsenseMapper adsenseMapper;

	@Override
	public List<AdsenseParam> findByType(Integer type, PageQuery page) {
		return new AdsenseBo().adapter(adsenseMapper.findByType(type,page));
	}

	@Override
	public Adsense findById(Integer id) {
		return adsenseMapper.selectByPrimaryKey(id);
	}
}
