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
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
	@SequenceGenerator(sequenceName = "users_sno_seq", allocationSize = 1, name = "USER_SEQ")
	int sno;
	
	@Column
	String f_name;
	
	@Column
	String l_name;
	
	@Column
	String username;
	
	@Column
	String email;
	
	@Column
	String cell;
	
	@Column
	String pass;
	
	@Column
	String c_pass;
	
	@Column
	String is_verify;
	
	@Column
	String is_active;
	
	@Column
	Timestamp insert_date;
	
	@Column
	Timestamp update_date;
}
