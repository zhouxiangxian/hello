package cn.xiaoxian.action.back;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;

import cn.xiaoxian.back.service.IBackTypeService;
import cn.xiaoxian.pojo.Type;
//action层
@Repository//声明组件
@SuppressWarnings("serial")
public class BackTypeAction extends ActionSupport {
	private IBackTypeService backTypeService =null;
	private Type type=new Type();
    @Resource(name="backTypeServiceImpl")
	public void setBackTypeService(IBackTypeService backTypeService) {
		this.backTypeService = backTypeService;
	}
	public Type getType() {
		return type;
	}
	public String insert()throws Exception{//类型增加操作
		if(this.backTypeService.insert(this.type)){
			//增加成功
			ServletActionContext.getRequest().setAttribute("msg", "新的问题类型增加成功!");
		}else{
			ServletActionContext.getRequest().setAttribute("msg","新的问题类型增加失败!");
		}
		ServletActionContext.getRequest().setAttribute("path",ServletActionContext.getRequest().getContextPath()+"/jsp/back/type/type_insert.jsp");
		return "forward";
	}
	public String delete()throws Exception{//类型删除操作
		//调用服务层方法
		if(this.backTypeService.remove(this.type.getTid())){
			//类型删除成功
			ServletActionContext.getRequest().setAttribute("msg", "问题类型删除成功!");
		}else{
			//类型删除失败
			ServletActionContext.getRequest().setAttribute("msg", "问题类型删除失败!");
		}
		ServletActionContext.getRequest().setAttribute("path",ServletActionContext.getRequest().getContextPath()+"/jsp/back/backTypeAction_list.action");
		return "forward";//跳转
	}
	public String update()throws Exception{//类型更新
		System.out.println("update"+this.type.getTid()+","+this.type.getTitle()+","+this.type.getDescription());
		//调用服务层发方法
		if(this.backTypeService.update(this.type)){
			//修改成功
			ServletActionContext.getRequest().setAttribute("msg","问题类型修改成功!");
		}else{
			//修改失败
			ServletActionContext.getRequest().setAttribute("msg","问题类型修改失败!");
		}
		//设置跳转路径
		ServletActionContext.getRequest().setAttribute("path", ServletActionContext.getRequest().getContextPath()+"/jsp/back/backTypeAction_list.action");
		return "forward";
	}
	public String updatePre()throws Exception{//类型更新前的准备操作
		//调用服务层方法
	    //设置request属性
		ServletActionContext.getRequest().setAttribute("type", this.backTypeService.findById(this.type.getTid()));
		return "update";
	}
	public String list()throws Exception{//类型列表
		//调用服务层方法
		ServletActionContext.getRequest().setAttribute("all", this.backTypeService.list());
		return "list";
	}

}
