package cn.xiaoxian.back.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoxian.back.service.IBackNoticeService;
import cn.xiaoxian.dao.INoticeDAO;
import cn.xiaoxian.pojo.Notice;

@Service
public class BackNoticeServiceImpl implements IBackNoticeService {
	private INoticeDAO noticeDAO = null;

	@Resource(name = "noticeDAOImpl")//注入对象
	public void setNoticeDAO(INoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	@Override
	public boolean insert(Notice vo) throws Exception {
		return this.noticeDAO.doCreate(vo);
	}

	@Override
	public boolean delete(Integer nid) throws Exception {
		return this.noticeDAO.doRemove(nid);
	}

	@Override
	public boolean update(Notice vo) throws Exception {
		return this.noticeDAO.doUpdate(vo);
	}

	@Override
	public Notice get(Integer nid) throws Exception {
		return this.noticeDAO.findById(nid);
	}

	@Override
	public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();//实例化对象
		map.put("allNotices", this.noticeDAO.findAll(column, keyWord, currentPage, lineSize));//公告对象集
		map.put("noticeCount", this.noticeDAO.getAllCount(column, keyWord));//满足条件的记录数
		return map;
	}

}
