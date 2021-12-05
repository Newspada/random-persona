package com.facchinil.manager;

import com.facchinil.dto.ComuneDTO;
import com.facchinil.dto.IndirizzoDTO;

public interface IndirizzoManager {
	
	IndirizzoDTO getRandom(ComuneDTO comune);
	IndirizzoDTO getRandom();
}
