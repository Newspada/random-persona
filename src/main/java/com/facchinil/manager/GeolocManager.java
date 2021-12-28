package com.facchinil.manager;

import com.facchinil.dto.CoordinateDTO;
import com.facchinil.request.GeolocRequest;

public interface GeolocManager {
	
	CoordinateDTO getCoordinate(GeolocRequest request);
}
