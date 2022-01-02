package com.facchinil.manager.main;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.ComuneDTO;
import com.facchinil.entity.Comune;
import com.facchinil.manager.ComuneManager;
import com.facchinil.manager.GeolocManager;
import com.facchinil.mapper.main.ComuneMapper;
import com.facchinil.repository.ComuneRepository;
import com.facchinil.request.GeolocRequest;
import com.facchinil.utils.FrequenzableUtils;

@Component
public class ComuneManagerMain implements ComuneManager {
	
	@Autowired
	private ComuneMapper comuneMapper;
	
	@Autowired
	private ComuneRepository comuneRepository;
	
	@Autowired
	private GeolocManager geolocManager;
	
	private List<ComuneDTO> comuni;
	
	@PostConstruct
	private void onInit() {
		comuni = comuneMapper.toDTOs(comuneRepository.findAll());
        comuni.forEach(comune -> {
            StringBuilder cap = new StringBuilder(comune.getCap().replaceAll("[xX]", ""));
            Integer remainder = 5 - cap.length();
            for (int i = 0; i < remainder; i++)
                cap.append(ThreadLocalRandom.current().nextInt(10));
            comune.setCap(cap.toString());
        });
	}
	
	@Override
	public List<ComuneDTO> getDTOList() {
		return comuni;
	}
	
	@Override
	public ComuneDTO getById(Long id) {
		return comuni.stream().filter(c -> id.equals(c.getId())).findFirst().orElseThrow(() -> new IllegalStateException("Cannot find comune with id =" + id));
	}
	
	@Override
	public ComuneDTO getRandom() {
		return getRandom(true);
	}
	
	private ComuneDTO getRandom(boolean updateCoordinate) {
		ComuneDTO comune = ComuneManager.super.getRandom();
		if(updateCoordinate && comune.getCoordinate() == null) {
			comune.setCoordinate(geolocManager.getCoordinate(GeolocRequest.builder().idComune(comune.getId()).build()));
			Comune entity = comuneRepository.getById(comune.getId());
			entity.setLatitudine(comune.getCoordinate().getLatitudine().doubleValue());
			entity.setLongitudine(comune.getCoordinate().getLongitudine().doubleValue());
			comuneRepository.save(entity);
		}
		return comune;
	}

}
