package com.facchinil.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CoordinateDTO implements DataTransferObject {
	private static final long serialVersionUID = -279374953807381902L;
	
	private BigDecimal latitudine;
	private BigDecimal longitudine;
}
