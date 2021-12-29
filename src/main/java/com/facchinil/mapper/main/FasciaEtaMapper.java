package com.facchinil.mapper.main;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;

import com.facchinil.dto.FasciaEtaDTO;
import com.facchinil.entity.FasciaEta;
import com.facchinil.mapper.Mapper;

@Component
public class FasciaEtaMapper implements Mapper<FasciaEtaDTO, FasciaEta> {
	
	@Override
	public FasciaEtaDTO toDTO(FasciaEta entity) {
		FasciaEtaDTO dto = new FasciaEtaDTO();
		dto.setFascia(entity.getFascia());
		dto.setFrequenzaMaschi(entity.getFrequenzaMaschi());
		dto.setFrequenzaFemmine(entity.getFrequenzaFemmine());
		dto.setFrequenza(entity.getFrequenzaTotale());
		return dto;
	}
	
	@Override
	public FasciaEta toEntity(FasciaEtaDTO dto) {
		throw new NotYetImplementedException();
	}
}
