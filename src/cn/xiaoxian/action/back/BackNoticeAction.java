package cn.xiaoxian.action.back;

import java.sql.Timestamp;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoxian.back.service.IBackNoticeService;
import cn.xiaoxian.pojo.Notice;

@SuppressWarnings("serial")
@Repository
@Scope(value="prototype")
public class BackNoticeAction extends ActionSupport {
	private IBackNoticeService backNoticeService=null;
	private Notice notice=new Notice();
	private int currentPage=1;
	private int lineSize=15;
	private String keyWord;
	private String column;
	
	
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

	public Notice getNotice() {
		return notice;
	}

	@Resource(name="backNoticeServiceImpl")
	public void setBackNoticeService(IBackNoticeService backNoticeService) {
		this.backNoticeService = backNoticeService;
	}
	//增加操作
	public String insert()throws Exception{
		//设置公告的发布日期
		this.notice.setPubtime(new Timestamp(System.currentTimeMillis()));
		//调用服务层方法
		if(this.backNoticeService.insert(this.notice)){
			//增加成功
			ServletActionContext.getRequest().setAttribute("msg", "公告增加成功!");
		}else{
			//增加失败
			ServletActionContext.getRequest().setAttribute("msg", "公告增加失败!");
		}
		//设置跳转路径
		ServletActionContext.getRequest().setAttribute("path", ServletActionContext.getRequest().getContextPath()+"/jsp/back/notice/notice_insert.jsp");
		return "forward";
	}
	//删除操作
	public String delete()throws Exception{
		//调用服务层方法
		if(this.backNoticeService.delete(this.notice.getNid())){//删除成功
			ServletActionContext.getRequest().setAttribute("msg", "该公告删除成功!");
		}else{
			//删除失败
			ServletActionContext.getRequest().setAttribute("msg", "该公告删除失败!");
		}
		//设置跳转路径
		ServletActionContext.getRequest().setAttribute("path", ServletActionContext.getRequest().getContextPath()+"/jsp/back/backNoticeAction_list.action");
		return "forward";
	}
	//修该前的准备操作
	public String updatePre()throws Exception{
		//调用服务层方法
		ServletActionContext.getRequest().setAttribute("notice",this.backNoticeService.get(this.notice.getNid()));//将要修改的公告信息传递到jsp页面
		return "update";
	}
	//修改操作
	public String update()throws Exception{
		//调用服务层方法
		if(this.backNoticeService.update(this.notice)){
			//修改公告信息成功
			ServletActionContext.getRequest().setAttribute("msg", "公告信息修改成功!");
		}else{
			//修改公共信息失败
			ServletActionContext.getRequest().setAttribute("msg", "公告信息修改失败!");
		}
		//设置跳转路径
		ServletActionContext.getRequest().setAttribute("path", ServletActionContext.getRequest().getContextPath()+"/jsp/back/backNoticeAction_list.action");
		return "forward";
	}
	//查询全部操作
	public String list()throws Exception{
		if(this.column==null){
			this.column="title";//默认按title字段查询
		}
		if(this.keyWord==null){
			this.keyWord="";//查询全部
		}
		if(this.currentPage==0){
			this.currentPage=1;//默认为第一页
		}
		if(this.lineSize==0){
			this.lineSize=15;
		}
		//调用服务层方法
		Map<String,Object> map=this.backNoticeService.list(this.column, this.keyWord, this.currentPage, this.lineSize);
		//设置属性
		ServletActionContext.getRequest().setAttribute("allNotices", map.get("allNotices"));//公告信息
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
}
