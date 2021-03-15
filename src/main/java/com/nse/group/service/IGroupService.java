package com.nse.group.service;

import java.util.List;

import com.nse.group.entity.GroupInfo;
import com.nse.group.entity.User;

public interface IGroupService {

	public GroupInfo addGroup(GroupInfo group);

	public GroupInfo findByGroupName(String name);

	public void deleteGroup(GroupInfo group);
	
	 

}
