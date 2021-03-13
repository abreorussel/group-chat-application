package com.nse.group.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class UserGroupMap {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long mapId;
	
	@ManyToMany
	private Group group;
	
	@ManyToMany
	private User user;
	
}
