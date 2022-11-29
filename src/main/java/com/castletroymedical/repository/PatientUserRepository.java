package com.castletroymedical.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.castletroymedical.entity.PatientUserEntity;

public interface PatientUserRepository extends JpaRepository<PatientUserEntity, Long>{
    
}
