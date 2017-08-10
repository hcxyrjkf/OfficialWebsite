package com.webTest.Action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.webTest.Bean.User;
import com.webTest.Dao.UserDaoImpl;
import com.webTest.Service.UserService;
import com.webTest.tools.Md5Test;
@Controller("userAction")
public class UserAction extends ActionSupport{
	private int id;
	private String userName;
	private String userPassword;
	@Resource
	private UserService userService; 
	private List<User> users;
	@Resource
	private Md5Test md5Test;
    public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String nameinfo = request.getParameter("userName");
		String passinfo = request.getParameter("userPassword");
		
		md5Test = new Md5Test();
		//nameinfo = md5Test.toMD5(nameinfo);
		passinfo = md5Test.toMD5(passinfo);
		users = userService.getUserList();
		//System.out.println("用户名"+nameinfo);
		//System.out.println("数据库用户名"+users.get(0).getUserName());
		//System.out.println("密码"+passinfo);
		//System.out.println("数据库密码"+users.get(0).getUserPassword());
		
		
		if (nameinfo.equals(users.get(0).getUserName())&&passinfo.equals(users.get(0).getUserPassword())) {
			return "success";
		}else {
			return "login";
		}
	}
//	public String getUser(int id){
//		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpServletResponse response = ServletActionContext.getResponse();
//		String userNameInfo = userService.get(1).getUserName();
//		String userPassInfo = userService.get(1).getUserPassword();
//		if (request.getParameter("userName").equals(userNameInfo)&&request.getParameter("userPassword").equals(userPassInfo)) {
//			return "success";
//		}else {
//			return "index";
//		}
//	}
//	public String show(){
//		//从页面获取的值等于数据库的值
//		HttpServletRequest request = ServletActionContext.getRequest();
//		HttpServletResponse response = ServletActionContext.getResponse();
//		UserDaoImpl use= new UserDaoImpl();
//		if (request.getParameter("userName").equals(this.userName)&&request.getParameter("userPassword").equals(this.userPassword)) {
//			return "success";
//		}else {
//			return "index";
//		}
//		
//		
//	}
//	
	
}
