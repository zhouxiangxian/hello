package cn.xiaoxian.front.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoxian.dao.INoticeDAO;
import cn.xiaoxian.dao.IQuestionDAO;
import cn.xiaoxian.dao.ITypeDAO;
import cn.xiaoxian.dao.IUserDAO;
import cn.xiaoxian.front.service.IFrontIndexService;
@Service
public class FrontIndexServiceImpl implements IFrontIndexService {
	private IQuestionDAO questionDAO=null;
	private IUserDAO userDAO=null;
	private ITypeDAO typeDAO=null;
	private INoticeDAO noticeDAO=null;
	@Resource(name="questionDAOImpl")//注入对象
	public void setQuestionDAO(IQuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}
	@Resource(name="userDAOImpl")
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	@Resource(name="typeDAOImpl")
	public void setTypeDAO(ITypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}
	@Resource(name="noticeDAOImpl")
	public void setNoticeDAO(INoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	@Override
	public Map<String, Object> index() throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();//实例化对象
		map.put("questionCountStatus0", this.questionDAO.getAllCountByStatus(0));//已解决问题数量
		map.put("questionCountStatus1", this.questionDAO.getAllCountByStatus(1));//未解决问题数量
		map.put("allTypes", this.typeDAO.findAll());//所有的问题分类
		map.put("questionsStatus1", this.questionDAO.findAllByStatus("title", "", 1, 10, 1));//未解决问题
		map.put("questionsStatus0", this.questionDAO.findAllByStatus("title", "", 1, 10, 0));//已解决问题
		map.put("allNotices", this.noticeDAO.findAll());//所有公告信息
		map.put("allUsers", this.userDAO.findAll("userid", "", 1, 10));//所有用户信息
		return map;
	}

}
