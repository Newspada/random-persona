package com.facchinil.manager.main;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.CognomeDTO;
import com.facchinil.manager.CognomeManager;
import com.facchinil.mapper.CognomeMapper;
import com.facchinil.repository.CognomeRepository;
import com.facchinil.utils.FrequenzableUtils;

@Component
public class CognomeManagerMain implements CognomeManager {

	@Autowired
	private CognomeMapper nomeMapper;

	@Autowired
	private CognomeRepository nomeRepository;

	private List<CognomeDTO> cognomi;

	@PostConstruct
	private void onInit() {
		cognomi = nomeMapper.toDTOs(nomeRepository.findAll());
		FrequenzableUtils.fillFrequenzaCumulativa(cognomi);
	}

	@Override
	public CognomeDTO getRandom() {
		return FrequenzableUtils.getRandomElementFromList(cognomi);
	}

}
