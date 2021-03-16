package com.nse.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nse.group.entity.GroupInfo;
import com.nse.group.entity.User;
import com.nse.group.repository.GroupInfoRepository;

@Service
public class GroupService implements IGroupService{

	@Autowired
	GroupInfoRepository repo;
	
	
	@Override
	public GroupInfo addGroup(GroupInfo group) {
		
		return repo.save(group);
	}


	@Override
	public GroupInfo findByGroupName(String name) {
	
		return repo.findByGroupName(name);
	}


	@Override
	public void deleteGroup(GroupInfo group) {
		
		repo.delete(group);
	}



}
