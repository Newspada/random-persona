package com.facchinil.manager;

import com.facchinil.dto.NomeDTO;

public interface NomeManager {
	
	NomeDTO getRandom();

	NomeDTO getRandomByYear(Integer annoNascita);
}
