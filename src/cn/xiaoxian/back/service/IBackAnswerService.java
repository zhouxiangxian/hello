package cn.xiaoxian.back.service;

import java.util.Map;

public interface IBackAnswerService {
	/**
	 *列出所有的回答
	 * @param column   查询关键字段
	 * @param keyWord   查询关键字
	 * @param currentPage   当前页
	 * @param lineSize   每页显示
	 * @return    以map集合返回所有会的信息，其中map集合中存放一下两种数据<br>
	 * <li>key=allAnswers,value=findAll();
	 * <li>key=answerCount,value=findAllCount();
	 * @throws Exception
	 */
	public Map<String,Object> list(String column,String keyWord,int currentPage,int lineSize)throws Exception;
	/**
	 * 删除回答
	 * @param id  回答id
	 * @return  是否删除成功，删除成功返回true,否则返回false
	 * @throws Exception  异常向上抛出
	 */
    public boolean delete(int id)throws Exception;
}
