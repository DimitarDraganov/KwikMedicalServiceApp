package com.KwikMedicaldemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KwikMedicaldemo.model.Caller;
import com.KwikMedicaldemo.model.CalloutDetail;
import com.KwikMedicaldemo.repository.CalloutDetailRepository;

@Service
public class CalloutDetailServiceIml implements CalloutDetailService{

	@Autowired
	private CalloutDetailRepository calloutDetailRepository;

	@Override
	public void saveCalloutDetail(CalloutDetail calloutDetail) {
		//save callout details
		this.calloutDetailRepository.save(calloutDetail);		
	}

	@Override
	public CalloutDetail getCalloutDetailByRegisterNumber(Long id) {
		//get specific callout details
		Optional<CalloutDetail> optional = calloutDetailRepository.findById(id);
		CalloutDetail calloutDetail = null;
		if(optional.isPresent()) {
			calloutDetail = optional.get();
		}else {
			throw new RuntimeException(" Callout details not found, id :: " + id);
		}	
		return calloutDetail;
	}

	@Override
	public List<CalloutDetail> getAllCalloutDetails() {
		//get callout details of all patients
		return calloutDetailRepository.findAll();
	}
	
}
