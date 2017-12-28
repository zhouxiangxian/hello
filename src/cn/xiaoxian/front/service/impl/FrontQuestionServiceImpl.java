package cn.xiaoxian.front.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoxian.dao.IQuestionDAO;
import cn.xiaoxian.dao.ITypeDAO;
import cn.xiaoxian.dao.IUserDAO;
import cn.xiaoxian.front.service.IFrontQuestionService;
import cn.xiaoxian.pojo.Question;
import cn.xiaoxian.pojo.Type;

//问题服务层的实现类
@Service
public class FrontQuestionServiceImpl implements IFrontQuestionService {
	private ITypeDAO typeDAO = null;
	private IQuestionDAO questionDAO = null;
	private IUserDAO userDAO = null;

	@Resource(name = "userDAOImpl")
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Resource(name = "typeDAOImpl")
	public void setTypeDAO(ITypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}

	@Resource(name = "questionDAOImpl")
	public void setQuestionDAO(IQuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}

	@Override
	public Map<String, Object> insertPre() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();// 实例化对象
		map.put("allType", this.typeDAO.findAll());// 保存所有的问题类型
		return map;
	}

	@Override
	public boolean insert(Question vo) throws Exception {
		return this.questionDAO.doCreate(vo);
	}

	@Override
	public Map<String, Object> listAll(int tid, int currentPage, int lineSize) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Type> allType = this.typeDAO.findAll();// 查询全部问题类型
		Type type = this.typeDAO.findById(tid);// 根据tid查找
		if (type == null) {
			tid = (Integer) allType.get(0).getTid();// 获取第一个数据的类型id
			type = allType.get(0);
		}
		// 全部的问题分类:使用Action传递到jsp中的属性:allType(查询TypeDAO)
		map.put("allType", allType);
		map.put("type", type);
		// 2:已解决问题:allQuestionStatus0、allQuestionCountStatus0
		map.put("allQuestionStatus0", this.questionDAO.findAllByStatus(tid, "title", "", currentPage, lineSize, 0));
		map.put("allQuestionCountStatus0", this.questionDAO.getAllCountByStatus(tid, "title", "", 0));
		// 未解决问题:allQuestionStatus1、allQuestionCountStatus1
		map.put("allQuestionStatus1", this.questionDAO.findAllByStatus(tid, "title", "", currentPage, lineSize, 1));
		map.put("allQuestionCountStatus1", this.questionDAO.getAllCountByStatus(tid, "title", "", 1));
		// 零回答问题:allQuestionCountZero、allQuestionCountCountZero
		map.put("allQuestionCountZero", this.questionDAO.findAllByCount(tid, "title", "", currentPage, lineSize, 0));
		map.put("allQuestionCountCountZero", this.questionDAO.getAllCountByCount(tid, "title", "", 0));
		// 高悬赏问题:allQuestionPoints、allQuestionCountPoints(未解决问题的高悬赏分)
		map.put("allQuestionPoints", this.questionDAO.findAllByPoints(tid, "title", "", currentPage, lineSize, 1));
		map.put("allQuestionCountPoints", this.questionDAO.getAllCountByPoints(tid, "title", "", 1));
		return map;
	}

	@Override
	public List<Question> findAllByStatus(int tid, int currentPage, int lineSize, int status) throws Exception {
		return this.questionDAO.findAllByStatus(tid, "title", "", currentPage, lineSize, status);
	}

	@Override
	public List<Question> findAllByCount(int tid, int currentPage, int lineSize, int count) throws Exception {
		return this.questionDAO.findAllByCount(tid, "title", "", currentPage, lineSize, count);
	}

	@Override
	public List<Question> findAllByPoint(int tid, int currentPage, int lineSize) throws Exception {
		return this.questionDAO.findAllByPoints(tid, "title", "", currentPage, lineSize, 1);// 未解决问题的最高悬赏分
	}

	@Override
	public Question get(Integer qid) throws Exception {
		// 调用数据层方法
		return this.questionDAO.findById(qid);
	}

	@Override
	/**
	 * 更改问题的最佳答案、 更改问题的状态、提问者的扣分、回答者的加分
	 */
	public boolean setNice(Question vo) throws Exception {
		return this.questionDAO.updateAnswer(vo) && this.questionDAO.updateStatus(vo.getQid(), 0)
				&& this.userDAO.updatePoints(vo.getUser().getUserid(), 0-vo.getPoints()) && this.userDAO
						.updatePoints(vo.getAnswer().getUser().getUserid(), vo.getPoints());
	}

	@Override
	//搜索问题
	public Map<String,Object> findAll(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();//实例化对象
		map.put("allQuestions", this.questionDAO.findAll(column, keyWord, currentPage, lineSize));//搜索到的全部问题
		map.put("questionCount", this.questionDAO.getAllCount(column, keyWord));//所有的记录数
		return map;
	}
}
