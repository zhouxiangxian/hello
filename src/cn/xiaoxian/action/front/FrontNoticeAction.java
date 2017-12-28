package cn.xiaoxian.action.front;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoxian.front.service.IFrontNoticeService;
import cn.xiaoxian.pojo.Notice;

@SuppressWarnings("serial")
@Scope(value="prototype")
@Repository
public class FrontNoticeAction extends ActionSupport {
	private IFrontNoticeService frontNoticeService=null;
	private Notice notice=new Notice();//实例化notice对象
	public Notice getNotice() {
		return notice;
	}
	private String column;//分页要查询关键字段
	private String keyWord;//分页要查询关键字
	private int currentPage;//当前页,分页处理
	private int lineSize;//每页显示,分页处理
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
	@Resource(name="frontNoticeServiceImpl")//注入对象
	public void setFrontNoticeService(IFrontNoticeService frontNoticeService) {
		this.frontNoticeService = frontNoticeService;
	}
	//查看所有的公告信息，用分页处理
	public String list()throws Exception{
		//进行条件过滤
		if(this.column==null){
			this.column="title";//默认按照title字段进行查询
		}
		if(this.keyWord==null){
			this.keyWord="";//默认查询全部
		}
		if(this.currentPage==0){
			this.currentPage=1;//默认为第一页
		}
		if(this.lineSize==0){
			this.lineSize=15;//默认每页显示15条数据
		}
		//调用服务层方法
		Map<String,Object> map=this.frontNoticeService.list(column, keyWord, currentPage, lineSize);
		//设置属性
		ServletActionContext.getRequest().setAttribute("allNotices", map.get("allNotices"));
		ServletActionContext.getRequest().setAttribute("currentPage", this.currentPage);
		ServletActionContext.getRequest().setAttribute("lineSize", this.lineSize);
		ServletActionContext.getRequest().setAttribute("allRecorders", map.get("noticeCount"));
		ServletActionContext.getRequest().setAttribute("actionUrl", ServletActionContext.getRequest().getContextPath()+"/jsp/front/frontNoticeAction_list.action");
		ServletActionContext.getRequest().setAttribute("column", this.column);
		ServletActionContext.getRequest().setAttribute("columnName", this.column);
		ServletActionContext.getRequest().setAttribute("defaultColumnName", "title");
		ServletActionContext.getRequest().setAttribute("keyWord", this.keyWord);
		return "list";
	}
	//显示详细的公告信息
	public String show()throws Exception{
		//调用服务层方法
		ServletActionContext.getRequest().setAttribute("notice", this.frontNoticeService.get(this.notice.getNid()));
		return "show";
	}
}
