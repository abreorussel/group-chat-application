package com.nse.group.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nse.group.entity.GroupInfo;
import com.nse.group.entity.User;
import com.nse.group.exceptions.MemberAlreadyExistsException;
import com.nse.group.exceptions.MemberNotExistsException;
import com.nse.group.service.IGroupService;
import com.nse.group.service.IUserService;
import com.nse.group.service.UserService;

@RestController
@RequestMapping("/group")
public class GroupController {

	@Autowired
	IGroupService service;

	@Autowired
	IUserService userService;

	@PostMapping("/add")
	public GroupInfo addGroup(@RequestBody GroupInfo group) {

		return service.addGroup(group);

	}

	@PutMapping("/add-member/{groupName}/{userName}")
	public ResponseEntity<String> addUserToGroup(@PathVariable String groupName, @PathVariable String userName)
			throws MemberAlreadyExistsException {

		GroupInfo group = service.findByGroupName(groupName);

		User user = userService.findByUserName(userName);

		// check if user is already a member of this group
		if (group.getUsers().contains(user)) {

			throw new MemberAlreadyExistsException(userName + " is already a member of " + groupName);
		} else {

			group.addUser(user);

			GroupInfo group1 = service.addGroup(group);

			return new ResponseEntity<String>("Successfully added " + userName + " to " + groupName, HttpStatus.OK);

		}

	}

	@GetMapping("/get-members/{groupName}")
	public Set<User> getMembers(@PathVariable String groupName) {

		return service.findByGroupName(groupName).getUsers();

	}

	@DeleteMapping("/delete/{name}")
	public ResponseEntity<String> deleteGroupByName(@PathVariable String name) {

		service.deleteGroup(service.findByGroupName(name));

		return new ResponseEntity<String>("Successfully Deleted " + name, HttpStatus.OK);
	}

	@PutMapping("/remove-member/{groupName}/{userName}")
	public ResponseEntity<String> removeUserFromGroup(@PathVariable String groupName, @PathVariable String userName)
			throws MemberNotExistsException {

		GroupInfo group = service.findByGroupName(groupName);
		User user = userService.findByUserName(userName);

		// check if user exists as a member of the group
		if (!group.getUsers().contains(user)) {
			throw new MemberNotExistsException(userName + " is not a member of " + groupName);
		} else {

			group.removeUser(user);

			GroupInfo group1 = service.addGroup(group);

			return new ResponseEntity<String>("Successfully removed " + userName + " from " + groupName, HttpStatus.OK);

		}

	}

}
