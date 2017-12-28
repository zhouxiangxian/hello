package cn.xiaoxian.dao;

import cn.xiaoxian.pojo.User;

public interface IUserDAO extends IDAO<String, User> {
	/**
	 * 用户登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean findLogin(User user)throws Exception;
	/**
	 * 更新用户的积分
	 * @param userid  用户id
	 * @param points  增加的分数
	 * @return   是否更新成功
	 * @throws Exception 有异常向上抛出
	 */
	public boolean updatePoints(String userid,int points)throws Exception;
	
	/**
	 * 更新用户的部分信息
	 * @param vo   要更新的用户对象
	 * @return   是否更新成功
	 * @throws Exception  有异常向上抛出
	 */
	public boolean updateInfo(User vo)throws Exception;
	
	/**
	 *修改用户密码
	 * @param vo 要修改的新密码vo对象
	 * @return   是否修改成功
	 * @throws Exception  有异常向上抛出
	 */
	public boolean updatePassword(User vo)throws Exception;

}
