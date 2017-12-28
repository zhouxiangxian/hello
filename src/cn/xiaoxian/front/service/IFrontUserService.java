package cn.xiaoxian.front.service;

import cn.xiaoxian.pojo.User;

//服务层
public interface IFrontUserService {
	public boolean login(User user) throws Exception;// 用户的登录

	/**
	 * 检查用户id的合法性
	 * 
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public boolean checkUserid(String userid) throws Exception;

	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean register(User user) throws Exception;
	/**
	 * 获取用户的积分数
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public int getUserPoints(String userid)throws Exception;

}
