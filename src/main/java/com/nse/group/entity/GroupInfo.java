package com.nse.group.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class GroupInfo {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long groupId;
	private String groupName;
	
	//@ManyToMany(fetch = FetchType.EAGER , cascade = {CascadeType.MERGE , CascadeType.PERSIST} , mappedBy = "groupInfos")
	
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinTable(name = "user_group" , 
		joinColumns = {@JoinColumn(name = "group_id")},
		inverseJoinColumns = {@JoinColumn(name = "user_id")}
			)
	private Set<User> users = new HashSet<>();

	public GroupInfo(String groupName) {
		super();
		this.groupName = groupName;
	}
	
	
	
	public void addUser(User user) {
		this.getUsers().add(user);
		user.getGroupInfos().add(this);
	}
	
	
	
	public void removeUser(User user) {
		this.getUsers().remove(user);
		user.getGroupInfos().add(this);
	}
	
}
