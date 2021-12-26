package com.facchinil.es;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
public class ComuneES {
	
	@Field(type = FieldType.Text)
	private String comune;
	@Field(type = FieldType.Keyword)
	private String provincia;
	@Field(type = FieldType.Keyword)
	private String regione;
	@Field(type = FieldType.Text)
	private String prefisso;
	@Field(type = FieldType.Text)
	private String cap;
}
