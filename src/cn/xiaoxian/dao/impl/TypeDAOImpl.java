package cn.xiaoxian.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import cn.xiaoxian.dao.ITypeDAO;
import cn.xiaoxian.pojo.Type;
@Component
public class TypeDAOImpl extends HibernateDaoSupport implements ITypeDAO {
	@Autowired//注入HibernateTemplate
	public TypeDAOImpl(HibernateTemplate hibernateTemplate){
		super.setHibernateTemplate(hibernateTemplate);
	}

	@Override
	public boolean doCreate(Type vo) throws Exception {
		 super.getHibernateTemplate().save(vo);
		 return true;
	}

	@Override
	public boolean doUpdate(Type vo) throws Exception {
		super.getHibernateTemplate().update(vo);
		return true;
	}

	@Override
	public boolean doRemove(Integer id) throws Exception {
		super.getHibernateTemplate().bulkUpdate("DELETE Type WHERE tid=?", id);
		return true;
	}

	@Override
	public Type findById(Integer id) throws Exception {
		return super.getHibernateTemplate().get(Type.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Type> findAll() throws Exception {
		return super.getHibernateTemplate().find("FROM Type AS t");
	}

	@Override
	public List<Type> findAll(String column, String keyWord, Integer currentPage, Integer lineSize) throws Exception {
        throw new Exception("此方法未实现");
	}

	@Override
	public int getAllCount(String column, String keyWord) throws Exception {
		throw new Exception("此方法未实现");
	}

}
