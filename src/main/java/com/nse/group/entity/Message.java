package com.nse.group.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "messages")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "messageid")
	private long messageid;
	private long groupId;
	private String message;
	private enum messagetype {string, attachment};
	private Timestamp sentAt;
	private long attachmentId;

	public Message(long messageid, long groupId, String message, Timestamp sentAt, long attachmentId) {
		super();
		this.messageid = messageid;
		this.groupId = groupId;
		this.message = message;
		this.sentAt = sentAt;
		this.attachmentId = attachmentId;
	}

}
