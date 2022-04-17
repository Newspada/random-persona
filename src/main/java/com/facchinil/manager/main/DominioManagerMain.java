package com.facchinil.manager.main;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.DominioDTO;
import com.facchinil.manager.DominioManager;
import com.facchinil.mapper.main.DominioMapper;
import com.facchinil.repository.DominioRepository;

@Component
public class DominioManagerMain implements DominioManager {
	
	@Autowired
	private DominioMapper dominioMapper;
	
	@Autowired
	private DominioRepository dominioRepository;
	
	private List<DominioDTO> domini;
	
	@PostConstruct
	private void onInit() {
		domini = dominioMapper.toDTOs(dominioRepository.findAll());
	}

	@Override
	public List<DominioDTO> getDTOList() {
		return domini;
	}

}
