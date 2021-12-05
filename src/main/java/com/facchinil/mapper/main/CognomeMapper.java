package com.facchinil.mapper.main;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;

import com.facchinil.dto.CognomeDTO;
import com.facchinil.entity.Cognome;
import com.facchinil.mapper.Mapper;
import com.google.common.collect.Lists;

@Component
public class CognomeMapper implements Mapper<CognomeDTO, Cognome> {
	
	public CognomeDTO toDTO(Cognome entity) {
		CognomeDTO dto = new CognomeDTO();
		dto.setCognome(entity.getValue());
		dto.setFrequenza(entity.getFrequenza());
		return dto;
	}
	
	public List<CognomeDTO> toDTOs(List<Cognome> entities) {
		if(CollectionUtils.isNotEmpty(entities)) {
			return entities.stream().map(this::toDTO).collect(Collectors.toList());
		}
		return Lists.newArrayList();
	}
	
	public Cognome toEntity(CognomeDTO dto) {
		throw new NotYetImplementedException();
	}
}
