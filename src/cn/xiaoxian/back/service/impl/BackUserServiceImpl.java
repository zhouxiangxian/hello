package cn.xiaoxian.back.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoxian.back.service.IBackUserService;
import cn.xiaoxian.dao.IUserDAO;
@Service
public class BackUserServiceImpl implements IBackUserService {
	private IUserDAO userDAO=null;
	//注入对象
	@Resource(name="userDAOImpl")
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	//查询用户的信息
	public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();//实例化对象
		//调用数据层方法
		map.put("allUsers",this.userDAO.findAll(column, keyWord, currentPage, lineSize));//所有的用户信息
		map.put("userCount", this.userDAO.getAllCount(column, keyWord));//用户数量
		return map;
	}

	@Override
	//删除用户信息
	public boolean delete(String userid) throws Exception {
		//掉用户数据层方法
		return this.userDAO.doRemove(userid);
	}

}
