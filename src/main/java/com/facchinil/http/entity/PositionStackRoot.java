package com.facchinil.http.entity;

import java.util.List;

import lombok.Data;

@Data
public class PositionStackRoot {
	private List<PositionStackData> data;
}
