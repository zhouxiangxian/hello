package cn.xiaoxian.dao;

import java.util.List;

public interface IDAO<K, V> {
	/**
	 * 增加操作
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean doCreate(V vo) throws Exception;

	/**
	 * 更新操作
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean doUpdate(V vo) throws Exception;

	/**
	 * 删除操作
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean doRemove(K id) throws Exception;
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public V findById(K id)throws Exception;
	/**
	 * 查询全部
	 * @return
	 * @throws Exception
	 */
	public List<V> findAll()throws Exception;
	/**
	 * 分页查询全部
	 * @param column
	 * @param keyWord
	 * @param currentPage
	 * @param lineSize
	 * @return
	 * @throws Exception
	 */
	public List<V> findAll(String column,String keyWord,Integer currentPage,Integer lineSize)throws Exception;
    
	/**
	 * 查询记录数
	 * @param column
	 * @param keyWord
	 * @return
	 * @throws Exception
	 */
	public int getAllCount(String column,String keyWord)throws Exception;
}
