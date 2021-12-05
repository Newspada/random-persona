package com.facchinil.manager.main;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.ComuneDTO;
import com.facchinil.manager.ComuneManager;
import com.facchinil.mapper.main.ComuneMapper;
import com.facchinil.repository.ComuneRepository;
import com.facchinil.utils.FrequenzableUtils;

@Component
public class ComuneManagerMain implements ComuneManager {
	
	@Autowired
	private ComuneMapper comuneMapper;
	
	@Autowired
	private ComuneRepository comuneRepository;
	
	private List<ComuneDTO> comuni;
	
	@PostConstruct
	private void onInit() {
		comuni = comuneMapper.toDTOs(comuneRepository.findAll());
		FrequenzableUtils.fillFrequenzaCumulativa(comuni);
	}
	
	@Override
	public ComuneDTO getById(Long id) {
		return comuneMapper.toDTO(comuneRepository.getById(id));
	}
	
	@Override
	public ComuneDTO getRandom() {
		return FrequenzableUtils.getRandomElementFromList(comuni);
	}

}
