package cn.xiaoxian.action.front;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.opensymphony.xwork2.ActionSupport;
import cn.xiaoxian.front.service.IFrontUserCenterService;
import cn.xiaoxian.pojo.Question;
import cn.xiaoxian.pojo.User;
import cn.xiaoxian.util.MD5Code;

@SuppressWarnings("serial")
@Repository
@Scope(value = "prototype")
public class FrontUserCenterAction extends ActionSupport {
	private IFrontUserCenterService frontUserCenterService = null;
	private File photo;
	private String oldpic;
	private String photoFileName;// 图片名称
	private String photoContentType;// 图片类型
	private String oldPassword;// 旧的密码
	private int status;// 接收问题的状态
	private String column;// 模糊查询字段
	private String keyWord;// 接收查询关键字
	private int currentPage = 1;// 接收当前页，默认为第一页
	private int lineSize = 15;// 接收每页显示数据量，默认每页显示15条
	private Question question = new Question();

	public Question getQuestion() {
		return question;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public void setOldpic(String oldpic) {
		this.oldpic = oldpic;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	@Resource(name = "frontUserCenterServiceImpl")
	public void setFrontUserCenterService(IFrontUserCenterService frontUserCenterService) {
		this.frontUserCenterService = frontUserCenterService;
	}

	public String index() throws Exception {
		// 获取用户id
		String userid = (String) ServletActionContext.getRequest().getSession().getAttribute("userid");
		// 调用服务层方法
		Map<String, Object> map = this.frontUserCenterService.getStat(userid);
		// 设置属性传递到jsp页面中
		ServletActionContext.getRequest().setAttribute("allQuestionCount", map.get("allQuestionCount"));// 提问题总数
		ServletActionContext.getRequest().setAttribute("questionCountStatus0", map.get("questionCountStatus0"));// 解决问题总数
		ServletActionContext.getRequest().setAttribute("userPoints", map.get("userPoints"));
		return "index";
	}

	public String points() throws Exception {// 获取用户积分
		// 获取用户的id
		String userid = (String) ServletActionContext.getRequest().getSession().getAttribute("userid");
		// 调用服务层方法
		// 设置属性
		ServletActionContext.getRequest().setAttribute("points", this.frontUserCenterService.getUserPoints(userid));
		return "points";
	}

	public String updatePre() throws Exception {// 用户信息更新前的处理
		// 获取用户id,找出对应用户的信息
		// 用户id从Session中找出
		String userid = (String) ServletActionContext.getRequest().getSession().getAttribute("userid");
		// 调用数据服务方法，设置request属性
		ServletActionContext.getRequest().setAttribute("user", this.frontUserCenterService.get(userid));
		return "update";
	}

	public String update() throws Exception {// 修改用户的个人信息
		// 设置用户的id,因为数据传递过来的是时候没有将userid传递过来,可以从session中取出userid
		this.user.setUserid((String) ServletActionContext.getRequest().getSession().getAttribute("userid"));
		// 调用服务层方法
		String fileName = this.photoFileName;// 用户修改前的图像
		File saveFile = null;// 图片的保存路径
		// System.out.println("类型:"+this.photoContentType);//image/jpeg
		// System.out.println("名称:"+this.photoFileName);//-6ff35f2398e2bccd.jpg
		// System.out.println("大小:"+this.photo.length());//104633
		if (this.photo.length() > 0) {
			// 有图片上传
			// 进行比较判断
			// 上传的照片和之前的照片名称一样,重新命名
			String temp[] = this.photoFileName.split("\\.");
			fileName = UUID.randomUUID() + "." + temp[temp.length - 1];
			this.user.setImage(fileName);
			saveFile = new File(ServletActionContext.getServletContext().getRealPath("/") + "userphoto" + File.separator
					+ fileName);
		} else {
			// 没有图片上传
			this.user.setImage(this.oldpic);// 设置之前的图片
		}
		// 调用服务层发方法执行更新
		if (this.frontUserCenterService.update(this.user)) {
			// 更新成功
			if (this.photo.length() > 0) {
				// 有图片的上传，将图片保存到服务器上
				InputStream input = new FileInputStream(this.photo);
				OutputStream out = new FileOutputStream(saveFile);
				int temp = 0;
				byte data[] = new byte[1024];
				while ((temp = input.read(data)) != -1) {
					out.write(data, 0, temp);
				}
				input.close();// 关闭流对象
				out.close();
			}
			ServletActionContext.getRequest().setAttribute("msg", "用户信息修改成功！");
		} else {
			// 更新失败
			ServletActionContext.getRequest().setAttribute("msg", "用户信息修改失败！");
		}
		// 设置跳转路径
		ServletActionContext.getRequest().setAttribute("path", ServletActionContext.getRequest().getContextPath()
				+ "/jsp/front/frontUserCenterAction_updatePre.action");
		return "forward";
	}

	public String updatePassword() throws Exception {// 修改用户密码
		// 加密旧的密码
		this.oldPassword = new MD5Code().getMD5ofStr(this.oldPassword);
		// 加密新的密码
		this.user.setPassword(new MD5Code().getMD5ofStr(this.user.getPassword()));
		// 用户id从session中取出
		this.user.setUserid((String) ServletActionContext.getRequest().getSession().getAttribute("userid"));
		// 调用服务层发
		if (this.frontUserCenterService.updatePassword(this.user, this.oldPassword)) {
			// 修改用户密码成功
			ServletActionContext.getRequest().setAttribute("msg", "用户密码修改成功!");
		} else {
			// 修改用户密码失败
			ServletActionContext.getRequest().setAttribute("msg", "用户密码修改失败!");
		}
		// 设置跳转路径
		ServletActionContext.getRequest().setAttribute("path",
				ServletActionContext.getRequest().getContextPath() + "/jsp/front/usercenter/user_changepassword.jsp");
		return "forward";
	}

	public String listUserQuestionStatus() throws Exception {// 根据问题的状态列出用户提出的问题
		// 用户id从session中取出
		String userid = (String) ServletActionContext.getRequest().getSession().getAttribute("userid");
		if (this.currentPage == 0) {
			this.currentPage = 1;// 默认显示为第一页
		}
		if (this.lineSize == 0) {
			this.lineSize = 15;// 默认显示15条数据
		}
		if (this.keyWord == null) {
			this.keyWord = "";// 查询全部
		}
		if (this.column == null) {
			this.column = "title";// 默认按title字段查询
		}
		// 调用服务层方法
		Map<String, Object> map = this.frontUserCenterService.listByStatus(userid, this.column, this.keyWord,
				this.currentPage, this.lineSize, this.status);
		// 设置属性，传递到jsp页面中
		ServletActionContext.getRequest().setAttribute("allQuestions", map.get("allQuestions"));// 保存所有的问题列表
		ServletActionContext.getRequest().setAttribute("currentPage", this.currentPage);// 当前页
		ServletActionContext.getRequest().setAttribute("lineSize", this.lineSize);// 每页显示的数据量
		ServletActionContext.getRequest().setAttribute("allRecorders", map.get("questionCount"));// 所有的记录数，用户分页的处理
		ServletActionContext.getRequest().setAttribute("actionUrl", ServletActionContext.getRequest().getContextPath()
				+ "/jsp/front/frontUserCenterAction_listUserQuestionStatus.action");// 表单的提交路径，让其再次跳转到此处
		ServletActionContext.getRequest().setAttribute("column", this.column);// 查询字段
		ServletActionContext.getRequest().setAttribute("columnName", this.column);
		ServletActionContext.getRequest().setAttribute("defaultColumnName", "title");// 默认查询title字段
		ServletActionContext.getRequest().setAttribute("keyWord", this.keyWord);
		ServletActionContext.getRequest().setAttribute("status", this.status);
		return "list";
	}

	public String listZeroAnswerQuestion() throws Exception {
		System.out.println("***********" + this.status + "zero answer");
		// 从session中获取用户id
		String userid = (String) ServletActionContext.getRequest().getSession().getAttribute("userid");
		if (this.currentPage == 0) {
			this.currentPage = 1;// 默认为第一页
		}
		if (this.lineSize == 0) {
			this.lineSize = 15;// 默认每页显示15条数据
		}
		if (this.keyWord == null) {
			this.keyWord = "";// 查询全部
		}
		if (this.column == null) {
			this.column = "title";// 默认查询字段为title
		}
		// 调用服务层方法处理
		Map<String, Object> map = this.frontUserCenterService.listZeroAnswer(userid, this.column, this.keyWord,
				this.currentPage, this.lineSize, 1, 0);// 零回答，肯定是没有被解决的问题，所有status=1
		// 设置request范围数据
		ServletActionContext.getRequest().setAttribute("allQuestions", map.get("allQuestions"));// 问题列表
		ServletActionContext.getRequest().setAttribute("currentPage", this.currentPage);// 当前页
		ServletActionContext.getRequest().setAttribute("lineSize", this.lineSize);// 每页显示
		ServletActionContext.getRequest().setAttribute("allRecorders", map.get("questionCount"));
		ServletActionContext.getRequest().setAttribute("actionUrl", ServletActionContext.getRequest().getContextPath()
				+ "/jsp/front/frontUserCenterAction_listZeroAnswerQuestion.action");// 表单的提交的路径
		ServletActionContext.getRequest().setAttribute("column", this.column);
		ServletActionContext.getRequest().setAttribute("columnName", this.column);
		ServletActionContext.getRequest().setAttribute("defaultColumnName", "title");
		ServletActionContext.getRequest().setAttribute("keyWord", this.keyWord);
		ServletActionContext.getRequest().setAttribute("status", this.status);// 保存传递的问题状态
		return "list";
	}

	public String deleteQuestion() throws Exception {
		// 获取用户id
		String userid = (String) ServletActionContext.getRequest().getSession().getAttribute("userid");
		// 调用服务层方法处理
		if (this.frontUserCenterService.deleteQuestion(userid, this.question.getQid())) {
			// 用户提问删除成功
			ServletActionContext.getRequest().setAttribute("msg", "用户问题删除成功!");
		} else {
			// 用户提问题删除失败
			ServletActionContext.getRequest().setAttribute("msg", "用户问题删除失败!");
		}
		// 设置跳转路径
		ServletActionContext.getRequest().setAttribute("path",
				ServletActionContext.getRequest().getContextPath() + "/jsp/front/frontUserCenterAction_index.action");
		return "forward";
	}

	public String listAcceptAnswer() throws Exception {
		// 获取userid
		String userid = (String) ServletActionContext.getRequest().getSession().getAttribute("userid");
		if (this.currentPage == 0) {
			this.currentPage = 1;// 默认为第一页
		}
		if (this.lineSize == 0) {
			this.lineSize = 15;// 默认为15页
		}
		if (this.column == null) {
			this.column = "title";// 默认按title字段查询
		}
		if (this.keyWord == null) {
			this.keyWord = "";// 查询全部
		}
		// 调用服务层方法
		Map<String, Object> map = this.frontUserCenterService.listAcceptAnswer(userid, this.column, this.keyWord,
				this.currentPage, this.lineSize);// 获取内容
		// 设置request属性
		ServletActionContext.getRequest().setAttribute("allQuestions", map.get("allQuestions"));// 问题列表
		ServletActionContext.getRequest().setAttribute("currentPage", this.currentPage);
		ServletActionContext.getRequest().setAttribute("lineSize", this.lineSize);
		ServletActionContext.getRequest().setAttribute("allRecorders", map.get("questionCount"));
		ServletActionContext.getRequest().setAttribute("actionUrl", ServletActionContext.getRequest().getContextPath()
				+ "/jsp/front/frontUserCenterAction_listAcceptAnswer.action");
		ServletActionContext.getRequest().setAttribute("column", this.column);
		ServletActionContext.getRequest().setAttribute("columnName", this.column);
		ServletActionContext.getRequest().setAttribute("defaultColumnName", "title");
		ServletActionContext.getRequest().setAttribute("keyWord", this.keyWord);
		ServletActionContext.getRequest().setAttribute("status", this.status);// 保存传递的问题状态
		return "list";
	}

	public String listUserAnswer() throws Exception {
		// 获取userid
		String userid = (String) ServletActionContext.getRequest().getSession().getAttribute("userid");
		if (this.currentPage == 0) {
			this.currentPage = 1;// 默认为第一页
		}
		if (this.lineSize == 0) {
			this.lineSize = 15;// 默认为15页
		}
		if (this.column == null) {
			this.column = "title";// 默认按title字段查询
		}
		if (this.keyWord == null) {
			this.keyWord = "";// 查询全部
		}
		// 调用服务层方法
		Map<String, Object> map = this.frontUserCenterService.listAnswer(userid, this.column, this.keyWord, this.currentPage, this.lineSize);// 获取内容
		// 设置request属性
		ServletActionContext.getRequest().setAttribute("allQuestions", map.get("allQuestions"));// 问题列表
		ServletActionContext.getRequest().setAttribute("currentPage", this.currentPage);
		ServletActionContext.getRequest().setAttribute("lineSize", this.lineSize);
		ServletActionContext.getRequest().setAttribute("allRecorders", map.get("questionCount"));
		ServletActionContext.getRequest().setAttribute("actionUrl", ServletActionContext.getRequest().getContextPath()
				+ "/jsp/front/frontUserCenterAction_listUserAnswer.action");
		ServletActionContext.getRequest().setAttribute("column", this.column);
		ServletActionContext.getRequest().setAttribute("columnName", this.column);
		ServletActionContext.getRequest().setAttribute("defaultColumnName", "title");
		ServletActionContext.getRequest().setAttribute("keyWord", this.keyWord);
		ServletActionContext.getRequest().setAttribute("status", this.status);// 保存传递的问题状态
		return "list";
	}
}
