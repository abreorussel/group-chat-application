package com.nse.group.service;

import java.util.List;

import com.nse.group.entity.GroupInfo;
import com.nse.group.entity.User;


public interface IGroupService {

	
	public User addUser(User user);
	
	public GroupInfo addGroup(GroupInfo group);
	
	public List<String> getGroupUser(long groupId);
	
	public List<Long> getGroup(long userId);
	
	public List<String> getUserGroup(long userId);
}
