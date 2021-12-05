package com.facchinil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.facchinil.entity.Indirizzo;

public interface IndirizzoRepository extends JpaRepository<Indirizzo, Long> {
	
	@Query("select i from Indirizzo i where i.comune.id = :id_comune and i.toponimo in (:toponimi)")
	List<Indirizzo> findByIdComuneAndToponimi(@Param("id_comune") Long idComune, @Param("toponimi") List<String> toponimi);
	
	@Query("select i from Indirizzo i where i.comune.id = :id_comune and i.toponimo = :toponimo")
	List<Indirizzo> findByIdComuneAndToponimo(@Param("id_comune") Long idComune, @Param("toponimo") String toponimo);

}
