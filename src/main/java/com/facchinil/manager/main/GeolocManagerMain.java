package com.facchinil.manager.main;

import java.math.BigDecimal;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.facchinil.dto.ComuneDTO;
import com.facchinil.dto.CoordinateDTO;
import com.facchinil.http.entity.PositionStackRoot;
import com.facchinil.manager.GeolocManager;
import com.facchinil.mapper.main.ComuneMapper;
import com.facchinil.repository.ComuneRepository;
import com.facchinil.request.GeolocRequest;
import com.facchinil.utils.HttpUtils;

import lombok.SneakyThrows;

@Component
public class GeolocManagerMain implements GeolocManager {

    @Autowired
    private ComuneRepository comuneRepository;
    
    @Autowired
    private ComuneMapper comuneMapper;
    
    @Value("${positionstack.access.key}")
    private String positionstackAccessKey;
	
	@Override
	public CoordinateDTO getCoordinate(GeolocRequest request) {
		if(request.getIdComune() != null)
			return getCoordinateFromIdComune(request);
		throw new IllegalStateException();
	}

	private CoordinateDTO getCoordinateFromIdComune(GeolocRequest request) {
		Long idComune = request.getIdComune();
        ComuneDTO comune = comuneMapper.toDTO(comuneRepository.getById(idComune));
        return getCoordinateFromString(comune.getComune());
    }

    private CoordinateDTO getCoordinateFromString(String comune){
    	String url = getURL(comune);
        PositionStackRoot root = HttpUtils.getObject(url, PositionStackRoot.class);
        if(CollectionUtils.isEmpty(root.getData()))
        	return null;
        CoordinateDTO coordinate = new CoordinateDTO();
        coordinate.setLatitudine(BigDecimal.valueOf(root.getData().get(0).getLatitude()));
        coordinate.setLongitudine(BigDecimal.valueOf(root.getData().get(0).getLongitude()));
        return coordinate;
    }
    
    @SneakyThrows
    private String getURL(String... input) {
    	URIBuilder builder = new URIBuilder("http://api.positionstack.com/v1/forward");
    	builder.addParameter("access_key", positionstackAccessKey);
    	builder.addParameter("query", input[0]);
    	builder.addParameter("limit", "1");
    	return builder.build().toString();
    }

}
