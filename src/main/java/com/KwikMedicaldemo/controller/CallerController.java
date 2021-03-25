package com.KwikMedicaldemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.KwikMedicaldemo.model.Caller;
import com.KwikMedicaldemo.model.CalloutDetail;
import com.KwikMedicaldemo.model.ExistingPatient;
import com.KwikMedicaldemo.repository.CallerRepository;
import com.KwikMedicaldemo.service.CallerService;
import com.KwikMedicaldemo.service.CalloutDetailService;
import com.KwikMedicaldemo.service.ExistingPatientService;

@Controller
public class CallerController {

	@Autowired
	private CallerService callerService;
	
	@Autowired
	private CalloutDetailService calloutDetailService;
	
	
	@Autowired
	private ExistingPatientService existingPatientService;
	
	
	@Autowired
	private CallerRepository callerRepository;
	
	@GetMapping("/")
	public String viewHomepage(Model model) {
		//Redirect too application homepage
		model.addAttribute("listCallers", callerService.getAllCallers());
		return "index";
	}	
	
	@GetMapping("/displayRegisteredCallers")
	public String displayRegisteredCallers(Model model) {
		//get all registered caller and output to display page
		
		model.addAttribute("listCallers", callerService.getAllCallers());
		return "display_registered_callers";
	}
	
	
	@GetMapping("/deleteCaller/{id}")
	public String DeleteCaller(@PathVariable (value = "id") long id, Model model) {
		//delete caller details by Id
		
		this.callerService.deleteCallerById(id);		
		model.addAttribute("listCallers", callerService.getAllCallers());
				return "display_registered_callers";
	}
	
	
	
	
	@GetMapping("/registerNewCallerForm")
	public String registerNewCallerForm(Model model) {
		//register new caller
		
		Caller caller = new Caller();		
		model.addAttribute("caller", caller);		
		return "register_caller";
	}
	

	@PostMapping("/saveCaller")
	public String saveCaller(@ModelAttribute("caller") Caller caller, Model model) {
		//save caller to database
		
		callerService.saveCaller(caller);		
		model.addAttribute("listCallerDetails", caller);					
		String callerId = caller.getRegisternum();		
		Long longId=Long.valueOf(callerId);
		
				
		model.addAttribute("listCallerMedDetails", longId);			
		model.addAttribute("existingMedDetails", existingPatientService.getExistingPatientById(longId));
			
		
		String callerAddress = caller.getAddress();		
		callerAddress = callerAddress.replaceAll("\\D+","");		
		model.addAttribute("receivingHospital", callerAddress);
				
		return "ambulance_dispatch";
	}
	
	
	
	@PostMapping("/sendAmbulance")
	public String sendAmbulance(@ModelAttribute("caller") Caller caller) {
		//save caller to database
		callerService.saveCaller(caller);
		return "redirect:/";
	}	

	
	@GetMapping("/EnterCalloutDetails/{id}")
	public String EnterCalloutDetails(@PathVariable (value = "id") long registernum, Model model) {
		//get caller details
		CalloutDetail calloutDetail = new CalloutDetail();
		
		Long APIregisternum = registernum;
		calloutDetail.setRegisternum(APIregisternum.toString());
		
		model.addAttribute("callout", calloutDetail);
		return "update_caller_details";	
	}
	

	@PostMapping("/saveCalloutDetails")
	public String saveCalloutDetails(@ModelAttribute("callout") CalloutDetail calloutDetail) {
		//save caller to database 				
		calloutDetailService.saveCalloutDetail(calloutDetail);
		
		return "redirect:/";
	}
	
	
}
