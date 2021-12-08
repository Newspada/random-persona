package com.facchinil.mapper.main;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;

import com.facchinil.dto.CognomeDTO;
import com.facchinil.entity.Cognome;
import com.facchinil.mapper.Mapper;

@Component
public class CognomeMapper implements Mapper<CognomeDTO, Cognome> {
	
	@Override
	public CognomeDTO toDTO(Cognome entity) {
		CognomeDTO dto = new CognomeDTO();
		dto.setCognome(entity.getValue());
		dto.setFrequenza(entity.getFrequenza());
		return dto;
	}
	
	@Override
	public Cognome toEntity(CognomeDTO dto) {
		throw new NotYetImplementedException();
	}
}
