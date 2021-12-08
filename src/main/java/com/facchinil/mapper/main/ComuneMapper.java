package com.facchinil.mapper.main;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;

import com.facchinil.dto.ComuneDTO;
import com.facchinil.entity.Comune;
import com.facchinil.mapper.Mapper;

@Component
public class ComuneMapper implements Mapper<ComuneDTO, Comune> {
	
	@Override
	public ComuneDTO toDTO(Comune entity) {
		ComuneDTO dto = new ComuneDTO();
		dto.setId(entity.getId());
		dto.setComune(entity.getValue());
		dto.setCap(entity.getCap());
		dto.setPrefisso(entity.getPrefisso());
		dto.setProvincia(entity.getProvincia());
		dto.setRegione(entity.getRegione());
		dto.setFrequenza(entity.getFrequenza());
		return dto;
	}
	
	@Override
	public Comune toEntity(ComuneDTO dto) {
		throw new NotYetImplementedException();
	}
}
