package com.nse.group.service;

import java.util.List;

import com.nse.group.entity.User;

public interface IUserService {

	
	public User addUser(User user);
	
	public List<User> getUsers();
	
	public User findByUserName(String name);
}
