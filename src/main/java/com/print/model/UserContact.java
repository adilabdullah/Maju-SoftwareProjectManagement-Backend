package com.print.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_contact")
public class UserContact {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_CONTACT_SEQ")
	@SequenceGenerator(sequenceName = "user_contact_seq", allocationSize = 1, name = "USER_CONTACT_SEQ")
	int SNO;
	
	@Column
	int USER_ID;
	
	@Column
	int SESSION_ID;
	
	@Column
	String CONTACT_TYPE;
	
	@Column
	String CONTACT_VALUE;
	
	@Column
	String IS_CONFIRM;
	
	@Column
	Timestamp INSERT_DATE;
	
	@Column
	Timestamp UPDATE_DATE;

	
}
