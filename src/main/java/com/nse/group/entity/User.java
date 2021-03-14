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

@Data
@NoArgsConstructor
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
	
	@ManyToMany(fetch = FetchType.LAZY , cascade = {CascadeType.ALL})
	@JoinTable(name = "user_group" , 
		joinColumns = {@JoinColumn(name = "user_id")},
		inverseJoinColumns = {@JoinColumn(name = "group_id")}
			)
	private Set<GroupInfo> groupInfos = new HashSet<>();

}