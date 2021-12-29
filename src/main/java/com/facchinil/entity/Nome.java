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
@Table(name = "NOME")
public class Nome {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@NotNull
	@Column(name = "NOME")
	private String value;
	
	@Column(name = "SESSO")
	private String sesso;
	
	@Column(name = "FASCIA")
	private String fascia;
	
	@NotNull
	private Integer frequenza;
}
