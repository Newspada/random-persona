package com.facchinil.dto;

import lombok.Data;

@Data
public class FasciaEtaDTO extends Frequenzable {
	private static final long serialVersionUID = -9209379061303931110L;
	
	private String fascia;
	private Integer frequenzaMaschi;
	private Integer frequenzaFemmine;
}
