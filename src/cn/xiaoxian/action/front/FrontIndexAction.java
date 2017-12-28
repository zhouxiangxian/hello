package cn.xiaoxian.action.front;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoxian.front.service.IFrontIndexService;

@SuppressWarnings("serial")
@Scope(value="prototype")
@Repository
public class FrontIndexAction extends ActionSupport {
	private IFrontIndexService frontIndexService =null;
	@Resource(name="frontIndexServiceImpl")//注入对象
	public void setFrontIndexService(IFrontIndexService frontIndexService) {
		this.frontIndexService = frontIndexService;
	}
	public String index()throws Exception{
		//调用服务层发方法
		Map<String,Object> map=this.frontIndexService.index();//获取传入到jsp页面中信息
		ServletActionContext.getServletContext().setAttribute("questionCountStatus0",map.get("questionCountStatus0"));//已解决问题的数量
		ServletActionContext.getServletContext().setAttribute("questionCountStatus1", map.get("questionCountStatus1"));//未解决问题的数量
		ServletActionContext.getRequest().setAttribute("allTypes", map.get("allTypes"));//所有的问题分类
		ServletActionContext.getRequest().setAttribute("questionsStatus1", map.get("questionsStatus1"));//待解决问题
		ServletActionContext.getRequest().setAttribute("questionsStatus0", map.get("questionsStatus0"));//已解决问题
		ServletActionContext.getRequest().setAttribute("allNotices", map.get("allNotices"));//所有的公告西信息
		ServletActionContext.getServletContext().setAttribute("allUsers",map.get("allUsers"));//所有的用户信息
		return "index";
	}

}
