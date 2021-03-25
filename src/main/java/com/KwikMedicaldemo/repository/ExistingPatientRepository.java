package com.KwikMedicaldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KwikMedicaldemo.model.ExistingPatient;

//existing patients interface extends JpaRepository
@Repository
public interface ExistingPatientRepository extends JpaRepository<ExistingPatient, Long> {

}
