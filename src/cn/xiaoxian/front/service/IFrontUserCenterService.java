package cn.xiaoxian.front.service;

import java.util.Map;

import cn.xiaoxian.pojo.User;
//服务层
public interface IFrontUserCenterService {
	/**
	 * 得到用户的基本信息
	 * @param userid  用户Id
	 * @return   以map集合存放用户的基本信息
	 * 1：用户提出的问题总数:key=allQuestionCount,value=questionDAO.getAllCountByUser()
	 * 2：用户问题得到解决的个数:key=questionCountStatus0,value=questionDAO.getAllCountByUser()
	 * 3：用户的积分数:key=userPoints,value=userDAO.findById().getPoints()
	 * @throws Exception
	 */
	public Map<String,Object> getStat(String userid)throws Exception;
	
	/**
	 * 获取用户的积分
	 * @param userid  用户id 
	 * @return    用户的积分
	 * @throws Exception 有异常向上抛出
	 */
	public int getUserPoints(String userid)throws Exception;
	
	/**
	 * 根据用户id获取用户信息
	 * @param userid    用户id
	 * @return   用户信息对象
	 * @throws Exception  异常向上抛出
	 */
	public User get(String userid)throws Exception;
	/**
	 * 修改用户个人资料
	 * @param vo  要修改的用户对象
	 * @return  是否修改成功
	 * @throws Exception  异常向上抛出
	 */
	public boolean update(User vo)throws Exception;
	/**
	 * 修改用户的密码
	 * @param vo 新密码的vo对象
	 * @param oldPassword   用户就的密码
	 * @return  是否修改成功
	 * @throws Exception   有异常向上抛出
	 */
	public boolean updatePassword(User vo ,String oldPassword)throws Exception;
	
	/**
	 * 根据问题的状态查询出用户提出的所有问题
	 * @param userid  用户id
	 * @param column  查询关键字段
	 * @param keyWord   差选关键字
	 * @param currentPage  当前页
	 * @param lineSize   每页显示
	 * @param status   问题的状态  status=0表示问题已解决，status=1表示问题未解决
	 * @return   返回map集合,map集合保存一下两种数据<br>
	 * <li>key=allQuestions,value=findByUser();问题列表
	 * <li>key=questionCount,value=getAllCountByUser();问题个数
	 * @throws Exception
	 */
	public Map<String,Object> listByStatus(String userid,String column,String keyWord,int currentPage,int lineSize ,int status)throws Exception;
	/**
	 * 查询用户提问中问题回答为0的问题
	 * @param userid  用户id
	 * @param column  查询关键字段
	 * @param keyWord   查询关键字
	 * @param currentPage  当前页
	 * @param lineSize  每页显示
	 * @param status  问题的状态
	 * @param count   问题的回答量
	 * @return   返回map集合，map中主要保存一下的数据<br>
	 * <li>key=allQuestions,value=findByUser();问题列表
	 * <li>key=questionCount,value=getAllCountByUser();问题个数
	 * @throws Exception
	 */
	public Map<String,Object> listZeroAnswer(String userid,String column,String keyWord,int currentPage ,int lineSize,int status,int count)throws Exception;
    
	/**
	 * 删除一个用户提出问题
	 * @param userid  用户id
	 * @param qid  问题id
	 * @return  删除成功返回true,否则返回false
	 * @throws Exception 异常向上抛出
	 */
	public boolean deleteQuestion(String userid,int qid)throws Exception;
	
	/**
	 * 列出未被采纳的问题
	 * @param userid   用户id
	 * @param column   查询关键字段
	 * @param keyWord   查询关键字
	 * @param currentPage   当前页
	 * @param lineSize   每页显示
	 * @return    未被采纳问题，以Map集合的返回，存有一下两种数据<br>
	 * <li> key=allQuestions,value=findAllByAnswer()
	 * <li> key=questionCount,value=getAllCountByAnswer()
	 * @throws Exception  异常向上抛出
	 */
	public Map<String,Object> listAnswer(String userid,String column,String keyWord,int currentPage,int lineSize)throws Exception;
	/**
	 * 列出所有被采纳的问题列表
	 * @param userid  用户id
	 * @param column  查询关键字段
	 * @param keyWord   查询关键字
	 * @param currentPage  当前页
	 * @param lineSize 每页显示
	 * @return    被采纳的问题列表,以Map集合返回，主要存有以下两种数据<br>
	 * <li>key=allQuestions,value=findAllAcceptAnswer()
	 * <li>key=questionCount,value=getAllCountAcceptAnswer();
	 * @throws Exception  异常向上抛出
	 */
	public Map<String,Object> listAcceptAnswer(String userid,String column,String keyWord,int currentPage,int lineSize)throws Exception;
}
