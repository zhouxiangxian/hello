package cn.xiaoxian.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import cn.xiaoxian.dao.IQuestionDAO;
import cn.xiaoxian.pojo.Question;

@Component
public class QuestionDAOImpl extends HibernateDaoSupport implements IQuestionDAO {
	@Autowired // 注入对象
	public QuestionDAOImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}

	@Override
	public boolean doCreate(Question vo) throws Exception {
		super.getHibernateTemplate().save(vo);
		return true;
	}

	@Override
	public boolean doUpdate(Question vo) throws Exception {
		super.getHibernateTemplate().update(vo);
		return true;
	}

	@Override
	public boolean doRemove(Integer id) throws Exception {
		super.getHibernateTemplate().bulkUpdate("DELETE  Question Where qid= ? ", id);
		return true;
	}

	@Override
	public Question findById(final Integer id) throws Exception {
		return super.getHibernateTemplate().execute(new HibernateCallback<Question>() {

			@SuppressWarnings("unchecked")
			@Override
			public Question doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "FROM Question AS q  WHERE q.qid=?";
				Query query = session.createQuery(hql);
				query.setInteger(0, id);
				List<Question> list = query.list();
				if (list.size() > 0) {
					// 有值
					Question vo = list.get(0);
					vo.getType().getTitle();// 取得Type信息
					vo.getAnswers().size();// 取得全部的回答
					if (vo.getAnswer() != null) {
						// 存在最佳回答
						vo.getAnswer().getContent();
					}
					return vo;
				}
				return null;
			}
		});
	}

	@Override
	public List<Question> findAll() throws Exception {
		return super.getHibernateTemplate().loadAll(Question.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAll(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		// 添加限制
		criteria.add(Restrictions.like(column, "%" + keyWord + "%"));
		return super.getHibernateTemplate().findByCriteria(criteria, (currentPage - 1) * lineSize, lineSize);
	}

	@Override
	public int getAllCount(String column, String keyWord) throws Exception {
		List<?> list = super.getHibernateTemplate()
				.find("SELECT COUNT(*) FROM Question AS q WHERE q." + column + " LIKE ?", "%" + keyWord + "%");
		return ((Long)list.get(0)).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllByStatus(int tid, String column, String keyWord, int currentPage, int lineSize,
			int status) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		criteria.add(Restrictions.eq("type.tid", tid));
		criteria.add(Restrictions.eq("status", status));
		criteria.add(Restrictions.like(column, "%" + keyWord + "%"));// 模糊查询
		criteria.addOrder(Order.desc("pubtime"));
		return super.getHibernateTemplate().findByCriteria(criteria, (currentPage - 1) * lineSize, lineSize);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllByCount(int tid, String column, String keyWord, int currentPage, int lineSize,
			int count) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		criteria.add(Restrictions.eq("type.tid", tid));
		criteria.add(Restrictions.eq("count", count));
		criteria.add(Restrictions.eq("status", 1));// 设置问题的状态
		criteria.add(Restrictions.like(column, "%" + keyWord + "%"));
		criteria.addOrder(Order.desc("pubtime"));
		return super.getHibernateTemplate().findByCriteria(criteria, (currentPage - 1) * lineSize, lineSize);// 分页操作
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllByPoints(int tid, String column, String keyWord, int currentPage, int lineSize,
			int status) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		criteria.add(Restrictions.eq("type.tid", tid));
		criteria.add(Restrictions.eq("status", status));
		criteria.add(Restrictions.like(column, "%" + keyWord + "%"));
		criteria.addOrder(Order.desc("points"));// 按分数排序
		return super.getHibernateTemplate().findByCriteria(criteria, (currentPage - 1) * lineSize, lineSize);
	}

	@Override
	public int getAllCountByStatus(int tid, String column, String keyWord, int status) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		criteria.setProjection(Projections.count("qid"));
		criteria.add(Restrictions.eq("type.tid", tid));// 问题类型
		criteria.add(Restrictions.eq("status", status));// 问题状态
		criteria.add(Restrictions.like(column, "%" + keyWord + "%"));
		return (Integer) super.getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	@Override
	public int getAllCountByCount(int tid, String column, String keyWord, int count) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		criteria.add(Restrictions.eq("type.tid", tid));
		criteria.add(Restrictions.eq("count", count));
		criteria.add(Restrictions.like(column, "%" + keyWord + "%"));
		criteria.setProjection(Projections.count("qid"));
		return (Integer) super.getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	@Override
	public int getAllCountByPoints(int tid, String column, String keyWord, int status) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		criteria.add(Restrictions.eq("type.tid", tid));
		criteria.add(Restrictions.eq("status", status));
		criteria.add(Restrictions.like(column, "%" + keyWord + "%"));
		criteria.setProjection(Projections.count("qid"));
		return (Integer) super.getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	@Override
	public boolean updateCount(final int qid) throws Exception {
		return super.getHibernateTemplate().execute(new HibernateCallback<Boolean>() {
			@Override
			public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "UPDATE Question AS q SET q.count=q.count+1 WHERE qid=?";
				Query query = session.createQuery(hql);
				query.setInteger(0, qid);
				if (query.executeUpdate() > 0) {
					return true;// 更新成功
				}
				return false;// 更新失败
			}
		});
	}

	@Override
	public boolean updateStatus(final int qid, final int status) throws Exception {
		return super.getHibernateTemplate().execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "UPDATE Question SET status=? WHERE qid=?";
				Query query = session.createQuery(hql);
				query.setInteger(0, status);
				query.setInteger(1, qid);
				if (query.executeUpdate() > 0) {
					return true;// 更新成功
				}
				return false;// 更新失败
			}

		});
	}

	@Override
	public boolean updateAnswer(final Question vo) throws Exception {
		return super.getHibernateTemplate().execute(new HibernateCallback<Boolean>() {
			@Override
			public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "UPDATE Question SET aid=? WHERE qid=?";
				Query query = session.createQuery(hql);
				query.setInteger(0, vo.getAnswer().getAid());
				query.setInteger(1, vo.getQid());
				if (query.executeUpdate() > 0) {
					return true;// 更新成功
				}
				return false;// 更新失败
			}
		});
	}

	@Override
	public int getAllCountByUser(String userid, String column, String keyWord, int status) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		criteria.setProjection(Projections.count("qid"));// 统计个数
		criteria.add(Restrictions.like(column, "%" + keyWord + "%"));
		criteria.add(Restrictions.eq("user.userid", userid));
		criteria.add(Restrictions.eq("status", status));
		return (Integer) super.getHibernateTemplate().findByCriteria(criteria).get(0);// 返回个数
	}

	@Override
	public int getAllCountByUser(String userid, String column, String keyWord) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		criteria.setProjection(Projections.count("qid"));
		criteria.add(Restrictions.like(column, "%" + keyWord + "%"));
		criteria.add(Restrictions.eq("user.userid", userid));
		return (Integer) super.getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllByUser(String userid, String column, String keyWord, int currentPage, int lineSize,
			int status) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		criteria.add(Restrictions.eq("user.userid", userid));// 按userid查询
		criteria.add(Restrictions.like(column, "%" + keyWord + "%"));// 模糊查询
		criteria.add(Restrictions.eq("status", status));// 问题的状态
		criteria.addOrder(Order.desc("pubtime"));// 按时间降序排列
		return super.getHibernateTemplate().findByCriteria(criteria, (currentPage - 1) * lineSize, lineSize);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllByUser(String userid, String column, String keyWord, int currentPage, int lineSize,
			int status, int count) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		criteria.add(Restrictions.eq("user.userid", userid));
		criteria.add(Restrictions.like(column, "%" + keyWord + "%"));
		criteria.add(Restrictions.eq("status", status));// 0回答肯定未解决
		criteria.add(Restrictions.eq("count", count));// 0回答
		criteria.addOrder(Order.desc("pubtime"));// 按用户提问题的时间排序
		return super.getHibernateTemplate().findByCriteria(criteria, (currentPage - 1) * lineSize, lineSize);
	}

	@Override // 查找0回答的问题个数
	public int getAllCountByUser(String userid, String column, String keyWord, int status, int count) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		criteria.add(Restrictions.eq("user.userid", userid));
		criteria.add(Restrictions.like(column, "%" + keyWord + "%"));
		criteria.add(Restrictions.eq("status", status));// 未解决
		criteria.add(Restrictions.eq("count", count));// 0回答
		criteria.setProjection(Projections.count("qid"));
		return (Integer) super.getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	@Override
	public boolean doRemoveByUser(final String userid, final int qid) throws Exception {
		return super.getHibernateTemplate().execute(new HibernateCallback<Boolean>() {
			@Override
			public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "DELETE FROM Question WHERE userid =? AND qid=?";
				Query query = session.createQuery(hql);
				query.setString(0, userid);
				query.setInteger(1, qid);
				return query.executeUpdate() > 0;
			}
		});
	}

	@Override
	public List<Question> findAllAcceptAnswer(final String userid, final String column, final String keyWord,
			final int currentPage, final int lineSize) throws Exception {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<Question>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<Question> doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "FROM Question AS q "
						+ "WHERE  q.answer.aid IN(SELECT a.aid  FROM Answer AS a WHERE  a.user.userid=?)"
						+ "AND q.status=0 AND q." + column + " LIKE ?";
				Query query = session.createQuery(hql);
				query.setString(0, userid);
				query.setString(1, "%" + keyWord + "%");
				// 设置分页
				query.setFirstResult((currentPage - 1) * lineSize);
				query.setMaxResults(lineSize);
				return query.list();
			}

		});
	}

	@Override
	public List<Question> findAllByAnswer(final String userid, final String column, final String keyWord,
			final int currentPage, final int lineSize) throws Exception {
		return super.getHibernateTemplate().execute(new HibernateCallback<List<Question>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<Question> doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "FROM Question AS q "
						+ " WHERE q.answer.aid NOT IN(SELECT a.aid FROM Answer AS a WHERE a.user.userid=?)"
						+ " AND q.qid IN(SELECT a.question.qid FROM Answer AS a WHERE a.user.userid=?)AND q.status=0 AND q."
						+ column + " LIKE ?";
				Query query = session.createQuery(hql);
				// 设置值
				query.setString(0, userid);
				query.setString(1, userid);
				query.setString(2, "%" + keyWord + "%");// 模糊查询
				// 设置分页
				query.setFirstResult((currentPage - 1) * lineSize);
				query.setMaxResults(lineSize);
				return query.list();
			}
		});
	}

	@Override
	public int getAllCountAcceptAnswer(final String userid, final String column, final String keyWord)
			throws Exception {
		return super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@SuppressWarnings("rawtypes")
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "SELECT COUNT(q.qid)" +"FROM Question AS q "
						+ " WHERE q.answer.aid IN(SELECT a.aid  FROM Answer AS a WHERE a.user.userid=?)"
						+ "AND q.status=0 AND q." + column + " LIKE ?";
				Query query = session.createQuery(hql);
				query.setString(0, userid);
				query.setString(1, "%" + keyWord + "%");
				List all = query.list();
				if (all != null && all.size() > 0) {
					return ((Long) all.get(0)).intValue();
				}
				return 0;
			}
		});
	}

	@Override
	public int getAllCountByAnswer(final String userid, final String column, final String keyWord) throws Exception {
		return super.getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@SuppressWarnings("rawtypes")
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "SELECT COUNT(q.qid) FROM  Question AS q WHERE q.answer.aid NOT IN(SELECT a.aid FROM Answer AS a WHERE a.user.userid=?)"
						+ "AND q.status=0 AND q." + column
						+ " LIKE ? AND q.qid IN (SELECT a.question.qid FROM Answer AS a WHERE a.user.userid=?)";
				Query query = session.createQuery(hql);
				query.setString(0, userid);
				query.setString(1,"%"+keyWord+"%");
				query.setString(2, userid);
				List all=query.list();
				if(all!=null&&all.size()>0){
					return ((Long)all.get(0)).intValue();
				}
				return 0;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> findAllByStatus(String column, String keyWord, int currentPage, int lineSize, int status)
			throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		criteria.add(Restrictions.eq("status", status));
		criteria.add(Restrictions.like(column, "%" + keyWord + "%"));// 模糊查询
		criteria.addOrder(Order.desc("pubtime"));
		return super.getHibernateTemplate().findByCriteria(criteria, (currentPage - 1) * lineSize, lineSize);

	}

	@Override
	public int getAllCountByStatus(String column, String keyWord, int status) throws Exception {
		DetachedCriteria criteria = DetachedCriteria.forClass(Question.class);
		criteria.setProjection(Projections.count("qid"));
		criteria.add(Restrictions.eq("status", status));// 问题状态
		criteria.add(Restrictions.like(column, "%" + keyWord + "%"));
		return (Integer) super.getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	@Override
	//根据回答id查找问题，我这个回答的id是不是这个问题的最佳回答
	public Question findByAnswer( final int aid) throws Exception {
		return super.getHibernateTemplate().execute(new HibernateCallback<Question>(){

			@SuppressWarnings("rawtypes")
			@Override
			public Question doInHibernate(Session session) throws HibernateException, SQLException {
				String hql="FROM Question AS q WHERE q.answer.aid=?";
				Query query=session.createQuery(hql);//获取Query对象
				//设置值
				query.setInteger(0, aid);
				List all=query.list();
				if(all!=null&&all.size()>0){
					return (Question)all.get(0);
				}
				return null;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	//查询一个用户的全部提问
	public List<Question> findAllByUser(String userid,String column,String keyWord,int currentPage,int lineSize) throws Exception {
		DetachedCriteria criteria=DetachedCriteria.forClass(Question.class);
		criteria.add(Restrictions.eq("user.userid", userid));//按用户id查询
		criteria.add(Restrictions.like(column, "%"+keyWord+"%"));//模糊查询
		return super.getHibernateTemplate().findByCriteria(criteria, (currentPage-1)*lineSize, lineSize);//设置分页
	}

	@Override
	//查询指定问题的数量
	public int getAllCountByStatus(int status) throws Exception {
		DetachedCriteria criteria=DetachedCriteria.forClass(Question.class);
		criteria.add(Restrictions.eq("status", status));//按照问题的状态查询
		criteria.setProjection(Projections.count("qid"));//统计问题的数量
		return (Integer)super.getHibernateTemplate().findByCriteria(criteria).get(0);
	}

}
