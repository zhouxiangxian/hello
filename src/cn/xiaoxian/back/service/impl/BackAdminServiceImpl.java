package cn.xiaoxian.back.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xiaoxian.back.service.IBackAdminService;
import cn.xiaoxian.dao.IAdminDAO;
import cn.xiaoxian.pojo.Admin;
@Service
public class BackAdminServiceImpl implements IBackAdminService {
    private IAdminDAO adminDAO=null;
    @Resource(name="adminDAOImpl")//注入对象
    public void setAdminDAO(IAdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}
	@Override
	//登录验证
	public boolean login(Admin vo) throws Exception {
		//调用数据层方法
		return this.adminDAO.findLogin(vo);
	}

}
