package com.facchinil.manager.main;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.FasciaEtaDTO;
import com.facchinil.manager.FasciaEtaManager;
import com.facchinil.mapper.main.FasciaEtaMapper;
import com.facchinil.repository.FasciaEtaRepository;
import com.facchinil.utils.FrequenzableUtils;

@Component
public class FasciaEtaManagerMain implements FasciaEtaManager {
	
	@Autowired
	private FasciaEtaMapper dominioMapper;
	
	@Autowired
	private FasciaEtaRepository fasceRepository;
	
	private List<FasciaEtaDTO> fasce;
	
	@PostConstruct
	private void onInit() {
		fasce = dominioMapper.toDTOs(fasceRepository.findAll());
		FrequenzableUtils.fillFrequenzaCumulativa(fasce);
	}
	
	@Override
	public FasciaEtaDTO getRandom() {
		return FrequenzableUtils.getRandomElementFromList(fasce);
	}

}
