package cn.xiaoxian.back.service;

import java.util.List;

import cn.xiaoxian.pojo.Type;
//定义服务层标准
public interface IBackTypeService {
	/**
	 * 增加类型
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean insert(Type vo)throws Exception;
	/**
	 * 更新类型
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean update(Type vo)throws Exception;
    /**
     * 删除类型
     * @param id
     * @return
     * @throws Exception
     */
	public boolean remove(Integer id)throws Exception;
	/**
	 * 列出所有类别
	 * @return
	 * @throws Exception
	 */
	public List<Type> list()throws Exception;
	/**
	 * 根据id查找类型
	 * @return
	 * @throws Exception
	 */
	public Type findById(Integer id)throws Exception;
}
