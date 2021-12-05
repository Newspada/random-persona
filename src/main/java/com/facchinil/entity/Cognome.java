package com.facchinil.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "COGNOME")
public class Cognome implements Serializable {
	
	private static final long serialVersionUID = 4183070852107653090L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@NotNull
	@Column(name = "COGNOME")
	private String value;
	
	@NotNull
	@Column(name = "FREQUENZA")
	private Integer frequenza;
}
