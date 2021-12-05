package com.facchinil.dto;

import lombok.Data;

@Data
public class NomeDTO extends Frequenzable {
	private static final long serialVersionUID = -3377364783600237711L;
	
	private String nome;
	private String sesso;
	private Integer fascia;
}
