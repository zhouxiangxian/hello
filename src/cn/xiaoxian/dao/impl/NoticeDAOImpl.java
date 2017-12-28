package cn.xiaoxian.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import cn.xiaoxian.dao.INoticeDAO;
import cn.xiaoxian.pojo.Notice;
@Component
public class NoticeDAOImpl extends HibernateDaoSupport implements INoticeDAO {
	@Autowired//注入对象
	public NoticeDAOImpl(HibernateTemplate hibernateTemplate){
		super.setHibernateTemplate(hibernateTemplate);
	}

	@Override
	public boolean doCreate(Notice vo) throws Exception {
		super.getHibernateTemplate().save(vo);
		return true;
	}

	@Override
	public boolean doUpdate(Notice vo) throws Exception {
		super.getHibernateTemplate().update(vo);
		return true;
	}

	@Override
	public boolean doRemove(Integer id) throws Exception {//删除公告
		super.getHibernateTemplate().bulkUpdate("DELETE FROM Notice AS n WHERE n.nid=?",id);
		return true;
	}

	@Override
	public Notice findById(Integer id) throws Exception {
		return super.getHibernateTemplate().get(Notice.class,id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notice> findAll() throws Exception {//查询全部
		return super.getHibernateTemplate().find("FROM Notice as n");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notice> findAll(String column, String keyWord, Integer currentPage, Integer lineSize) throws Exception {
		DetachedCriteria criteria=DetachedCriteria.forClass(Notice.class);
		criteria.add(Restrictions.like(column,"%"+keyWord+"%"));
		return super.getHibernateTemplate().findByCriteria(criteria,(currentPage-1)*lineSize,lineSize);//分页查询
	}

	@Override
	public int getAllCount(final String column,final String keyWord) throws Exception {//统计数量
		return super.getHibernateTemplate().execute(new HibernateCallback<Integer>(){

			@SuppressWarnings("rawtypes")
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				String hql="SELECT COUNT(n.nid) FROM Notice AS n WHERE n."+column+" LIKE ?";
				Query query=session.createQuery(hql);
				query.setString(0, "%"+keyWord+"%");
				List all=query.list();
				if(all!=null&&all.size()>0){
					return ((Long)all.get(0)).intValue();
				}
				return 0;
			}
			
		});
	}

}
