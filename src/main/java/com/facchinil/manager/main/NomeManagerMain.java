package com.facchinil.manager.main;

import java.time.Year;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
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
	}
	
	@Override
	public List<NomeDTO> getDTOList() {
		return nomi;
	}
	
	@Override
	public NomeDTO getRandomByYear(Integer year) {
		return getRandomByYearAndSesso(year, null);
	}

	@Override
	public NomeDTO getRandomByYearAndSesso(Integer year, String sesso) {
		int eta = Year.now().getValue() - year;
		List<NomeDTO> nomiFilteredByEta = this.nomi.stream()
				.filter(n -> {
					String[] parts = n.getFascia().split("-");
					Integer etaMin = Integer.parseInt(parts[0]);
					Integer etaMax = Integer.parseInt(parts[1]);
					if(StringUtils.isBlank(sesso))
						return eta >= etaMin && eta <= etaMax;
					return eta >= etaMin && eta <= etaMax && sesso.equals(n.getSesso());
				})
				.toList();
		return FrequenzableUtils.getRandomElementFromList(nomiFilteredByEta);
	}

}
