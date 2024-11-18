package com.ustay.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ustay.project.entity.Inmueble;

@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble, Integer>{

	@Query(value = "SELECT * FROM inmueble WHERE disponibilidad=1", nativeQuery = true)
	List<Inmueble> findAllByAvailability();
	
}
