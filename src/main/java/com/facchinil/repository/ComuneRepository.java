package com.facchinil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facchinil.entity.Comune;

public interface ComuneRepository extends JpaRepository<Comune, Long> {

}
