package com.facchinil.manager;

import java.util.List;

import com.facchinil.dto.Frequenzable;
import com.facchinil.utils.FrequenzableUtils;

public interface FrequenzableRandomManager<T extends Frequenzable> {
	
	List<T> getDTOList();

	default T getRandom() {
		return FrequenzableUtils.getRandomElementFromList(getDTOList());
	}

}
