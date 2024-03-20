package com.marketingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingApp.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

	Registration findByEmail(String email);

}
