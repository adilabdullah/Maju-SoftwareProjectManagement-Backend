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
@Table(name="QUOTATION")
public class Quotation {

	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUOTATION_SEQ")
	@SequenceGenerator(sequenceName = "quotation_seq", allocationSize = 1, name = "QUOTATION_SEQ")
	int SNO;
	
	@Column
	int USER_ID;
	
	@Column
	int SESSION_ID;
	
	@Id
	String	ENQUIRY_NO;
	
	@Column
	String USER_NAME;
	
	@Column
	double LENGTH_Y;
	
	@Column
	double WIDTH_X;
	
	@Column
	double HEIGHT_Z;
	
	@Column
	String DIMENSION_TYPE;
	
	@Column
	String PAPER_TYPE;
	
	@Column
	double PAPER_GSM;
	
	@Column
	String DESCRIPTIONS;
	
	@Column
	int QUANTITY;
	
	@Column
	String CURRENCY;
	
	@Column
	String IS_ANSWERED;
	
	@Column
	double UNIT_PRICE;
	
	@Column
	Timestamp INSERT_DATE;
	
	@Column
	Timestamp UPDATE_DATE;
	



}
