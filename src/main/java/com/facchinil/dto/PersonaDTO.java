package com.facchinil.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PersonaDTO {
	private String nome;
	private String cognome;
	private String sesso;
	private IndirizzoDTO indirizzo;
	private String numeroTelefono;
	private String email;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataNascita;
}
