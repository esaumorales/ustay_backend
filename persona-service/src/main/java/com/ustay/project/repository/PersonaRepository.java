package com.ustay.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ustay.project.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}