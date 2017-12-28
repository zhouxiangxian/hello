package cn.xiaoxian.back.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoxian.back.service.IBackAnswerService;
import cn.xiaoxian.dao.IAnswerDAO;
import cn.xiaoxian.dao.IQuestionDAO;
import cn.xiaoxian.pojo.Question;
//服务层实现类
@Service
public class BackAnswerServiceImpl implements IBackAnswerService {
	private IAnswerDAO answerDAO=null;
	private IQuestionDAO questionDAO=null;
	@Resource(name="questionDAOImpl")
	public void setQuestionDAO(IQuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}
	@Resource(name="answerDAOImpl")//注入对象
    public void setAnswerDAO(IAnswerDAO answerDAO) {
		this.answerDAO = answerDAO;
	}
	@Override
	public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();//实例化map集合
		map.put("allAnswers", this.answerDAO.findAll(column, keyWord, currentPage, lineSize));//所有的回答
		map.put("answerCount", this.answerDAO.getAllCount(column, keyWord));
		return map;
	}
	@Override
	public boolean delete(int id) throws Exception {//删除回答
		//调用数据层方法
		Question vo=this.questionDAO.findByAnswer(id);
		if(vo!=null){
			//该回答是最佳答案，要删除此回答则得先将问题给删除
			return this.questionDAO.doRemove(vo.getQid());
		}else{
			//该回答不是最佳答案，可以直接删除
			return this.answerDAO.doRemove(id);
		}
	}

}
