package com.webTest.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webTest.Bean.User;
import com.webTest.Dao.UserDao;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUserList() {
		
	        List<User> users= userDao.getUserList();
	        return users;
	    
	}


	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		User user = userDao.get(id);
		return user;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}
}
