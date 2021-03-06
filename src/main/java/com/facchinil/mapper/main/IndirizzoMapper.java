package com.facchinil.mapper.main;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.IndirizzoDTO;
import com.facchinil.entity.Indirizzo;
import com.facchinil.mapper.Mapper;
import com.google.common.collect.Lists;

@Component
public class IndirizzoMapper implements Mapper<IndirizzoDTO, Indirizzo> {
	
	@Autowired
	private ComuneMapper comuneMapper;
	
	public IndirizzoDTO toDTO(Indirizzo entity) {
		IndirizzoDTO dto = new IndirizzoDTO();
		dto.setToponimo(entity.getToponimo());
		dto.setDenominazione(entity.getDenominazione());
		dto.setFrequenza(entity.getFrequenza());
		dto.setComune(comuneMapper.toDTO(entity.getComune()));
		return dto;
	}
	
	public List<IndirizzoDTO> toDTOs(List<Indirizzo> entities) {
		if(CollectionUtils.isNotEmpty(entities)) {
			return entities.stream().map(this::toDTO).collect(Collectors.toList());
		}
		return Lists.newArrayList();
	}
	
	public Indirizzo toEntity(IndirizzoDTO dto) {
		throw new NotYetImplementedException();
	}
}
