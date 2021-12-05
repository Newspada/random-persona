package com.facchinil.dto;

import lombok.Data;

@Data
public class IndirizzoDTO extends Frequenzable{
	private static final long serialVersionUID = -3603901994545229963L;
	
	private String toponimo;
	private String denominazione;
	private ComuneDTO comune;
}
