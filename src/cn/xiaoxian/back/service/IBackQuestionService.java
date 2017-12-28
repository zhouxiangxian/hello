package cn.xiaoxian.back.service;

import java.util.Map;

import cn.xiaoxian.pojo.Question;

//后台服务层
public interface IBackQuestionService {
	/**
	 * 列出全部的问题
	 * @param column  查询关键字段
	 * @param keyWord   查询关键字
	 * @param currentPage  当前页
	 * @param lineSize   每页显示
	 * @return    以map集合返回，map集合中存放allQuestions,questionCount<br>
	 * <li>key=allQuestions,value=findAll();
	 * <li>key=questionCount,value=getAllCount();
	 * @throws Exception  异常向上抛出
	 */
	public Map<String,Object> listAll(String column,String keyWord,int currentPage,int lineSize)throws Exception;
    
	/**
	 * 列出所有未解决的问题
	 * @param column  查询关键字段
	 * @param keyWord  查询关键字
	 * @param currentPage  当前页
	 * @param lineSize  每页显示
	 * @param status   问题的状态，status=0表示问题已经解决，status=1表示问题未解决
	 * @return   返回map集合，存放以下两种数据<br>
	 * <li>key=allQuestions,value=findAllByStatus();
	 * <li>key=questionCount,value=getAllCountByStatus();
	 * @throws Exception
	 */
	public Map<String,Object> listAllByStatus(String column,String keyWord,int currentPage,int lineSize,int status)throws Exception;
	/**
	 * 查询问题
	 * @param qid  问题的编号
	 * @return    返回问题对象，如果不存在则返回null
	 * @throws Exception  异常向上抛出
	 */
	public Question show(int qid)throws Exception;
	/**
	 * 删除问题
	 * @param qid  问题的编号
	 * @return   删除成功则返回true，否则返回false
	 * @throws Exception  异常向上抛出
	 */
	public boolean delete(int qid)throws Exception;
	
	/**
	 *  查询一个用户的全部提问
	 * @param userid   用户id
	 * @param column   查询关键字段
	 * @param keyWord  查询关键字
	 * @param currentPage   当前页
	 * @param lineSize   每页显示
	 * @return    一个用户的全部提问<br>
	 * <li>key=allQuestions,value=findAllByUser();
	 * <li>key=questionCount,value=getAllCountByUser();
	 * @throws Exception
	 */
	public Map<String,Object> listAllByUser(String userid,String column,String keyWord,int currentPage,int lineSize)throws Exception;
	
}
