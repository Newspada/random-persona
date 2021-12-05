package com.facchinil.manager.main;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facchinil.dto.ComuneDTO;
import com.facchinil.dto.IndirizzoDTO;
import com.facchinil.entity.Indirizzo;
import com.facchinil.manager.ComuneManager;
import com.facchinil.manager.IndirizzoManager;
import com.facchinil.mapper.main.IndirizzoMapper;
import com.facchinil.repository.IndirizzoRepository;
import com.facchinil.utils.FrequenzableUtils;

@Component
public class IndirizzoManagerMain implements IndirizzoManager {
	
	@Autowired
	private IndirizzoMapper indirizzoMapper;
	
	@Autowired
	private IndirizzoRepository indirizzoRepository;
	
	@Autowired
	private ComuneManager comuneManager;

	@Override
	public IndirizzoDTO getRandom(ComuneDTO comune) {
		String[] toponimi = {"Via", "Viale", "Vicolo", "Largo", "Corso", "Piazza", "Lungomare", "Piazzale", "Galleria"};
		List<Indirizzo> entities = indirizzoRepository.findByIdComuneAndToponimi(comune.getId(), Arrays.asList(toponimi));
		List<IndirizzoDTO> indirizzi = indirizzoMapper.toDTOs(entities);
		FrequenzableUtils.fillFrequenzaCumulativa(indirizzi);
		return FrequenzableUtils.getRandomElementFromList(indirizzi);
	}
	
	@Override
	public IndirizzoDTO getRandom(){
		ComuneDTO comune = null;
		IndirizzoDTO indirizzo = null;
		while(indirizzo == null){
			comune = comuneManager.getRandom();
			indirizzo = getRandom(comune);
		}
		return indirizzo;
	}

}
