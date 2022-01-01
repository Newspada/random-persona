package com.facchinil.es;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
public class IndirizzoES {
    
	@Field(type = FieldType.Keyword)
	private String toponimo;
	
	@Field(type = FieldType.Text)
	private String denominazione;
	
	@Field(type = FieldType.Nested)
	private ComuneES comune;
	
}
