package com.facchinil.mapper.main;

import java.math.BigDecimal;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;

import com.facchinil.dto.ComuneDTO;
import com.facchinil.dto.CoordinateDTO;
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
		if(entity.getLatitudine() != null && entity.getLongitudine() != null) {
			CoordinateDTO coordinate = new CoordinateDTO();
			coordinate.setLatitudine(BigDecimal.valueOf(entity.getLatitudine()));
			coordinate.setLongitudine(BigDecimal.valueOf(entity.getLongitudine()));
			dto.setCoordinate(coordinate);
		}
		return dto;
	}
	
	@Override
	public Comune toEntity(ComuneDTO dto) {
		throw new NotYetImplementedException();
	}
}
