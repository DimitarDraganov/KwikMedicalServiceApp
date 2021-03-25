package com.KwikMedicaldemo.service;

import java.util.List;

import com.KwikMedicaldemo.model.CalloutDetail;

public interface CalloutDetailService {
	//callout details service
	void saveCalloutDetail(CalloutDetail calloutDetail);
	CalloutDetail getCalloutDetailByRegisterNumber(Long id);
	List<CalloutDetail> getAllCalloutDetails();	
}
