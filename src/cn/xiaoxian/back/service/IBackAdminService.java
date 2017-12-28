package cn.xiaoxian.back.service;

import cn.xiaoxian.pojo.Admin;

public interface IBackAdminService {
	/**
	 * 管理员登录验证
	 * @param vo   管理员对象
	 * @return   是否登录成功
	 * @throws Exception
	 */
	public boolean login(Admin vo)throws Exception;
}
