package cn.xiaoxian.front.service;

import cn.xiaoxian.pojo.Answer;

public interface IFrontAnswerService {
	/**
	 * 回答问题
	 * 
	 * @param vo
	 *            回答对象
	 * @return 是否回答成功
	 * @throws Exception
	 *             有异常向上抛出
	 */
	public boolean insert(Answer vo) throws Exception;

	
}
