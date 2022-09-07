package com.code.sample.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.code.sample.code.Country;
import com.code.sample.code.CountryCodeUtil;
import com.code.sample.code.Phone;

@RestController
public class CountryController {

	@GetMapping("/countries")
	public ResponseEntity<List<Country>> getCountryList() {
		List<Country> countryList = CountryCodeUtil.getCountryListWithCodes();
		return new ResponseEntity<>(countryList, HttpStatus.OK);
	}
	
	@PostMapping("/verifyPhone")
	public ResponseEntity<String> verifyPhone(@RequestBody Phone phone) {
		boolean isValid = CountryCodeUtil.isValidPhoneNumber(phone.getPhoneNumber());
		if(isValid) {
			return new ResponseEntity<>("Country is Valid", HttpStatus.OK);
		}
		return new ResponseEntity<>("Country is Not Valid", HttpStatus.BAD_REQUEST);
	}
	
}
