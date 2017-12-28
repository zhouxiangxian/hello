package cn.xiaoxian.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import cn.xiaoxian.dao.IAdminDAO;
import cn.xiaoxian.pojo.Admin;

@Component
public class AdminDAOImpl extends HibernateDaoSupport implements IAdminDAO {
	@Autowired
	public AdminDAOImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}

	@Override
	// 增加管理员
	public boolean doCreate(Admin vo) throws Exception {
		super.getHibernateTemplate().save(vo);
		return true;
	}

	@Override
	public boolean doUpdate(Admin vo) throws Exception {
		throw new Exception("该方法尚未实现!");
	}

	@Override
	public boolean doRemove(String id) throws Exception {
		throw new Exception("该方法尚未实现！");
	}

	@Override
	// 查询管理员
	public Admin findById(String id) throws Exception {
		return super.getHibernateTemplate().get(Admin.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	// 查询全部管理员
	public List<Admin> findAll() throws Exception {
		return super.getHibernateTemplate().find("FROM Admin AS a");
	}

	@SuppressWarnings("unchecked")
	@Override
	//查询全部管理员,分页显示
	public List<Admin> findAll(String column, String keyWord, Integer currentPage, Integer lineSize) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Admin.class);
		criteria.add(Restrictions.like(column, "%"+keyWord+"%"));//模糊查询
		return super.getHibernateTemplate().findByCriteria(criteria,(currentPage-1)*lineSize,lineSize);
	}

	@Override
	//统计管理员数量
	public int getAllCount(String column, String keyWord) throws Exception {
		List<?> all=super.getHibernateTemplate().find("SELECT COUNT(a.adminid) FROM Admin AS a WHERE a."+column+"LIKE ?","%"+keyWord+"%");
		return ((Long)all.get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	//管理员的登录操作
	public boolean findLogin(Admin vo) throws Exception {
		String hql=" FROM Admin AS a WHERE a.adminid=? AND a.password=?";
		List<Admin> all=super.getHibernateTemplate().find(hql,vo.getAdminid(),vo.getPassword());
		if(all!=null&&all.size()>0){
			//登录成功
			return true;
		}else{
			//登录失败
		}
		return false;
	}
}
