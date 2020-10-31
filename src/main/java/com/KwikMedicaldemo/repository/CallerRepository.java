package com.KwikMedicaldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KwikMedicaldemo.model.Caller;

@Repository
public interface CallerRepository extends JpaRepository<Caller, Long>{

}
