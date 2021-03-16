package com.nse.group.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nse.group.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
	User findByUserName(String name);
}
