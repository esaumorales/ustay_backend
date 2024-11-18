package com.ustay.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustay.project.entity.Edificio;
@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Integer> {

}