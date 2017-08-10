package com.webTest.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.webTest.Bean.Category;

@Repository("categoryDao") 
public class CategoryDaoImpl extends HibernateTemplate implements CategoryDao{
	@Autowired
	SessionFactory sf;
	
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}


	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		List<Category> result = new ArrayList<>();
		sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from Category");
		result = q.list();
		s.close();
		sf.close();
		return result;
	}

	@Override
	public void add(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category get(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

}
