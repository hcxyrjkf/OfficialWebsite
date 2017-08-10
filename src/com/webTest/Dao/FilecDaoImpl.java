package com.webTest.Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.naming.Reference;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.TypeHelper;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.webTest.Bean.Filec;
import com.webTest.Bean.User;


@Repository("filecDao")
public class FilecDaoImpl extends HibernateTemplate implements FilecDao{
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
	public List<Filec> getFilecList() {
		// TODO Auto-generated method stub
		List<Filec> result = new ArrayList();
        sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from Filec");
        result = q.list();
        s.close();
        sf.close();
        return result;
	}

	@Override
	public void  add(Filec filec) {
		// TODO Auto-generated method stub 
        sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        s.save(filec);
        s.getTransaction().commit();
        s.close();
        sf.close();
        
	}

	@Override
	public Filec get(int id) {
		// TODO Auto-generated method stub
		System.err.println(id);
        sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        Filec filec =new Filec();
        filec.setId(id);
        filec=  (Filec) s.get(Filec.class, filec.getId());
        //result = (Filec) s.get(Filec.class, id);
        s.close();
        sf.close();
        return filec;
		
	}
//	public static void main(String[] args) {
//		FilecDaoImpl filecDaoImpl = new FilecDaoImpl();
//		Filec filec=filecDaoImpl.get(1);
//		System.out.println(filec);
//		
//		
//		
//	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
        sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        Filec filec =new Filec();
        filec.setId(id);
        System.err.println("+++++++++++++++++++++++Dao"+ filec.getId());
        s.delete(filec);
        s.getTransaction().commit();
        s.close();
        sf.close();
	}

	@Override
	public void update(Filec filec) {
		// TODO Auto-generated method stub
        sf = new Configuration().configure()
                .buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        s.update(filec);
        s.getTransaction().commit();
        s.close();
        sf.close();
	}

}
