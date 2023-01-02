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
@Table(name="quotation_images")
public class FileUpload {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quotation_images_seq")
	@SequenceGenerator(sequenceName = "quotation_images_seq", allocationSize = 1, name = "quotation_images_seq")
	int SNO;
	
	@Column
	int USER_ID;
	
	@Column
	int SESSION_ID;
	
	@Column
	String ENQUIRY_NO;
	
	@Column
	String FILE_LOCATION;
	
	@Column
	String FILE_TYPE;
	
	@Column
	String FILE_SIZE;
	
	@Column
	Timestamp INSERT_DATE;
	
	@Column
	Timestamp UPDATE_DATE;

}
