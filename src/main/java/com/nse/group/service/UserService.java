package com.nse.group.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nse.group.entity.User;
import com.nse.group.repository.UserRepository;

@Service
public class UserService implements IUserService{

	
	@Autowired
	UserRepository repo;
	
	@Override
	public User addUser(User user) {
		
		return repo.save(user);
	}

}
