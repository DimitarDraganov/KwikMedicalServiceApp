package com.KwikMedicaldemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KwikMedicaldemo.model.CalloutDetail;

@Repository
public interface CalloutDetailRepository extends JpaRepository<CalloutDetail, Long>{

}
