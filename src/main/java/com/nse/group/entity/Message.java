package com.nse.group.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private long groupId;
	private String message;
	private enum messagetype {STRING, ATTACHMENT}
	private LocalDateTime sentAt;
	private long attachmentId;

	public Message(long messageId, long groupId, String message, LocalDateTime sentAt, long attachmentId) {
		super();
		this.messageId = messageId;
		this.groupId = groupId;
		this.message = message;
		this.sentAt = sentAt;
		this.attachmentId = attachmentId;
	}

}
