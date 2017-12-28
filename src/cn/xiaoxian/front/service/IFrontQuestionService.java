package cn.xiaoxian.front.service;

import java.util.List;
import java.util.Map;

import cn.xiaoxian.pojo.Question;

//服务层操作标准
public interface IFrontQuestionService {
	/**
	 * 问题增加前的准备操作
	 * @return
	 * @throws Exception
	 */
	public  Map<String,Object> insertPre()throws Exception;
	/**
	 * 问题的增加
	 * @return
	 * @throws Exception
	 */
	public  boolean insert(Question vo)throws Exception;
	/**
	 * 问题的状态列表
	 * @param tid 问题所属的类型
	 * @param currentPage  当前页
	 * @param lineSize  每页显示
	 * @return   所有要显示的数据保存在Map集合之中，一下给出标记如下:
	 * 1:全部的问题分类:使用Action传递到jsp中的属性:allType(查询TypeDAO)
	 * 2:已解决问题:allQuestionStatus0、allQuestionCountStatus0
	 * 3:未解决问题:allQuestionStatus1、allQuestionCountStatus1
	 * 4:零回答问题:allQuestionCountZero、allQuestionCountCountZero
	 * 5:高悬赏问题:allQuestionPoints、allQuestionCountPoints
	 * @throws Exception  有异常向上抛出
	 */
	public Map<String,Object> listAll(int tid,int currentPage,int lineSize)throws Exception;
	/**
	 * 根据问题的状态查询问题列表
	 * @param tid 问题所在的分类
	 * @param currentPage   当前页
	 * @param lineSize  每页显示
	 * @param status   问题的状态
	 * @return   问题列表
	 * @throws Exception 有异常向上抛出
	 */
	public List<Question> findAllByStatus(int tid,int currentPage,int lineSize,int status)throws Exception;
    /**
     * 根据问题的回答量查询问题列表
     * @param tid   问题所在的分类
     * @param currentPage   当前页
     * @param lineSize   每页显示
     * @param count   问题的回答量
     * @return    问题列表
     * @throws Exception 有异常向上抛出
     */
	public List<Question> findAllByCount(int tid,int currentPage,int lineSize,int count)throws Exception;
	/**
	 * 根据问题的悬赏分数查询问题列表
	 * @param tid 问题所在的分类
	 * @param currentPage  当前页
	 * @param lineSize   每页显示
	 * @return   问题列表
	 * @throws Exception  有异常向上抛出
	 */
	public List<Question> findAllByPoint(int tid,int currentPage,int lineSize)throws Exception;
	
	/**
	 * 根据问题的编号获取问题的信息
	 * @param qid  问题编号
	 * @return  如果存在则返回问题信息否则返回null
	 * @throws Exception   有异常向上抛出
	 */
	public Question get(Integer qid)throws Exception;
	/**
	 * 设置最佳回答
	 * 
	 * @param vo  问题对象
	 * @return  
	 * @throws Exception
	 */
	public boolean setNice(Question vo) throws Exception;
	/**
	 * 搜索问题
	 * @param column   查询关键字段
	 * @param keyWord   查询关键字
	 * @param currentPage   当前页
	 * @param lineSize   每页显示长度
	 * @return    搜索到的问题和问题数量<br>
	 * <li>key=allQuestions,value=findAll()
	 * <li>key=questionCount,value=getAllCount();
	 * @throws Exception
	 */
	public Map<String,Object> findAll(String column,String keyWord,int currentPage,int lineSize)throws Exception;
}
