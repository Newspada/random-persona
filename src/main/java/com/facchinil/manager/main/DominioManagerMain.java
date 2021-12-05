package com.facchinil.manager.main;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.DominioDTO;
import com.facchinil.manager.DominioManager;
import com.facchinil.mapper.DominioMapper;
import com.facchinil.repository.DominioRepository;
import com.facchinil.utils.FrequenzableUtils;

@Component
public class DominioManagerMain implements DominioManager {
	
	@Autowired
	private DominioMapper dominioMapper;
	
	@Autowired
	private DominioRepository domineRepository;
	
	private List<DominioDTO> domini;
	
	@PostConstruct
	private void onInit() {
		domini = dominioMapper.toDTOs(domineRepository.findAll());
		FrequenzableUtils.fillFrequenzaCumulativa(domini);
	}
	
	@Override
	public DominioDTO getRandom() {
		return FrequenzableUtils.getRandomElementFromList(domini);
	}

}
