package com.KwikMedicaldemo.service;

import java.util.List;

import com.KwikMedicaldemo.model.Caller;

public interface CallerService {
	List<Caller> getAllCallers();	
	void saveCaller(Caller caller);
}
