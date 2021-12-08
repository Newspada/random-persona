package com.facchinil.mapper.main;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;

import com.facchinil.dto.DominioDTO;
import com.facchinil.entity.Dominio;
import com.facchinil.mapper.Mapper;

@Component
public class DominioMapper implements Mapper<DominioDTO, Dominio> {
	
	@Override
	public DominioDTO toDTO(Dominio entity) {
		DominioDTO dto = new DominioDTO();
		dto.setDominio(entity.getValue());
		dto.setFrequenza(entity.getFrequenza());
		return dto;
	}
	
	@Override
	public Dominio toEntity(DominioDTO dto) {
		throw new NotYetImplementedException();
	}
}
