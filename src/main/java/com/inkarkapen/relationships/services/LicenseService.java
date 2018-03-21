package com.inkarkapen.relationships.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.inkarkapen.relationships.models.License;
import com.inkarkapen.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private static LicenseRepository licenseRepository;
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public static List<License> allLicenses() {
		return licenseRepository.findAll();
	}
	
	public static void newLicense(@Valid License license) {
		licenseRepository.save(license);
	}
}
