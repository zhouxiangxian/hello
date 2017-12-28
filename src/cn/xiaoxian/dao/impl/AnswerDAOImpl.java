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

import cn.xiaoxian.dao.IAnswerDAO;
import cn.xiaoxian.pojo.Answer;
@Component
public class AnswerDAOImpl extends HibernateDaoSupport implements IAnswerDAO {
	@Autowired
	public AnswerDAOImpl(HibernateTemplate hibernateTemplate){
		super.setHibernateTemplate(hibernateTemplate);
	}

	@Override
	public boolean doCreate(Answer vo) throws Exception {
		super.getHibernateTemplate().save(vo);
		return true;
	}

	@Override
	public boolean doUpdate(Answer vo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Integer id) throws Exception {
		 super.getHibernateTemplate().bulkUpdate("DELETE FROM Answer AS a WHERE a.aid=?",id);
		 return true;
	}

	@Override
	public Answer findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Answer> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Answer> findAll(String column, String keyWord, Integer currentPage, Integer lineSize) throws Exception {
		DetachedCriteria criteria=DetachedCriteria.forClass(Answer.class);
		criteria.add(Restrictions.like(column, "%"+keyWord+"%"));//模糊查询
		return super.getHibernateTemplate().findByCriteria(criteria, (currentPage-1)*lineSize, lineSize);//分页查询
	}

	@Override
	public int getAllCount(final String column,final String keyWord) throws Exception {
		return super.getHibernateTemplate().execute(new HibernateCallback<Integer>(){

			@SuppressWarnings("rawtypes")
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				String hql="SELECT COUNT(a.aid) FROM Answer AS a WHERE a."+column+" LIKE ?";
				Query query=session.createQuery(hql);
				//设置值
				query.setString(0, "%"+keyWord+"%");
				List all=query.list();
				if(all!=null&&all.size()>0){
					return ((Long)all.get(0)).intValue();//返回记录数
				}
				return 0;
			}
		});
	}

}
