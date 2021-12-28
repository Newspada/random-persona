package com.facchinil.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeolocRequest {
	private Long idComune;
}
