package com.facchinil.manager;

import com.facchinil.dto.NomeDTO;

public interface NomeManager extends FrequenzableRandomManager<NomeDTO>{

	NomeDTO getRandomByYear(Integer annoNascita);
	NomeDTO getRandomByYearAndSesso(Integer year, String sesso);
}
