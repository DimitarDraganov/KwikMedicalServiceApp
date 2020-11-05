package com.KwikMedicaldemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KwikMedicaldemo.model.CalloutDetail;
import com.KwikMedicaldemo.repository.CalloutDetailRepository;

@Service
public class CalloutDetailServiceIml implements CalloutDetailService{

	@Autowired
	private CalloutDetailRepository calloutDetailRepository;

	@Override
	public void saveCalloutDetail(CalloutDetail calloutDetail) {
		// TODO Auto-generated method stub
		this.calloutDetailRepository.save(calloutDetail);		
	}
	
}
