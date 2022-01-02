package com.facchinil.manager;

import com.facchinil.dto.ComuneDTO;

public interface ComuneManager extends FrequenzableRandomManager<ComuneDTO>{
	
	ComuneDTO getById(Long id);
}
