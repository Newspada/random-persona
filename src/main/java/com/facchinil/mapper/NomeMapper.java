package com.facchinil.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;

import com.facchinil.dto.NomeDTO;
import com.facchinil.entity.Nome;
import com.google.common.collect.Lists;

@Component
public class NomeMapper implements Mapper<NomeDTO, Nome> {
	
	public NomeDTO toDTO(Nome entity) {
		NomeDTO dto = new NomeDTO();
		dto.setNome(entity.getValue());
		dto.setFascia(entity.getFascia());
		dto.setSesso(entity.getSesso());
		dto.setFrequenza(entity.getFrequenza());
		return dto;
	}
	
	public List<NomeDTO> toDTOs(List<Nome> entities) {
		if(CollectionUtils.isNotEmpty(entities)) {
			return entities.stream().map(this::toDTO).collect(Collectors.toList());
		}
		return Lists.newArrayList();
	}
	
	public Nome toEntity(NomeDTO dto) {
		throw new NotYetImplementedException();
	}
}
