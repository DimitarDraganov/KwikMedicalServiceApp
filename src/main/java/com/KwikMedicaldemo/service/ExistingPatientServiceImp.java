package com.KwikMedicaldemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KwikMedicaldemo.model.ExistingPatient;
import com.KwikMedicaldemo.repository.ExistingPatientRepository;

@Service
public class ExistingPatientServiceImp implements ExistingPatientService{
	
	@Autowired
	private ExistingPatientRepository existingPatientRepository;

	@Override
	public ExistingPatient getExistingPatientById(long id) {
		Optional<ExistingPatient> optional = existingPatientRepository.findById(id);
		ExistingPatient existingPatient = null;
		if(optional.isPresent()) {
			existingPatient = optional.get();
		}else {
			throw new RuntimeException("Existing patient not found for id :: " + id);			
		}
		return existingPatient;
	}

}
