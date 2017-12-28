package cn.xiaoxian.action.back;

import java.io.PrintWriter;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoxian.back.service.IBackAdminService;
import cn.xiaoxian.pojo.Admin;
import cn.xiaoxian.util.MD5Code;

@SuppressWarnings("serial")
@Scope(value="prototype")
@Repository
public class BackAdminAction extends ActionSupport {
	private IBackAdminService backAdminService=null;
	private Admin admin=new Admin();//实例化Admin对象，接收数据
	private String code=null;//接收验证码
	public void setCode(String code) {
		this.code = code;
	}
	public Admin getAdmin() {
		return admin;
	}
	@Resource(name="backAdminServiceImpl")//注入对象
	public void setBackAdminService(IBackAdminService backAdminService) {
		this.backAdminService = backAdminService;
	}
	//登录操作
	public String login()throws Exception{
		//对密码进行加密处理
		this.admin.setPassword(new MD5Code().getMD5ofStr(this.admin.getPassword()));
		//调用服务层方法
		if(this.backAdminService.login(this.admin)){
			//登录成功
			//设置提示信息
			ServletActionContext.getRequest().setAttribute("msg","欢迎"+this.admin.getAdminid()+"回来!");
			//设置session
			ServletActionContext.getRequest().getSession().setAttribute("adminid", this.admin.getAdminid());
			ServletActionContext.getRequest().setAttribute("path", ServletActionContext.getRequest().getContextPath()+"/jsp/back/index.jsp");//跳转到首页	
		}else{
			//登录失败
			ServletActionContext.getRequest().setAttribute("msg", "错误的用户名或密码!");
			//设置跳转路径
			ServletActionContext.getRequest().setAttribute("path", ServletActionContext.getRequest().getContextPath()+"/login.jsp");//重新登录
		}
		return "forward";
	}
	//验证验证码
	public String validateCode()throws Exception{
		//从session中取出验证码
		String rand=(String)ServletActionContext.getRequest().getSession().getAttribute("rand");
		PrintWriter writer=ServletActionContext.getResponse().getWriter();//获取打印流对象
		if(rand.equalsIgnoreCase(this.code)){
			writer.print("true");//验证码输入正确
		}else{
			writer.print("false");//验证码输入错误
		}
		return null;
	}
	//注销操作
	public String logout()throws Exception{
		//注销session
		ServletActionContext.getRequest().getSession().invalidate();//这样处理会不会把所有的已经设置的session都失效？？？？？？
		ServletActionContext.getRequest().setAttribute("msg", "管理员注销成功!");
		ServletActionContext.getRequest().setAttribute("path",ServletActionContext.getRequest().getContextPath()+ "/jsp/back/login.jsp");
		return "forward";
	}

}
