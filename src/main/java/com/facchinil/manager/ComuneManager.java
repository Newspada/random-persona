package com.facchinil.manager;

import com.facchinil.dto.ComuneDTO;

public interface ComuneManager {
	
	ComuneDTO getById(Long id);
	ComuneDTO getRandom();
}
