package cn.xiaoxian.action.front;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoxian.front.service.IFrontUserService;
import cn.xiaoxian.pojo.User;
import cn.xiaoxian.util.MD5Code;

@Repository
@SuppressWarnings("serial")
public class FrontUserAction extends ActionSupport {
	private IFrontUserService frontUserService = null;
	private User user = new User();// 接收传来的参数
	private String code;

	public void setCode(String code) {
		this.code = code;
	}

	public User getUser() {
		return user;
	}

	@Resource(name = "frontUserServiceImpl")
	public void setFrontUserService(IFrontUserService frontUserService) {
		this.frontUserService = frontUserService;
	}

	public String login() throws Exception {
		// 对密码进行加密处理
		this.user.setPassword(new MD5Code().getMD5ofStr(this.user.getPassword()));
		if (this.frontUserService.login(this.user)) {
			// 登录成功
			// 设置一个session
			ServletActionContext.getRequest().getSession().setAttribute("userid", this.user.getUserid());
			// 设置提示信息和跳转路劲
			ServletActionContext.getRequest().setAttribute("msg", "登录成功，欢迎" + this.user.getUserid() + "回来！！");
			ServletActionContext.getRequest().setAttribute("path",
					ServletActionContext.getRequest().getContextPath() + "/frontIndexAction_index.action");
		} else {
			// 登录失败
			ServletActionContext.getRequest().setAttribute("msg", "登陆失败,请确认用户名或密码");
			ServletActionContext.getRequest().setAttribute("path",
					ServletActionContext.getRequest().getContextPath() + "/user_login.jsp");
		}
		return "forward";
	}

	public String validateCode() throws Exception {// 验证验证码的正确性，使用ajax完成
		// 系统生成的验证码
		String rand = (String) ServletActionContext.getRequest().getSession().getAttribute("rand");
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		if (rand.equalsIgnoreCase(this.code)) {
			// 验证码输入正确
			writer.print("true");
		} else {
			// 验证输入错误
			writer.print("false");
		}
		writer.close();
		return null;
	}

	public String checkuserid() throws Exception {// 检查用户id的正确性，使用ajax完成
		PrintWriter writer = ServletActionContext.getResponse().getWriter();// 获取的打印流对象
		if (this.frontUserService.checkUserid(this.user.getUserid())) {
			// 用户id有效
			writer.print("true");
		} else {
			// 用户id无效
			writer.print("false");
		}
		return null;
	}

	public String register() throws Exception {// 用户注册
		//设置注册时间
		this.user.setRegisteredtime(new Timestamp(System.currentTimeMillis()));
		//设置照片
		this.user.setImage("nophoto.jpg");
		//设置出事积分
		this.user.setPoints(100);
		this.user.setPassword(new MD5Code().getMD5ofStr(this.user.getPassword()));// 密码加密处理
		try {
			if (this.frontUserService.register(this.user)) {
				// 用户注册成功
				ServletActionContext.getRequest().getSession().setAttribute("userid", this.user.getUserid());// 给该用户设置一个session属性，让其注册成功就处于登录成功状态
				// 设置提示信息和跳转路径
				ServletActionContext.getRequest().setAttribute("msg", "用户注册成功");
				ServletActionContext.getRequest().setAttribute("path",
						ServletActionContext.getRequest().getContextPath() + "/index.jsp");
				return "forward";
			} else {
				// 用户注册失败
				super.addFieldError("registererror", "用户注册失败，请检查注册信息的完整性！");
				return "register";
			}
		} catch (Exception e) {
			super.addFieldError("registererror", "用户注册失败，请检查注册信息的完整性！！");
		}
		return "register";
	}
	public String checkPoints()throws Exception{//使用ajax返回用户的积分数
		PrintWriter writer=ServletActionContext.getResponse().getWriter();//获取输出流对象
		writer.print(this.frontUserService.getUserPoints(this.user.getUserid()));//调用服务层方法
		writer.close();//关闭流对象
		return null;
	}
    public String logout()throws Exception{//用户注销
    	ServletActionContext.getRequest().getSession().invalidate();
    	ServletActionContext.getRequest().setAttribute("msg","用户注销成功!");
    	ServletActionContext.getRequest().setAttribute("path",ServletActionContext.getRequest().getContextPath()+"/user_login.jsp");//设置跳转路径
    	return "forward";
    }
}
