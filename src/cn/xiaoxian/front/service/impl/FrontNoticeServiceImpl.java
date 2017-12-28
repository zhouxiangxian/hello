package cn.xiaoxian.front.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoxian.dao.INoticeDAO;
import cn.xiaoxian.front.service.IFrontNoticeService;
import cn.xiaoxian.pojo.Notice;
@Service
public class FrontNoticeServiceImpl implements IFrontNoticeService {
	private INoticeDAO noticeDAO=null;
	@Resource(name="noticeDAOImpl")//注入对象
	public void setNoticeDAO(INoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	@Override
	
	//得到所有的公告信息，并获取公告的数量用于分页的处理
	public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();//实例化map对象
		map.put("allNotices", this.noticeDAO.findAll(column,keyWord,currentPage,lineSize));//获取所有的公告
		map.put("noticeCount", this.noticeDAO.getAllCount(column, keyWord));//获取公告数量，便于分页
		return map;//返回map集合对象
	}
	@Override
	//查看指定的公告信息
	public Notice get(int nid) throws Exception {
		return this.noticeDAO.findById(nid);
	}

}
