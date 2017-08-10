package com.webTest.Dao;

import java.util.List;

import com.webTest.Bean.Category;

public interface CategoryDao {
	public List<Category> getCategoryList();
	public void add(Category category);
	public Category get(String categoryId);
	public void delete(int id);
	public Category update(Category category);
}
