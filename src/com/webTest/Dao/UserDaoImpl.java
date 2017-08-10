package com.webTest.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.webTest.Bean.User;
@Repository("userDao")
public class UserDaoImpl extends HibernateTemplate implements UserDao{
	//private static final Log log = LogFactory.getLog(UserDao.class);
	@Autowired
	SessionFactory sf;
	public SessionFactory getSf() {
		return sf;
	}
	@Resource
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		List<User> result = new ArrayList();
        sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from User");
        result = q.list();
        s.close();
        sf.close();
        return result;
		 
//		log.debug("finding all Admininfo instances");
//        try {
//            String queryString = "from usertable";
//            return getHibernateTemplate().find(queryString);
//        } catch (RuntimeException re) {
//            log.error("find all failed", re);
//            throw re;
//        }
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
//		List<User> result = new ArrayList();
//		 
//        sf = new Configuration().configure()
//                .buildSessionFactory();
//        Session s = sf.openSession();
//        s.beginTransaction();
// 
//        s.save(user);
// 
//        s.getTransaction().commit();
//        s.close();
//        sf.close();
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		User result = null;
        sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        result = (User) s.get(User.class, id);
        s.close();
        sf.close();
        return result;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		List<User> result = new ArrayList();
		 
        sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
 
        User user = (User) s.get(User.class, id);
        s.delete(user);
        s.getTransaction().commit();
        s.close();
        sf.close();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		List<User> result = new ArrayList();	 
        sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        s.update(user);
        s.getTransaction().commit();
        s.close();
        sf.close();
	}
	 
}
