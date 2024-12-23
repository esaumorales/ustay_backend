package com.ustay.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ustay.project.entity.Partner;


@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {

}