package com.nse.group.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;
	private String fullName;
	private String emailId;
	private String phoneNumber;
	private String userName;
	private String password;
	private LocalDate creationDate = LocalDate.now();
	private String userDp;
	
//	@ManyToMany(fetch = FetchType.EAGER , cascade = {CascadeType.MERGE , CascadeType.PERSIST})
//	@JoinTable(name = "user_group" , 
//		joinColumns = {@JoinColumn(name = "user_id")},
//		inverseJoinColumns = {@JoinColumn(name = "group_id")}
//			)
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "users")
	private Set<GroupInfo> groupInfos = new HashSet<>();

	public User(String fullName, String emailId, String phoneNumber, String userName, String password, String userDp) {
		super();
		this.fullName = fullName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.password = password;
		this.userDp = userDp;
	}
	
	
	public void addGroup(GroupInfo group) {
		this.groupInfos.add(group);
		group.getUsers().add(this);
	}
	
	
	public void removeGroup(GroupInfo group) {
		this.groupInfos.remove(group);
		group.getUsers().remove(this);
	}
	

	
	
	
}
