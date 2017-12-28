package cn.xiaoxian.front.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoxian.dao.IAnswerDAO;
import cn.xiaoxian.dao.IQuestionDAO;
import cn.xiaoxian.front.service.IFrontAnswerService;
import cn.xiaoxian.pojo.Answer;

@Service
public class FrontAnswerServiceImpl implements IFrontAnswerService{
	private IAnswerDAO answerDAO;
	private IQuestionDAO questionDAO;
    @Resource(name="answerDAOImpl")
	public void setAnswerDAO(IAnswerDAO answerDAO) {
		this.answerDAO = answerDAO;
	}
    @Resource(name="questionDAOImpl")
	public void setQuestionDAO(IQuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}
	@Override
	public boolean insert(Answer vo) throws Exception {
		//调用数据层方法提交回答以及修改问题的回答量
		return this.answerDAO.doCreate(vo)&&this.questionDAO.updateCount(vo.getQuestion().getQid());
	}
    
}
