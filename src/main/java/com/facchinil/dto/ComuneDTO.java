package com.facchinil.dto;

import lombok.Data;

@Data
public class ComuneDTO extends Frequenzable {
	private static final long serialVersionUID = 885922026049859020L;
	
	private Long id;
	private String comune;
	private String provincia;
	private String regione;
	private String prefisso;
	private String cap;
}
