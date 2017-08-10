package com.webTest.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.webTest.Bean.User;

public interface UserDao {
	public List<User> getUserList();
	public void add(User user);
    public User get(int id);
    public void delete(int id);
    public void update(User user);
}
