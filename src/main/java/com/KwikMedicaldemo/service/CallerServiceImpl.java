package com.KwikMedicaldemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KwikMedicaldemo.model.Caller;

import com.KwikMedicaldemo.repository.CallerRepository;

@Service
public class CallerServiceImpl implements CallerService{

	@Autowired
	private CallerRepository callerRepository;
	
	
	@Override
	public List<Caller> getAllCallers() {
		//get all callers in the database
		return callerRepository.findAll();
	}

	@Override
	public void saveCaller(Caller caller) {
		//save a caller to the database
		this.callerRepository.save(caller);
	}

	@Override
	public Caller getCallerById(long id) {
		//find specific caller by Id
		Optional<Caller> optional = callerRepository.findById(id);
		Caller caller = null;
		if(optional.isPresent()) {
			caller = optional.get();
		}else {
			throw new RuntimeException(" Caller not found, id :: " + id);
		}
		return caller;
	}

	@Override
	public void deleteCallerById(long id) {
		//delete a specific caller by Id
		this.callerRepository.deleteById(id);		
	}

	

}
