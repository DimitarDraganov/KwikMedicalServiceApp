package com.KwikMedicaldemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.KwikMedicaldemo.model.Caller;
import com.KwikMedicaldemo.model.CalloutDetail;
import com.KwikMedicaldemo.model.ExistingPatient;
import com.KwikMedicaldemo.repository.CallerRepository;
//import com.KwikMedicaldemo.repository.ExistingPatientRepository;
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
	
	//@Autowired
	//private ExistingPatientRepository existingPatientRepository;
	
	// display list of callers
	
	
	Long lastRegisternum;
	
	
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
		
		
		lastRegisternum = longId;
		
		return "ambulance_dispatch";
	}
	
	
	
	@PostMapping("/sendAmbulance")
	public String sendAmbulance(@ModelAttribute("caller") Caller caller) {
		//save caller to database
		callerService.saveCaller(caller);
		return "redirect:/";
	}
	
	
//	@GetMapping("/showFormForUpdate/{id}")
//	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
//		
//		Caller caller = callerService.getCallerById(id);
//		
//		model.addAttribute("caller", caller);
//		return "update_caller_details";
//		
//	}
	
	
//	@PostMapping("/saveCallerDetails")
//	public String saveCaller(@ModelAttribute("caller") Caller caller) {
//		//save caller to database
//		callerService.saveCaller(caller);
//		return "redirect:/";
//	}
	
	
//	@GetMapping("/showFormForUpdate/{id}")
//	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
//		
//		Caller caller = callerService.getCallerById(id);
//				
//		model.addAttribute("callerNHSnum", caller.getRegisternum());
//		return "update_caller_details";		
//	}
	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
		
		Caller caller = callerService.getCallerById(id);
				
		model.addAttribute("callerNHSnum", caller.getRegisternum());
		return "update_caller_details";		
	}	
	
	
//	@GetMapping("/showFormForUpdates")
//	public String saveCaller(Model model) {
//		//save caller to database
//		CalloutDetail calloutDetail = new CalloutDetail();
//		model.addAttribute("callout", calloutDetail);
//		return "update_caller_details";	
//	}
	
	
	@GetMapping("/EnterCalloutDetails/{id}")
	public String EnterCalloutDetails(@PathVariable (value = "id") long registernum, Model model) {
		//save caller to database
		CalloutDetail calloutDetail = new CalloutDetail();
		
		//
		Long APIregisternum = registernum;
		calloutDetail.setRegisternum(APIregisternum.toString());
		//
		
		model.addAttribute("callout", calloutDetail);
		return "update_caller_details";	
	}
	
	
	
	
	
//	@PostMapping("/saveCallerDetails")
//	public String saveCallerDetails(@ModelAttribute("callerNHSnum") Caller caller, Model model) {
//		//save caller to database
//		callerService.saveCaller(caller);
//		return "redirect:/";
//	}
	
	
	@PostMapping("/saveCalloutDetails")
	public String saveCalloutDetails(@ModelAttribute("callout") CalloutDetail calloutDetail) {
		//save caller to database 
		
		//calloutDetail.setRegisternum(lastRegisternum.toString());
		
		calloutDetailService.saveCalloutDetail(calloutDetail);
		
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
