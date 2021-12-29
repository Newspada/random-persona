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
@Table(name = "FASCIA_ETA")
public class FasciaEta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@NotNull
	@Column(name = "FASCIA_ETA")
	private String fascia;
	
	@NotNull
	@Column(name = "CELIBI")
	private Integer frequenzaCelibi;
	
	@NotNull
	@Column(name = "CONIUGATI")
	private Integer frequenzaConiugati;
	
	@NotNull
	@Column(name = "DIVORZIATI")
	private Integer frequenzaDivorziati;
	
	@NotNull
	@Column(name = "VEDOVI")
	private Integer frequenzaVedovi;
	
	@NotNull
	@Column(name = "MASCHI")
	private Integer frequenzaMaschi;
	
	@NotNull
	@Column(name = "FEMMINE")
	private Integer frequenzaFemmine;
	
	@NotNull
	@Column(name = "TOTALE")
	private Integer frequenzaTotale;
}
