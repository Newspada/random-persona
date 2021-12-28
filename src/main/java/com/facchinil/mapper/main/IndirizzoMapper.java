package com.facchinil.mapper.main;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.IndirizzoDTO;
import com.facchinil.entity.Indirizzo;
import com.facchinil.manager.ComuneManager;
import com.facchinil.mapper.Mapper;

@Component
public class IndirizzoMapper implements Mapper<IndirizzoDTO, Indirizzo> {
	
	@Autowired
	private ComuneManager comuneManager;
	
	@Override
	public IndirizzoDTO toDTO(Indirizzo entity) {
		IndirizzoDTO dto = new IndirizzoDTO();
		dto.setToponimo(entity.getToponimo());
		dto.setDenominazione(entity.getDenominazione());
		dto.setFrequenza(entity.getFrequenza());
		dto.setComune(comuneManager.getById(entity.getComune().getId()));
		return dto;
	}
	
	@Override
	public Indirizzo toEntity(IndirizzoDTO dto) {
		throw new NotYetImplementedException();
	}
}
