package com.facchinil.mapper;

public interface Mapper<A, B> {
	A toDTO(B entity);
	B toEntity (A dto);
}
