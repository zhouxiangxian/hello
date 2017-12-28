package cn.xiaoxian.action.back;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoxian.back.service.IBackUserService;
import cn.xiaoxian.pojo.User;

@SuppressWarnings("serial")
@Scope(value="prototype")
@Repository
public class BackUserAction extends ActionSupport {
	private IBackUserService backUserService=null;
	private String column;//查询关键字段
	private String keyWord;//查询关键字
	private int currentPage=1;//当前页
	private int lineSize;//每页显示
	private  User user=new User();//实例化对象
	public void setUser(User user) {
		this.user = user;
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
	@Resource(name="backUserServiceImpl")
	public void setBackUserService(IBackUserService backUserService) {
		this.backUserService = backUserService;
	}
	public String list()throws Exception{
		if(this.column==null){
			this.column="userid";//默认按userid字段查询
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
		Map<String,Object> map=this.backUserService.list(this.column, this.keyWord, this.currentPage, this.lineSize);//获取用户的信息
		//设置属性
		ServletActionContext.getRequest().setAttribute("allUsers", map.get("allUsers"));//公告信息
		ServletActionContext.getRequest().setAttribute("currentPage", this.currentPage);
		ServletActionContext.getRequest().setAttribute("lineSize", this.lineSize);
		ServletActionContext.getRequest().setAttribute("allRecorders", map.get("userCount"));
		ServletActionContext.getRequest().setAttribute("actionUrl", ServletActionContext.getRequest().getContextPath()+"/jsp/back/backUserAction_list.action");
		ServletActionContext.getRequest().setAttribute("column", this.column);
		ServletActionContext.getRequest().setAttribute("columnName", this.column);
		ServletActionContext.getRequest().setAttribute("defaultColumnName", "content");//默认按content字段查询
		ServletActionContext.getRequest().setAttribute("keyWord", this.keyWord);
		return "list";
	}
	//删除用户操作
	public String delete()throws Exception{
		//调用数据层方法
		if(this.backUserService.delete(this.user.getUserid())){
			//用户删除成功
			ServletActionContext.getRequest().setAttribute("msg","用户信息删除成功!");
		}else{
			//用户删除失败
			ServletActionContext.getRequest().setAttribute("msg","用户信息删除失败!");
		}
		ServletActionContext.getRequest().setAttribute("path",ServletActionContext.getRequest().getContextPath()+"/jsp/back/backUserAction_list.action");
		return "forward";
	}
}
