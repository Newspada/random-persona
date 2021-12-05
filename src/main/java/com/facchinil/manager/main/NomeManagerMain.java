package com.facchinil.manager.main;

import java.time.Year;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.NomeDTO;
import com.facchinil.manager.NomeManager;
import com.facchinil.mapper.main.NomeMapper;
import com.facchinil.repository.NomeRepository;
import com.facchinil.utils.FrequenzableUtils;

@Component
public class NomeManagerMain implements NomeManager {
	
	@Autowired
	private NomeMapper nomeMapper;
	
	@Autowired
	private NomeRepository nomeRepository;
	
	private List<NomeDTO> nomi;
	
	@PostConstruct
	private void onInit() {
		nomi = nomeMapper.toDTOs(nomeRepository.findAll());
		FrequenzableUtils.fillFrequenzaCumulativa(nomi);
	}
	
	@Override
	public NomeDTO getRandom() {
		return FrequenzableUtils.getRandomElementFromList(nomi);
	}
	
	@Override
	public NomeDTO getRandomByYear(Integer annoNascita) {
		int eta = Year.now().getValue() - annoNascita;
		int classeEta = eta/10;
		List<NomeDTO> nomiFilteredByEta = this.nomi.stream()
				.filter(n -> n.getFascia() == classeEta)
				.toList();
		return FrequenzableUtils.getRandomElementFromList(nomiFilteredByEta);
	}

}
