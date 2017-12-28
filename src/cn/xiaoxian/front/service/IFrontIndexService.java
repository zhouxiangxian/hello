package cn.xiaoxian.front.service;

import java.util.Map;

public interface IFrontIndexService {
	/**
	 * 列出首页的信息
	 * @return   以map集合保存首页的信息<br>
	 * <li>已解决问题的统计量,key=questionCountStatus0,value=getAllCountByStatus()
	 * <li>未解决问题的统计量,key=questionCountStatus1,value=getAllCountByStatus()
	 * <li>问题的分类信息,key=allTypes,value=findAll();
	 * <li>待解决问题,key=questionsStatus1,value=findAllByStatus();
	 * <li>已解决问题,key=questionsStatus0,value=findAllByStatus();
	 * <li>公告信息,key=allNotices,value=findAll();
	 * <li>用户信息,key=allUsers,value=findAll();
	 * @throws Exception
	 */
	public Map<String,Object> index()throws Exception;
}
