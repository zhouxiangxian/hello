package cn.xiaoxian.action.front;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoxian.front.service.IFrontAnswerService;
import cn.xiaoxian.pojo.Answer;

@SuppressWarnings("serial")
@Repository
public class FrontAnswerAction extends ActionSupport {
	private IFrontAnswerService frontAnswerService;
	private Answer answer=new Answer();
	public Answer getAnswer() {
		return answer;
	}
    @Resource(name="frontAnswerServiceImpl")
	public void setFrontAnswerService(IFrontAnswerService frontAnswerService) {
		this.frontAnswerService = frontAnswerService;
	}
	public String insert()throws Exception{//回答问题的提交
		//调用服务层方法
		//设置回答时间
		this.answer.setRetdate(new Timestamp(System.currentTimeMillis()));
		if(this.frontAnswerService.insert(this.answer)){
			//提交回答成功
			ServletActionContext.getRequest().setAttribute("msg","您的回答已经提交，请耐心等待!");
		}else{
			//回答失败
			ServletActionContext.getRequest().setAttribute("msg","您的回答提交，请重新操作!");
		}
		//设置跳转路径
		ServletActionContext.getRequest().setAttribute("path",ServletActionContext.getRequest().getContextPath()+"/jsp/front/frontQuestionAction_show?question.qid="+this.answer.getQuestion().getQid());
		return "forward";
	}

}
