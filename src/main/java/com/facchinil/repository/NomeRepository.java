package com.facchinil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facchinil.entity.Nome;

public interface NomeRepository extends JpaRepository<Nome, Long> {

}
