package com.nse.group.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nse.group.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	@Query(value="select * from message m where m.from_user_id = ?1 and m.to_user_id = ?2",nativeQuery = true)
	List<Message> findByFromAndToUser(int fromUserId, int toUserId);

}
