package cn.xiaoxian.dao;

import cn.xiaoxian.pojo.Admin;

public interface IAdminDAO extends IDAO<String, Admin> {
	/**
	 * 管理员的登录操作
	 * @param vo    管理员对象
	 * @return   是否登录成功
	 * @throws Exception 异常向上抛出
	 */
	public boolean findLogin(Admin vo)throws Exception;

}
