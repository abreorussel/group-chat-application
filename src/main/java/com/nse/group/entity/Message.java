package com.nse.group.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nse.group.util.ChatUtility;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "messages")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "messageid")
	private long messageId;
	private String sender;
	private long groupId;
	private String message;
	//private enum messagetype {STRING, ATTACHMENT}
	private String sentAt;
	//private long attachmentId;

	public Message(String sender, String message) {
		this.sender = sender;
		this.message = message;
		this.sentAt = ChatUtility.getCurrentTimeStamp();
	}

}
