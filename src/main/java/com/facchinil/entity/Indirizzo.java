package com.facchinil.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "INDIRIZZO")
public class Indirizzo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@NotNull
	@Column(name = "TOPONIMO")
	private String toponimo;
	
	@NotNull
	@Column(name = "DENOMINAZIONE")
	private String denominazione;
	
	@NotNull
	@Column(name = "FREQUENZA")
	private Integer frequenza;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_COMUNE", referencedColumnName = "ID")
	private Comune comune;
}
