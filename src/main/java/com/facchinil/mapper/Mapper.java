package com.facchinil.mapper;

import com.facchinil.dto.DataTransferObject;

public interface Mapper<A extends DataTransferObject, B> {
	A toDTO(B entity);
	B toEntity (A dto);
}
