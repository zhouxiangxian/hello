package cn.xiaoxian.dao;

import java.util.List;

import cn.xiaoxian.pojo.Question;

public interface IQuestionDAO extends IDAO<Integer, Question> {
	/**
	 * 根据问题的状态查询所有的问题
	 * 
	 * @param tid
	 *            问题所在的类型
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param currentPage
	 *            当前页
	 * @param lineSize
	 *            每页显示
	 * @param status
	 *            问题的状态
	 * @return
	 * @throws Exception
	 *             有异常向上抛出
	 */
	public List<Question> findAllByStatus(int tid, String column, String keyWord, int currentPage, int lineSize,
			int status) throws Exception;

	/**
	 * 根据问题的状态查询所有的问题
	 * 
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param currentPage
	 *            每页显示
	 * @param lineSize
	 *            每页显示
	 * @param status
	 *            问题的状态
	 * @return 问题列表
	 * @throws Exception
	 *             异常向上抛出
	 */
	public List<Question> findAllByStatus(String column, String keyWord, int currentPage, int lineSize, int status)
			throws Exception;

	/**
	 * 根据回答问题的个数查询问题
	 * 
	 * @param tid
	 *            问题所在的分类
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param currentPage
	 *            当前页
	 * @param lineSize
	 *            每页显示
	 * @param count
	 *            问题的回答量
	 * @return 所有问题的列表
	 * @throws Exception
	 *             有异常向上抛出
	 */
	public List<Question> findAllByCount(int tid, String column, String keyWord, int currentPage, int lineSize,
			int count) throws Exception;

	/**
	 * 根据悬赏的最高分进行问题列表的显示
	 * 
	 * @param tid
	 *            问题所在的分类
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param currentPage
	 *            当前页
	 * @param lineSize
	 *            每页显示
	 * @param status
	 *            问题的状态
	 * @return 问题列表
	 * @throws Exception
	 *             有异常向上抛出
	 */
	public List<Question> findAllByPoints(int tid, String column, String keyWord, int currentPage, int lineSize,
			int status) throws Exception;

	/**
	 * 根据问题的状态查询数据量
	 * 
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param status
	 *            问题的状态
	 * @return 满足条件的数据量
	 * @throws Exception
	 */
	public int getAllCountByStatus(String column, String keyWord, int status) throws Exception;
	/**
	 * 根据问题的状态查询数据量
	 * 
	 * @param tid
	 *            问题所在的分类
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param status
	 *            问题的状态
	 * @return 满足条件的数据量
	 * @throws Exception
	 *             有异常向上抛出
	 */
	public int getAllCountByStatus(int tid, String column, String keyWord, int status) throws Exception;

	/**
	 * 根据回答问题的个数查询满足条件的个数
	 * 
	 * @param tid
	 *            问题所在的分类
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param count
	 *            问题的回答量
	 * @return 满足条件的数据量
	 * @throws Exception
	 *             有异常向上抛出
	 */
	public int getAllCountByCount(int tid, String column, String keyWord, int count) throws Exception;

	/**
	 * 根据问题的悬赏分数获取数据量
	 * 
	 * @param tid
	 *            问题所在的分类
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param status
	 *            问题的状态
	 * @return 统计的结果
	 * @throws Exception
	 *             有异常向上抛出
	 */
	public int getAllCountByPoints(int tid, String column, String keyWord, int status) throws Exception;

	/**
	 * 更新问题的回答量
	 * 
	 * @param qid
	 *            要更新的问题的id
	 * @return 是否更新成功
	 * @throws Exception
	 *             有异常向上抛出
	 */
	public boolean updateCount(int qid) throws Exception;

	/**
	 * 更新问题的状态
	 * 
	 * @param qid
	 *            问题的编号
	 * @param status
	 *            问题的状态
	 * @return 是否更新成功
	 * @throws Exception
	 *             有异常向上抛出
	 */
	public boolean updateStatus(int qid, int status) throws Exception;

	/**
	 * 更新最佳答案
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean updateAnswer(Question vo) throws Exception;

	/**
	 * 用户提出问题中被解决问题的数据量
	 * 
	 * @param userid
	 *            用户id
	 * @param column
	 *            查询的关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param status
	 *            问题的状态（已解决为0，未解决为1）
	 * @return 解决问题的个数
	 * @throws Exception
	 *             有异常向上抛出
	 */
	public int getAllCountByUser(String userid, String column, String keyWord, int status) throws Exception;

	/**
	 * 用户提问题的个数
	 * 
	 * @param userid
	 *            用户id
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @return 用户提出问题的个数
	 * @throws Exception
	 *             有异常向上抛出
	 */
	public int getAllCountByUser(String userid, String column, String keyWord) throws Exception;

	/**
	 * 查询用户提出的问题(用户已解决的问题和未解决的问题列表)
	 * 
	 * @param userid
	 *            用户id
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param currentPage
	 *            当前页
	 * @param lineSize
	 *            每页显示
	 * @param status
	 *            问题的状态，status=0表示问题解决，status=1表示问题未解决
	 * @return 返回问题的列表
	 * @throws Exception
	 *             有异常向上抛出
	 */
	public List<Question> findAllByUser(String userid, String column, String keyWord, int currentPage, int lineSize,
			int status) throws Exception;

	/**
	 * 查询用户提出问题中被回答count次的问题
	 * 
	 * @param userid
	 *            用户id
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param currentPage
	 *            当前页
	 * @param lineSize
	 *            每页显示
	 * @param status
	 *            问题的状态，status=0表示问题已经解决啦，status=1表示问题未解决
	 * @param count
	 *            问题被回答的次数
	 * @return 如果找到就返回问题列表，如果未找到，就返回size()==0的List<Question>
	 * @throws Exception
	 *             有异常向上抛出
	 */
	public List<Question> findAllByUser(String userid, String column, String keyWord, int currentPage, int lineSize,
			int status, int count) throws Exception;

	/**
	 * 统计用户提出问题中有被回答count次的数据量
	 * 
	 * @param userid
	 *            用户id
	 * @param column
	 *            查询关键字端
	 * @param keyWord
	 *            查询关键字
	 * @param status
	 *            问题的状态，status=0表示问题已经解决；status=1表示问题未被解决
	 * @param count
	 *            问题被回答的次数
	 * @return 用户提出问题中有被回答count次的数据量
	 * @throws Exception
	 *             有异常向上抛出
	 */
	public int getAllCountByUser(String userid, String column, String keyWord, int status, int count) throws Exception;

	/**
	 * 根据指定的用户删除问题
	 * 
	 * @param userid
	 *            用户id
	 * @param qid
	 *            问题id
	 * @return 删除成功返回true,否则返回false
	 * @throws Exception
	 *             异常向上抛出
	 */
	public boolean doRemoveByUser(String userid, int qid) throws Exception;

	/**
	 * 查询用户回答问题中被采纳的问题列表（所采纳的问题肯定是已经解决的问题）
	 * 
	 * @param userid
	 *            用户id
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param currentPage
	 *            当前页
	 * @param lineSize
	 *            每页显示
	 * @return 返回满足条件的问题列表
	 * @throws Exception
	 *             异常向上抛出
	 */
	public List<Question> findAllAcceptAnswer(String userid, String column, String keyWord, int currentPage,
			int lineSize) throws Exception;

	/**
	 * 查询用户回答问题中未被采纳的问题列表(question.answer.userid!=该用户)
	 * 
	 * @param userid
	 *            用户id
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param currentPage
	 *            当前页
	 * @param lineSize
	 *            每页显示记录数
	 * @return 返回满足条件的问题列表
	 * @throws Exception
	 *             异常向上抛出
	 */
	public List<Question> findAllByAnswer(String userid, String column, String keyWord, int currentPage, int lineSize)
			throws Exception;

	/**
	 * 获取用户被采纳问题的数据量
	 * 
	 * @param userid
	 *            用户id
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @return 返回满足条件的问题个数
	 * @throws Exception
	 *             异常向上抛出
	 */
	public int getAllCountAcceptAnswer(String userid, String column, String keyWord) throws Exception;

	/**
	 * 获取用户未被采纳问题的数据量
	 * 
	 * @param userid
	 *            用户id
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @return 返回满足条件的问题数据量，以方便分页处理
	 * @throws Exception
	 *             异常向上抛出
	 */
	public int getAllCountByAnswer(String userid, String column, String keyWord) throws Exception;

	/**
	 * 根据回答查找问题
	 * 
	 * @param aid
	 *            回答id
	 * @return 如果查找到则返回question对象，否则返回Null
	 * @throws Exception
	 */
	public Question findByAnswer(int aid) throws Exception;

	/**
	 * 查询一个用户的全部提问
	 * 
	 * @param userid 用户id
	 * @return 一个用户的全部提问
	 * @param column
	 *            查询关键字段
	 * @param keyWord
	 *            查询关键字
	 * @param currentPage
	 *            当前页
	 * @param lineSize
	 *            每页显示记录数
	 * @throws Exception
	 *             异常向上抛出
	 */
	public List<Question> findAllByUser(String userid, String column, String keyWord, int currentPage, int lineSize)
			throws Exception;
    /**
     * 根据问题的状态得到问题的数量，例如:status=0表示问题得到解决的数量，status=1表示问题未得到解决的数量
     * @param status   问题的状态
     * @return    问题的数量
     * @throws Exception  异常向上抛出
     */
	public int getAllCountByStatus(int status)throws Exception;
}
