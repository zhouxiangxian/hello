package cn.xiaoxian.action.back;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoxian.back.service.IBackAnswerService;
import cn.xiaoxian.pojo.Answer;

@SuppressWarnings("serial")
@Scope(value="prototype")
@Repository
public class BackAnswerAction extends ActionSupport {
	private IBackAnswerService backAnswerService=null;
	private String column;
	private String keyWord;
	private int currentPage=1;
	private int lineSize=15;
	private Answer answer=new Answer();
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setLineSize(int lineSize) {
		this.lineSize = lineSize;
	}
	@Resource(name="backAnswerServiceImpl")
	public void setBackAnswerService(IBackAnswerService backAnswerService) {
		this.backAnswerService = backAnswerService;
	}
	
	public String list()throws Exception{//列出所有的回答
		if(this.column==null){
			this.column="content";//默认按内容查询
		}
		if(this.keyWord==null){
			this.keyWord="";//查询全部
		}
		if(this.currentPage==0){
			this.currentPage=1;//默认为第一页
		}
		if(this.lineSize==0){
			this.lineSize=15;//默认每一显示15条数据
		}
		//调用服务层方法处理
		Map<String,Object> map=this.backAnswerService.list(this.column, this.keyWord, this.currentPage, this.lineSize);//列出所有回答的信息
		//设置属性
		ServletActionContext.getRequest().setAttribute("allAnswers", map.get("allAnswers"));//公告信息
		ServletActionContext.getRequest().setAttribute("currentPage", this.currentPage);
		ServletActionContext.getRequest().setAttribute("lineSize", this.lineSize);
		ServletActionContext.getRequest().setAttribute("allRecorders", map.get("answerCount"));
		ServletActionContext.getRequest().setAttribute("actionUrl", ServletActionContext.getRequest().getContextPath()+"/jsp/back/backAnswerAction_list.action");
		ServletActionContext.getRequest().setAttribute("column", this.column);
		ServletActionContext.getRequest().setAttribute("columnName", this.column);
		ServletActionContext.getRequest().setAttribute("defaultColumnName", "content");//默认按content字段查询
		ServletActionContext.getRequest().setAttribute("keyWord", this.keyWord);
		return "list";
	}
	public String delete()throws Exception{//删除问题操作
		//调用服务层方法
		if(this.backAnswerService.delete(this.answer.getAid())){
			//回答删除成功
			ServletActionContext.getRequest().setAttribute("msg", "回答删除成功!");
		}else{
			//回答删除失败
			ServletActionContext.getRequest().setAttribute("msg", "回答删除失败!");
		}
		//设置跳转路径
		ServletActionContext.getRequest().setAttribute("path",ServletActionContext.getRequest().getContextPath()+"/jsp/back/backAnswerAction_list.action");
		return "forward";
	}

}
