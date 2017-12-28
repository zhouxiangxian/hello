package cn.xiaoxian.action.back;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoxian.back.service.IBackQuestionService;
import cn.xiaoxian.pojo.Question;
import cn.xiaoxian.pojo.User;

@SuppressWarnings("serial")
@Repository
@Scope(value="prototype")
public class BackQuestionAction extends ActionSupport {
	private IBackQuestionService backQuestionService=null;
	@Resource(name="backQuestionServiceImpl")
	public void setBackQuestionService(IBackQuestionService backQuestionService) {
		this.backQuestionService = backQuestionService;
	}
	private int currentPage=1;//当前页
	private int lineSize=15;//每页显示
	private String keyWord;//查询关键字
	private String column;//查询关键字段
	private int status;//问题状态
	private Question question=new Question();
	private String backUrl;//处理删除跳转后的路径
	private  User user=new User();//实例化User对象
    public User getUser() {
		return user;
	}
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	public void getQuestion(Question question) {
		this.question = question;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setLineSize(int lineSize) {
		this.lineSize = lineSize;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String listAll()throws Exception{//查看全部问题列表
		if(this.currentPage==0){
			this.currentPage=1;//默认当前页为第一页
		}
		if(this.lineSize==0){
			this.lineSize=15;//默认每页显示15条记录
		}
		if(this.column==null){
			this.column="title";//默认按title字段查询
		}
		if(this.keyWord==null){
			this.keyWord="";//默认查询全部
		}
		//调用服务层
		Map<String,Object> map=this.backQuestionService.listAll(this.column, this.keyWord, this.currentPage, this.lineSize);//得到全部问题列表的信息
		//设置属性
		ServletActionContext.getRequest().setAttribute("allQuestions", map.get("allQuestions"));//公告信息
		ServletActionContext.getRequest().setAttribute("currentPage", this.currentPage);
		ServletActionContext.getRequest().setAttribute("lineSize", this.lineSize);
		ServletActionContext.getRequest().setAttribute("allRecorders", map.get("questionCount"));
		ServletActionContext.getRequest().setAttribute("actionUrl", ServletActionContext.getRequest().getContextPath()+"/jsp/back/backQuestionAction_listAll.action");
		ServletActionContext.getRequest().setAttribute("backUrl", "backQuestionAction_listAll.action");
		ServletActionContext.getRequest().setAttribute("column", this.column);
		ServletActionContext.getRequest().setAttribute("columnName", this.column);
		ServletActionContext.getRequest().setAttribute("defaultColumnName", "title");
		ServletActionContext.getRequest().setAttribute("keyWord", this.keyWord);
		return "list";
	}
	public String listAllByStatus()throws Exception{//根据问题的状态来查看问题列表
		if(this.currentPage==0){
			this.currentPage=1;//默认当前页为第一页
		}
		if(this.lineSize==0){
			this.lineSize=15;//默认每页显示15条记录
		}
		if(this.column==null){
			this.column="title";//默认按title字段查询
		}
		if(this.keyWord==null){
			this.keyWord="";//默认查询全部
		}
		//调用服务层
		Map<String,Object> map=this.backQuestionService.listAllByStatus(this.column, this.keyWord, this.currentPage, this.lineSize, this.status);//得到this.status状态的问题列表
		//设置属性
		ServletActionContext.getRequest().setAttribute("allQuestions", map.get("allQuestions"));//公告信息
		ServletActionContext.getRequest().setAttribute("currentPage", this.currentPage);
		ServletActionContext.getRequest().setAttribute("lineSize", this.lineSize);
		ServletActionContext.getRequest().setAttribute("allRecorders", map.get("questionCount"));
		ServletActionContext.getRequest().setAttribute("actionUrl", ServletActionContext.getRequest().getContextPath()+"/jsp/back/backQuestionAction_listAllByStatus.action");
		ServletActionContext.getRequest().setAttribute("backUrl", "backQuestionAction_listAllByStatus.action");//处理删除后的跳转路径
		ServletActionContext.getRequest().setAttribute("column", this.column);
		ServletActionContext.getRequest().setAttribute("columnName", this.column);
		ServletActionContext.getRequest().setAttribute("defaultColumnName", "title");
		ServletActionContext.getRequest().setAttribute("keyWord", this.keyWord);
		ServletActionContext.getRequest().setAttribute("status", this.status);
		return "list";
	}
	public String show() throws Exception{//显示问题
		//调用服务层方法
		//设置熟悉感
		ServletActionContext.getRequest().setAttribute("question", this.backQuestionService.show(this.question.getQid()));
		return "show";
	}
	
	public String  delete()throws Exception{//删除问题
		//调用服务层方法
		if(this.backQuestionService.delete(this.question.getQid())){
			//删除成功
			ServletActionContext.getRequest().setAttribute("msg", "提问删除成功!");
		}else{
			//删除失败
			ServletActionContext.getRequest().setAttribute("msg", "提问题删除失败!");
		}
		//设置跳转路径
		ServletActionContext.getRequest().setAttribute("path", ServletActionContext.getRequest().getContextPath()+"/jsp/back/"+this.backUrl);
		return "forward";
	}
	public String listAllByUser()throws Exception{
		System.out.println("user.userid:"+this.user.getUserid());
		if(this.currentPage==0){
			this.currentPage=1;//默认当前页为第一页
		}
		if(this.lineSize==0){
			this.lineSize=15;//默认每页显示15条记录
		}
		if(this.column==null){
			this.column="title";//默认按title字段查询
		}
		if(this.keyWord==null){
			this.keyWord="";//默认查询全部
		}
		//调用服务层
		Map<String,Object> map=this.backQuestionService.listAllByUser(this.user.getUserid(), this.column, this.keyWord, this.currentPage, this.lineSize);//得到一个用户提问的全部信息
		//设置属性
		ServletActionContext.getRequest().setAttribute("allQuestions", map.get("allQuestions"));//公告信息
		ServletActionContext.getRequest().setAttribute("currentPage", this.currentPage);
		ServletActionContext.getRequest().setAttribute("lineSize", this.lineSize);
		ServletActionContext.getRequest().setAttribute("allRecorders", map.get("questionCount"));
		ServletActionContext.getRequest().setAttribute("actionUrl", ServletActionContext.getRequest().getContextPath()+"/jsp/back/backQuestionAction_listAllByUser.action");
		ServletActionContext.getRequest().setAttribute("backUrl", "backQuestionAction_listAllByStatus.action");//处理删除后的跳转路径
		ServletActionContext.getRequest().setAttribute("column", this.column);
		ServletActionContext.getRequest().setAttribute("columnName", this.column);
		ServletActionContext.getRequest().setAttribute("defaultColumnName", "title");
		ServletActionContext.getRequest().setAttribute("keyWord", this.keyWord);
		ServletActionContext.getRequest().setAttribute("userid", this.user.getUserid());//将userid值传递下去
		return "list";
	}
}
