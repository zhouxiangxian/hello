package cn.xiaoxian.back.service;

import java.util.Map;

import cn.xiaoxian.pojo.Notice;

//定义服务层接口
public interface IBackNoticeService {
	/**
	 * 添加公告
	 * @param vo  要添加的公告对象
	 * @return 是否删除成功
	 * @throws Exception 异常向上抛出
	 */
	public boolean insert(Notice vo)throws Exception;
	/**
	 * 删除公告
	 * @param nid 要删除的公告id
	 * @return   是否删除成功
	 * @throws Exception  异常向上抛出
	 */
	public boolean delete(Integer nid)throws Exception; 
	/**
	 * 更新公告信息
	 * @param vo 要更新的公告对象
	 * @return  是否更新成功
	 * @throws Exception 异常向上抛出
	 */
	public boolean update(Notice vo)throws Exception;
	/**
	 * 查询指定的公告信息
	 * @param nid  要查询的公告id
	 * @return   如果有指定的公告信息就返回notice对象，否则返回null
	 * @throws Exception
	 */
	public Notice get(Integer nid)throws Exception;
	/**
	 * 查询公告的信息
	 * @param column   查询关键字段
	 * @param keyWord  查询关键字
	 * @param currentPage  当前页
	 * @param lineSize  每页显示
	 * @return   返回map集合，map集合中存放以下两种数据<br>
	 * <li>key=allNotices,value=findAll()：即所有的公告列表
	 * <li>key=noticeCount,value=getAllCount()：满足条件的公告统计数量
	 * @throws Exception
	 */
	public Map<String ,Object> list(String column,String keyWord,int currentPage,int lineSize)throws Exception;

}
