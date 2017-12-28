package cn.xiaoxian.front.service;

import java.util.Map;

import cn.xiaoxian.pojo.Notice;

public interface IFrontNoticeService {
	/**
	 * 列出所有的公告信息，分页显示
	 * 
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param currentPage
	 *            当前页
	 * @param lineSize
	 *            每页显示
	 * @return 返回Map<br>
	 *         <li>key=allNotices,value=findAll();
	 *         <li>key=noticeCount,value=getAllCount();
	 * @throws Exception
	 */
	public Map<String, Object> list(String column, String keyWord, int currentPage, int lineSize) throws Exception;

	/**
	 * 查看指定的公告信息
	 * @param nid   指定的公告id
	 * @return    公告信息
	 * @throws Exception
	 */
	public Notice get(int nid) throws Exception;
}
