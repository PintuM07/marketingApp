package com.marketingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingApp.entity.Registration;
import com.marketingApp.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepo;
	
	public void saveRegistration(Registration registration) {
	registrationRepo.save(registration);
	}

	public List<Registration> getAllregistrations() {
		List<Registration> registrations = registrationRepo.findAll();
		return registrations;
	}

	public void deleteLead(Long id) {
		registrationRepo.deleteById(id);
		
	}

	public Registration getRegistrationById(Long id) {
	Optional<Registration> findById = registrationRepo.findById(id);
		return findById.get();
	}

	public void saveUpdatedREgistration(Registration reg) {
		registrationRepo.save(reg);
		
	}

	public Registration findByEmail(String email) {
		return registrationRepo.findByEmail(email);
	}


}
