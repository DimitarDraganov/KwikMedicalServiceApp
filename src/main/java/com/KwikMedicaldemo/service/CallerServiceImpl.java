package com.KwikMedicaldemo.service;

import java.util.List;

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
		return callerRepository.findAll();
	}

	@Override
	public void saveCaller(Caller caller) {
		// TODO Auto-generated method stub
		this.callerRepository.save(caller);
	}

	

}
