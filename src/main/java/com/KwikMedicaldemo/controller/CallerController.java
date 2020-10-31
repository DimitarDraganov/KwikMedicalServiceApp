package com.KwikMedicaldemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.KwikMedicaldemo.model.Caller;
import com.KwikMedicaldemo.model.ExistingPatient;
import com.KwikMedicaldemo.repository.CallerRepository;
//import com.KwikMedicaldemo.repository.ExistingPatientRepository;
import com.KwikMedicaldemo.service.CallerService;
import com.KwikMedicaldemo.service.ExistingPatientService;

@Controller
public class CallerController {

	
	@Autowired
	private CallerService callerService;
	
	
	@Autowired
	private ExistingPatientService existingPatientService;
	
	
	@Autowired
	private CallerRepository callerRepository;
	
	//@Autowired
	//private ExistingPatientRepository existingPatientRepository;
	
	// display list of callers
	
	@GetMapping("/")
	public String viewHomepage(Model model) {
		model.addAttribute("listCallers", callerService.getAllCallers());
		return "index";
	}
	
	@GetMapping("/registerNewCallerForm")
	public String registerNewCallerForm(Model model) {
		Caller caller = new Caller();
		model.addAttribute("caller", caller);
		return "register_caller";
	}
	
//	@PostMapping("/saveCaller")
//	public String saveCaller(@ModelAttribute("caller") Caller caller) {
//		//save caller to database
//		callerService.saveCaller(caller);
//		return "redirect:/";
//	}
	
	@PostMapping("/saveCaller")
	public String saveCaller(@ModelAttribute("caller") Caller caller, Model model) {
		//save caller to database
		callerService.saveCaller(caller);
		
		model.addAttribute("listCallerDetails", caller);
				
		String callerId = caller.getRegisternum();
		
		Long longId=Long.valueOf(callerId);
		
		//existingPatientRepository.findById(longId);
				
		model.addAttribute("listCallerMedDetails", longId);
		
		
		model.addAttribute("existingMedDetails", existingPatientService.getExistingPatientById(longId));
		
		
		return "ambulance_dispatch";
	}
	
	
	@PostMapping("/sendAmbulance")
	public String sendAmbulance(@ModelAttribute("caller") Caller caller) {
		//save caller to database
		callerService.saveCaller(caller);
		return "redirect:/";
	}
	
	
	
	
//	@PostMapping("/saveCaller")
//	public String saveCaller(@ModelAttribute("caller") Caller caller) {
//		//save caller to database
//		callerRepository.save(caller);
//		return "redirect:/";
//	}
	
	
//	@PostMapping(path = "/saveCaller", produces = "application/JSON")
//	public String saveCaller(@ModelAttribute("caller") Caller caller) {
//		callerRepository.save(caller);
//		return "redirect:/";
//	}
	
	
}
