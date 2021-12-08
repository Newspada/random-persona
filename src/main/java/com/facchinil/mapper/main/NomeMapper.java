package com.facchinil.mapper.main;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;

import com.facchinil.dto.NomeDTO;
import com.facchinil.entity.Nome;
import com.facchinil.mapper.Mapper;

@Component
public class NomeMapper implements Mapper<NomeDTO, Nome> {
	
	@Override
	public NomeDTO toDTO(Nome entity) {
		NomeDTO dto = new NomeDTO();
		dto.setNome(entity.getValue());
		dto.setFascia(entity.getFascia());
		dto.setSesso(entity.getSesso());
		dto.setFrequenza(entity.getFrequenza());
		return dto;
	}
	
	@Override
	public Nome toEntity(NomeDTO dto) {
		throw new NotYetImplementedException();
	}
}
