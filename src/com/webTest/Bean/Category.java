package com.webTest.Bean;

public class Category {
	private int categoryId;
	private String category;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Category(int categoryId, String category) {
		super();
		this.categoryId = categoryId;
		this.category = category;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", category=" + category
				+ "]";
	}
	
}
