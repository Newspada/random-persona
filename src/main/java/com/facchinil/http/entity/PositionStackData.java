package com.facchinil.http.entity;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class PositionStackData {
	private double latitude;
    private double longitude;
    private String type;
    private String name;
    //private Object number;
    //private Object postal_code;
    //private Object street;
    private double confidence;
    private String region;
    @SerializedName("region_code")
    private String regionCode;
    //private Object county;
    private String locality;
    @SerializedName("administrative_area")
    private String administrativeArea;
    //private Object neighbourhood;
    private String country;
    @SerializedName("country_code")
    private String countryCode;
    private String continent;
    private String label;
}
