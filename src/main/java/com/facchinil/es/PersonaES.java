package com.facchinil.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Data
@Document(indexName = "random-master")
public class PersonaES {
	
	@Id
    private String id;
	@Field(type = FieldType.Text)
	private String nome;
	@Field(type = FieldType.Text)
	private String cognome;
	@Field(type = FieldType.Keyword)
	private String sesso;
	@Field(type = FieldType.Nested)
	private IndirizzoES	 indirizzo;
	@Field(type = FieldType.Text)
	private String numeroTelefono;
	@Field(type = FieldType.Text)
	private String email;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
//	private Date dataNascita;
}
