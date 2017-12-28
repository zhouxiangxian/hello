package cn.xiaoxian.front.service.impl;
//前台用户服务层
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoxian.dao.IUserDAO;
import cn.xiaoxian.front.service.IFrontUserService;
import cn.xiaoxian.pojo.User;
@Service
public class FrontUserServiceImpl implements IFrontUserService {
    private IUserDAO userDAO=null;//声明接口对象
    @Resource(name="userDAOImpl")//依赖注入
    public void setUserDAO(IUserDAO userDAO){
    	this.userDAO=userDAO;
    }
	@Override
	public boolean login(User user) throws Exception {//用户登录
		return this.userDAO.findLogin(user);
	}
	@Override
	public boolean checkUserid(String userid) throws Exception {//检查用户id的合法性
		//调用数据层方法
		return this.userDAO.findById(userid)==null;
	}
	@Override
	public boolean register(User user) throws Exception {//用户注册
		return this.userDAO.doCreate(user);
	}
	@Override
	public int getUserPoints(String userid) throws Exception {//获取用户的积分数
		//调用数据层方法
		User user=this.userDAO.findById(userid);//根据用户id得到用户的信息
		return user.getPoints();//返回用户的积分数
	}

}
