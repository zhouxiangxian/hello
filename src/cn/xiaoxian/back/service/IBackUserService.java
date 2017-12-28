package cn.xiaoxian.back.service;

import java.util.Map;

//用户管理服务层
public interface IBackUserService {
	/**
	 * 查询用户信息
	 * 
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param currentPage
	 *            当前页
	 * @param lineSize
	 *            每页显示
	 * @return 返回Map集合，存放如下数据<br>
	 *         <li>key=allUsers,value=findAll()
	 *         <li>key=userCount,value=getAllCount()
	 * @throws Exception
	 */
	public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception;

	/**
	 * 删除一个用户的信息
	 * 
	 * @param userid  要删除的用户id
	 * @return  是否删除成功
	 * @throws Exception
	 */
	public boolean delete(String userid) throws Exception;

}
