package cn.xiaoxian.back.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoxian.back.service.IBackQuestionService;
import cn.xiaoxian.dao.IQuestionDAO;
import cn.xiaoxian.pojo.Question;

@Service
public class BackQuestionServiceImpl implements IBackQuestionService {
	@Resource(name = "questionDAOImpl")
	private IQuestionDAO questionDAO = null;

	public void setQuestionDAO(IQuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}

	@Override
	public Map<String, Object> listAll(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allQuestions", this.questionDAO.findAll(column, keyWord, currentPage, lineSize));
		map.put("questionCount", this.questionDAO.getAllCount(column, keyWord));
		return map;
	}

	@Override
	public Map<String, Object> listAllByStatus(String column, String keyWord, int currentPage, int lineSize, int status)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allQuestions", this.questionDAO.findAllByStatus(column, keyWord, currentPage, lineSize, status));//得到所有的问题的列表
		map.put("questionCount", this.questionDAO.getAllCountByStatus(column, keyWord, status));//获取统计量
		return map;
	}

	@Override
	public Question show(int qid) throws Exception {//查看问题
		return this.questionDAO.findById(qid);
	}

	@Override
	public boolean delete(int qid) throws Exception {//删除问题
		return this.questionDAO.doRemove(qid);
	}

	@Override
	//列出一个用户的全部提问
	public Map<String, Object> listAllByUser(String userid, String column, String keyWord, int currentPage,
			int lineSize) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();//实例化map集合
		map.put("allQuestions", this.questionDAO.findAllByUser(userid, column, keyWord, currentPage, lineSize));//得到一个用户的全部提问
		map.put("questionCount", this.questionDAO.getAllCountByUser(userid, column, keyWord));//得到一个用户的提问数
		return map;
	}

}
