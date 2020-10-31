package com.KwikMedicaldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KwikMedicaldemo.model.ExistingPatient;

@Repository
public interface ExistingPatientRepository extends JpaRepository<ExistingPatient, Long> {

}
