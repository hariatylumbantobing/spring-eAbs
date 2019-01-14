package com.projectK5.pabwe.services;

import com.projectK5.pabwe.model.User;

public interface UserService {
	  
	 public User findUserByUname(String uname);
	 
	 public void saveUser(User user);
	}