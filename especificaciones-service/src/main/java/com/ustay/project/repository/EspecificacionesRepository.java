package com.ustay.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustay.project.entity.Especificaciones;

@Repository
public interface EspecificacionesRepository extends JpaRepository<Especificaciones, Integer>{

}
