package com.webTest.Service;

import java.util.List;

import com.webTest.Bean.User;

public interface UserService {
	public List<User> getUserList();
	public void add(User user);
    public User get(int id);
    public void delete(int id);
    public void update(User user);
}
