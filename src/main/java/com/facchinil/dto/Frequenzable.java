package com.facchinil.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public abstract class Frequenzable implements Serializable {

	private static final long serialVersionUID = -6576664389851727249L;
	
	@JsonIgnore
	Integer frequenza;
	@JsonIgnore
	Integer frequenzaCumulativa;
}
