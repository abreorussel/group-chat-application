package com.nse.group.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long groupId;
    private String groupName;

}
