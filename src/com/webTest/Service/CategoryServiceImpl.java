package com.webTest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webTest.Bean.Category;
import com.webTest.Dao.CategoryDao;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDao categoryDao;
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		List<Category> categories = categoryDao.getCategoryList();
		return categories;
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
	public void update(Category category) {
		// TODO Auto-generated method stub
		
	}

}
