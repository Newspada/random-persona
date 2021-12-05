package com.facchinil.entity;

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
@Table(name = "COMUNE")
public class Comune {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@NotNull
	@Column(name = "COMUNE")
	private String value;
	
	@NotNull
	@Column(name = "PROVINCIA")
	private String provincia;
	
	@NotNull
	@Column(name = "REGIONE")
	private String regione;
	
	@NotNull
	@Column(name = "PREFISSO")
	private String prefisso;
	
	@NotNull
	@Column(name = "CAP")
	private String cap;
	
	@NotNull
	@Column(name = "FREQUENZA")
	private Integer frequenza;
}
