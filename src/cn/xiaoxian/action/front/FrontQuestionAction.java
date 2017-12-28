package cn.xiaoxian.action.front;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoxian.front.service.IFrontQuestionService;
import cn.xiaoxian.pojo.Question;
import cn.xiaoxian.util.HTMLReplaceMark;

@SuppressWarnings("serial")
@Repository
public class FrontQuestionAction extends ActionSupport {
	private IFrontQuestionService frontQuestionService = null;
	private Question question = new Question();//实例化对象
    private String code;//验证码
    private int tid;//问题类型id
    private int currentPage;//当前页
    private int lineSize;//每页显示
    private String tableName;
    private String column;//查询关键字段
    private String keyWord;//查询关键字
    public void setColumn(String column) {
		this.column = column;
	}
    public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
    
	public void setLineSize(int lineSize) {
		this.lineSize = lineSize;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Question getQuestion() {//获取vo对象
		return question;
	}
    @Resource(name="frontQuestionServiceImpl")
	public void setFrontQuestionService(IFrontQuestionService frontQuestionService) {
		this.frontQuestionService = frontQuestionService;
	}
    public  String insertPre()throws Exception{//提问前的准备操作
    	//调用服务层的方法
    	Map<String,Object> map=this.frontQuestionService.insertPre();//获取全部的问题类型
    	ServletActionContext.getRequest().setAttribute("allType", map.get("allType"));
    	return "insert";//跳转到问题的提交页
    }
    public  String insert()throws Exception{
    	this.question.setPubtime(new Timestamp(new Date().getTime()));//设置问题的发布日期
    	this.question.setCount(0);//设置问题的点击量
    	this.question.setStatus(1);//设置问题的状态
    	this.question.setContent(HTMLReplaceMark.replaceMark(this.question.getContent()));//转换符号
    	//调用服务层的方法
    	if(this.frontQuestionService.insert(this.question)){
    		//问题发布成功
    		ServletActionContext.getRequest().setAttribute("msg", "问题发布成功，请耐心等待智友回答!");
    	}else{
    		//问题发布失败
    		ServletActionContext.getRequest().setAttribute("msg", "问题发布失败，请重新发布或联系管理员!");
    	}
    	ServletActionContext.getRequest().setAttribute("path",ServletActionContext.getRequest().getContextPath()+"/jsp/front/frontQuestionAction_insertPre.action");
    	return "forward";
    }
    public  String validateCode()throws Exception{//验证验证码
    	//系统生成的验证码
    	String rand=(String)ServletActionContext.getRequest().getSession().getAttribute("rand");
    	//获取打一流对象
    	PrintWriter writer=ServletActionContext.getResponse().getWriter();
    	if(rand.equalsIgnoreCase(this.code)){
    		//验证码输入正确
    		writer.print("true");
    	}else{
    		//验证码输入错误
    		writer.print("false");
    	}
    	return null;
    }
    public String listAll()throws Exception{
    	System.out.println("问题类型tid:"+this.tid);
    	Map<String,Object> map=this.frontQuestionService.listAll(this.tid, this.currentPage, 5);
    	//传递问题的类型
    	//ServletActionContext.getRequest().setAttribute("tid",this.tid);
    	//所有类型
    	ServletActionContext.getRequest().setAttribute("allType", map.get("allType"));
    	ServletActionContext.getRequest().setAttribute("currentType", map.get("type"));
    	//已解决问题
    	ServletActionContext.getRequest().setAttribute("allQuestionStatus0", map.get("allQuestionStatus0"));
    	ServletActionContext.getRequest().setAttribute("allQuestionCountStatus0", map.get("allQuestionCountStatus0"));
    	//未解决问题
    	ServletActionContext.getRequest().setAttribute("allQuestionStatus1", map.get("allQuestionStatus1"));
    	ServletActionContext.getRequest().setAttribute("allQuestionCountStatus1", map.get("allQuestionCountStatus1"));
    	//零回答问题
    	ServletActionContext.getRequest().setAttribute("allQuestionCountZero", map.get("allQuestionCountZero"));
    	ServletActionContext.getRequest().setAttribute("allQuestionCountCountZero", map.get("allQuestionCountCountZero"));
    	//高悬赏问题
    	ServletActionContext.getRequest().setAttribute("allQuestionPoints", map.get("allQuestionPoints"));
    	ServletActionContext.getRequest().setAttribute("allQuestionCountPoints", map.get("allQuestionCountPoints"));
    	return "list";
    }
    public String listSplit()throws Exception{
    	System.out.println("tid:"+this.tid+",currentPage:"+this.currentPage+",lineSize:"+this.lineSize+",tableName:"+this.tableName);
    	Document doc=DocumentHelper.createDocument();//创建文档
    	Element allQuestions=doc.addElement("allQuestions");
    	Element question=null;
    	Element qid=null;//问题id
    	Element title=null;//问题标题
    	Element count=null;//问题回答量
    	Element status=null;//问题状态
    	List<Question> all=null;//问题列表
    	if("ebx01".equals(this.tableName)){//待解决问题
    		all=this.frontQuestionService.findAllByStatus(this.tid, this.currentPage, this.lineSize, 1);
    	}else if("ebx02".equals(this.tableName)){//已解决问题
    		all=this.frontQuestionService.findAllByStatus(this.tid, this.currentPage, this.lineSize, 0);
    	}else if("ebx03".equals(this.tableName)){//零回答问题
    		all=this.frontQuestionService.findAllByCount(this.tid, this.currentPage, this.lineSize, 0);
    	}else if("ebx04".equals(this.tableName)){//高悬赏问题
    		all=this.frontQuestionService.findAllByPoint(this.tid, this.currentPage, this.lineSize);
    	}
    	//获取迭代器对象
    	Iterator<Question> iter=all.iterator();
    	while(iter.hasNext()){
    		Question vo=iter.next();
    		System.out.println(vo.getTitle());//问题的标题
    		question=allQuestions.addElement("question");
    		qid=question.addElement("qid");
    		title=question.addElement("title");
    		count=question.addElement("count");
    		status=question.addElement("status");
    		qid.setText(String.valueOf(vo.getQid()));//设置文本内容
    		title.setText(vo.getTitle());
    		count.setText(String.valueOf(vo.getCount()));
    		status.setText(String.valueOf(vo.getStatus()));
    	}
    	//输出
    	OutputFormat format=OutputFormat.createPrettyPrint();
    	format.setEncoding("GBK");//设置编码格式
    	XMLWriter writer=new XMLWriter(ServletActionContext.getResponse().getOutputStream(),format);
    	writer.write(doc);
    	writer.close();
    	return null;
    }
    public  String show()throws Exception{
    	//设置属性，调用服务层方法
    	ServletActionContext.getRequest().setAttribute("question",this.frontQuestionService.get(this.question.getQid()));//保存question对象
    	return "show";
    }
    public String setNice()throws Exception{
    	//调用服务层方法
    	if(this.frontQuestionService.setNice(this.question)){
    		//设置成功
    		ServletActionContext.getRequest().setAttribute("msg", "最佳答案设置成功!");
    	}else{
    		ServletActionContext.getRequest().setAttribute("msg", "最佳答案设置失败!");
    	}
    	//设置跳转路径
    	ServletActionContext.getRequest().setAttribute("path",ServletActionContext.getRequest().getContextPath()+"/jsp/front/frontQuestionAction_show.action?question.qid="+this.question.getQid());
    	return "forward";
    }
    //搜索问题操作
    public String search()throws Exception{
    	System.out.print("column:"+this.column);
    	//进行条件的过滤
    	if(this.column==null){
    		this.column="title";//默认按title字段查询
    	}
    	if(this.keyWord==null){
    		this.keyWord="";//默认查询全部
    	}
    	if(this.currentPage==0){
    		this.currentPage=1;
    	}
    	if(this.lineSize==0){
    		this.lineSize=15;//默认每页显示15条
    	}
    	//调用服务层方法处理
    	Map<String,Object> map=this.frontQuestionService.findAll(this.column, this.keyWord, this.currentPage, this.lineSize);//获取搜索的结果
    	//设置属性
    	ServletActionContext.getRequest().setAttribute("allQuestions", map.get("allQuestions"));
    	ServletActionContext.getRequest().setAttribute("currentPage", this.currentPage);
		ServletActionContext.getRequest().setAttribute("lineSize", this.lineSize);
		ServletActionContext.getRequest().setAttribute("allRecorders", map.get("questionCount"));
		ServletActionContext.getRequest().setAttribute("actionUrl", ServletActionContext.getRequest().getContextPath()+"/jsp/front/frontQuestionAction_search.action");
		ServletActionContext.getRequest().setAttribute("column", this.column);
		ServletActionContext.getRequest().setAttribute("columnName", this.column);
		ServletActionContext.getRequest().setAttribute("defaultColumnName", "title");
		ServletActionContext.getRequest().setAttribute("keyWord", this.keyWord);
    	return "search";
    }
}
