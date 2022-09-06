package com.code.sample.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.sample.code.Country;
import com.code.sample.code.CountryCodeUtil;

@RestController
public class CountryController {

	@GetMapping("/countries")
	public ResponseEntity<List<Country>> getCountryList() {
		List<Country> countryList = CountryCodeUtil.getCountryListWithCodes();
		return new ResponseEntity<>(countryList, HttpStatus.OK);
	}
	
}
