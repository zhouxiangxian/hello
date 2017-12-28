package cn.xiaoxian.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import cn.xiaoxian.dao.IUserDAO;
import cn.xiaoxian.pojo.User;
@Component
public class UserDAOImpl extends HibernateDaoSupport implements IUserDAO {
    @Autowired
	public UserDAOImpl(HibernateTemplate hibernateTemplate){
    	super.setHibernateTemplate(hibernateTemplate);
    }
	@Override
	public boolean doCreate(User vo) throws Exception {
		super.getHibernateTemplate().save(vo);
		return true;
	}

	@Override
	public boolean doUpdate(User vo) throws Exception {
		super.getHibernateTemplate().update(vo);
		return true;
	}

	@Override
	//删除用户操作
	public boolean doRemove(String id) throws Exception {
		super.getHibernateTemplate().bulkUpdate("DELETE FROM User AS u WHERE u.userid=?",id);
		return true;
	}

	@Override
	public User findById(String id) throws Exception {//查找指定用户
		return super.getHibernateTemplate().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	//查询全部用户的信息
	public List<User> findAll() throws Exception {
		return super.getHibernateTemplate().find("FROM User AS u");
	}

	@SuppressWarnings("unchecked")
	@Override
	//查询全部用户，并设置分页显示
	public List<User> findAll(String column, String keyWord, Integer currentPage, Integer lineSize) throws Exception {
		DetachedCriteria criteria =DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.like(column, "%"+keyWord+"%"));//模糊查询
		criteria.addOrder(Order.desc("points"));//按分数排序
		return super.getHibernateTemplate().findByCriteria(criteria, (currentPage-1)*lineSize, lineSize);//设置分页
	}

	@Override
	//按照分页查询要求得到用户数量
	public int getAllCount(String column, String keyWord) throws Exception {
		List<?> list=super.getHibernateTemplate().find("SELECT COUNT(*)FROM User AS u WHERE u."+column+" LIKE ?","%"+keyWord+"%");
		return ((Long)list.get(0)).intValue();
	}

	@Override
	public boolean findLogin(User user) throws Exception {
		boolean flag=false;
		String hql="FROM User AS u WHERE u.userid=? AND u.password=?";
		List<?> result=this.getHibernateTemplate().find(hql, user.getUserid(),user.getPassword());
		if(result!=null&&result.size()!=0){
			flag=true;
		}
		return flag;
	}
	@Override
	public boolean updatePoints(final String userid, final int points) throws Exception {
		return super.getHibernateTemplate().execute(new HibernateCallback<Boolean>(){
			@Override
			public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
				String hql="UPDATE User SET points=points+"+points+" WHERE userid=?";
				Query query=session.createQuery(hql);
				query.setString(0, userid);
				if(query.executeUpdate()>0){
					return true;//更新成功
				}
				System.out.println("积分更新失败!");
				return false;//更新失败
			}
		});
	}
	@Override
	public boolean updateInfo(final User vo) throws Exception {
		return super.getHibernateTemplate().execute(new HibernateCallback<Boolean>(){

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
				String hql="UPDATE User  SET sex=?,email=?,image=? WHERE userid=?";
				Query query=session.createQuery(hql);
				query.setString(0, vo.getSex());
				query.setString(1, vo.getEmail());
				query.setString(2, vo.getImage());
				query.setString(3, vo.getUserid());
				if(query.executeUpdate()>0){
					return true;//更新成功
				}
				return false;//更新失败
			}
			
		});
	}
	@Override
	public boolean updatePassword(final User vo) throws Exception {
		return super.getHibernateTemplate().execute(new HibernateCallback<Boolean>(){
			@Override
			public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
				String hql="UPDATE  User SET password=?  WHERE userid=?";
				Query query=session.createQuery(hql);
				query.setString(0, vo.getPassword());//新的密码
				query.setString(1,vo.getUserid());
				if(query.executeUpdate()>0){
					//更新成功
					return true;
				}
				return false;
			}
		});
	}

}
