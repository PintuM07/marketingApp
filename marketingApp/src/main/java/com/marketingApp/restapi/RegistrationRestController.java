package com.marketingApp.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingApp.entity.Registration;
import com.marketingApp.repository.RegistrationRepository;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationRestController {

	@Autowired
	private RegistrationRepository registrationRepo;
	
	// http://localhost:8080/api/registrations
	@GetMapping
	public List<Registration> getAllReg(){
		
		List<Registration> reg = registrationRepo.findAll();
		return reg;
	}
	
	@PostMapping
	public void saveRegisrattion(@RequestBody Registration registration) {
		
		registrationRepo.save(registration);
		
	}
	
	// http://localhost:8080/api/registrations/15
	@DeleteMapping("/{id}")
	public void deleteRegistration(long id) {
		
	}
}
