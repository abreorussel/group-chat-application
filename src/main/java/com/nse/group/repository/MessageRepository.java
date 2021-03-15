package com.nse.group.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nse.group.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
