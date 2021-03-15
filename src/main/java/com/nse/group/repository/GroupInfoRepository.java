package com.nse.group.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nse.group.entity.GroupInfo;

@Repository
public interface GroupInfoRepository extends JpaRepository<GroupInfo, Long> {

	@Modifying
	@Transactional
	@Query(value = "SELECT GI.GROUP_NAME FROM GROUP_INFO GI JOIN USER_GROUP GR ON GR.GROUP_ID  = GI.GROUP_ID WHERE GR.USER_ID = ?1", nativeQuery = true)
	List<String> getGroup(long userId);
	
	
	GroupInfo findByGroupName(String name);

	
	@Modifying
	@Transactional
	@Query(value = "SELECT * FROM GROUP_INFO" , nativeQuery = true)
	List<GroupInfo> getGroups();
}
