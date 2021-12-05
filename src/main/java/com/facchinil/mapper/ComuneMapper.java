package com.facchinil.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;

import com.facchinil.dto.ComuneDTO;
import com.facchinil.entity.Comune;
import com.google.common.collect.Lists;

@Component
public class ComuneMapper implements Mapper<ComuneDTO, Comune> {
	
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
	
	public List<ComuneDTO> toDTOs(List<Comune> entities) {
		if(CollectionUtils.isNotEmpty(entities)) {
			return entities.stream().map(this::toDTO).collect(Collectors.toList());
		}
		return Lists.newArrayList();
	}
	
	public Comune toEntity(ComuneDTO dto) {
		throw new NotYetImplementedException();
	}
}
