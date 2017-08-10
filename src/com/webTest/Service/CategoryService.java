package com.webTest.Service;

import java.util.List;

import com.webTest.Bean.Category;



public interface CategoryService {
	public List<Category> getCategoryList();
	public void add(Category category);
    public Category get(String categoryId);
    public void delete(int id);
    public void update(Category category );
}
