package com.KwikMedicaldemo.service;

import java.util.List;

import com.KwikMedicaldemo.model.Caller;

public interface CallerService {
	//caller service
	List<Caller> getAllCallers();	
	void saveCaller(Caller caller);
	Caller getCallerById(long id);
	void deleteCallerById(long id);
}
