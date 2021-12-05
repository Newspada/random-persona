package com.facchinil.mapper.main;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;

import com.facchinil.dto.DominioDTO;
import com.facchinil.entity.Dominio;
import com.facchinil.mapper.Mapper;
import com.google.common.collect.Lists;

@Component
public class DominioMapper implements Mapper<DominioDTO, Dominio> {
	
	public DominioDTO toDTO(Dominio entity) {
		DominioDTO dto = new DominioDTO();
		dto.setDominio(entity.getValue());
		dto.setFrequenza(entity.getFrequenza());
		return dto;
	}
	
	public List<DominioDTO> toDTOs(List<Dominio> entities) {
		if(CollectionUtils.isNotEmpty(entities)) {
			return entities.stream().map(this::toDTO).collect(Collectors.toList());
		}
		return Lists.newArrayList();
	}
	
	public Dominio toEntity(DominioDTO dto) {
		throw new NotYetImplementedException();
	}
}
