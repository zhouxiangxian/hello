package cn.xiaoxian.front.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoxian.dao.IQuestionDAO;
import cn.xiaoxian.dao.IUserDAO;
import cn.xiaoxian.front.service.IFrontUserCenterService;
import cn.xiaoxian.pojo.User;

@Service
public class FrontUserCenterServiceImpl implements IFrontUserCenterService {
	private IUserDAO userDAO = null;
	private IQuestionDAO questionDAO = null;

	@Resource(name = "userDAOImpl")
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Resource(name = "questionDAOImpl")
	public void setQuestionDAO(IQuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}

	@Override
	public Map<String, Object> getStat(String userid) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();// 实例化对象
		//用户提问的个数
		map.put("allQuestionCount", this.questionDAO.getAllCountByUser(userid, "title", ""));
		
		map.put("questionCountStatus0", this.questionDAO.getAllCountByUser(userid, "title", "", 0));
		map.put("userPoints", this.userDAO.findById(userid).getPoints());
		return map;
	}

	@Override
	public int getUserPoints(String userid) throws Exception {
		// 调用数据层方法，获取用户信息
		User user = this.userDAO.findById(userid);
		return user.getPoints();// 返回用户分数
	}

	public User get(String userid) throws Exception {
		// 调用数据层发
		return this.userDAO.findById(userid);

	}

	@Override
	public boolean update(User vo) throws Exception {
		// 调用数据层方法
		return this.userDAO.updateInfo(vo);
	}

	@Override
	public boolean updatePassword(User vo, String oldPassword) throws Exception {
		// 先检查登录
		User user = new User();
		user.setUserid(vo.getUserid());// 封装用户id
		user.setPassword(oldPassword);// 密码的加密处理在action层中完成
		if (this.userDAO.findLogin(user)) {
			// 使用旧的密码可以登录成功
			// 进行新密码的修改
			if (this.userDAO.updatePassword(vo)) {
				// 密码修改成功
				return true;
			} else {
				// 密码修改失败
				return false;
			}
		}
		return false;
	}

	@Override
	public Map<String, Object> listByStatus(String userid, String column, String keyWord, int currentPage, int lineSize,
			int status) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();// 实例化对象
		map.put("allQuestions", this.questionDAO.findAllByUser(userid, column, keyWord, currentPage, lineSize, status));// 问题列表
		map.put("questionCount", this.questionDAO.getAllCountByUser(userid, column, keyWord, status));// 问题个数
		return map;
	}

	@Override
	public Map<String, Object> listZeroAnswer(String userid, String column, String keyWord, int currentPage,
			int lineSize, int status, int count) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();// 实例化对象
		map.put("allQuestions",
				this.questionDAO.findAllByUser(userid, column, keyWord, currentPage, lineSize, status, count));// 问题列表
		map.put("questionCount", this.questionDAO.getAllCountByUser(userid, column, keyWord, status, count));
		return map;
	}

	@Override
	public boolean deleteQuestion(String userid, int qid) throws Exception {
		return this.questionDAO.doRemoveByUser(userid, qid);
	}

	@Override
	public Map<String, Object> listAnswer(String userid, String column, String keyWord, int currentPage, int lineSize)
			throws Exception {
        Map<String,Object> map=new HashMap<String,Object>();//实例化对象
        map.put("allQuestions", this.questionDAO.findAllByAnswer(userid, column, keyWord, currentPage, lineSize));//保存问题列表
        map.put("questionCount", this.questionDAO.getAllCountByAnswer(userid, column, keyWord));//未被采纳问题的记录数
		return map;
	}

	@Override
	public Map<String, Object> listAcceptAnswer(String userid, String column, String keyWord, int currentPage,
			int lineSize) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();//实例化对象
		map.put("allQuestions", this.questionDAO.findAllAcceptAnswer(userid, column, keyWord, currentPage, lineSize));//保存所有被采纳问题的列表
		map.put("questionCount", this.questionDAO.getAllCountAcceptAnswer(userid, column, keyWord));//被采纳问题的记录数
		return map;
	}

}
