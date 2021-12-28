package com.facchinil.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facchinil.dto.CoordinateDTO;
import com.facchinil.manager.GeolocManager;
import com.facchinil.request.GeolocRequest;

@CrossOrigin
@RestController
@RequestMapping("/api/geoloc")
public class GeolocController {

	@Autowired
	private GeolocManager geolocManager;
	
    @GetMapping("/comune")
    public CoordinateDTO getCoordinateFromIdComune(@RequestParam Long id) {
        return geolocManager.getCoordinate(GeolocRequest.builder().idComune(id).build());
    }
    
//    @GetMapping("/indirizzo")
//    public CoordinateDTO getCoordinateFromIdIndirizzo(@RequestParam Long id) {
//        return null;
//    }
}