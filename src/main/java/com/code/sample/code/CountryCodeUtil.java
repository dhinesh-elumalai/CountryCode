package com.code.sample.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class CountryCodeUtil {

	private static PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
	
	public static List<Country> getCountryListWithCodes() {
		
		    Set<String> countryCodes = phoneUtil.getSupportedRegions();
		    List<Country> countryList = new ArrayList<>();
		    for (String code : countryCodes) {
		    	Locale locale = new Locale("en",code);
				countryList.add(new Country(locale.getDisplayCountry(), code, phoneUtil.getCountryCodeForRegion(code)));
		    }
		    Collections.sort(countryList);
		    return countryList;
	}
		
	public static boolean isValidPhoneNumber(String phoneNum) {
		try {
			PhoneNumber phone= phoneUtil.parse(phoneNum, "");
			return phoneUtil.isValidNumber(phone);
		} catch (NumberParseException e) {
			System.out.println("The country code is Invalid");
		} 
		return false;
	}
	
	public static int getCountryCode(String phoneNum) {
		try {
			PhoneNumber phone= phoneUtil.parse(phoneNum, "");
			return phone.getCountryCode();
		} catch (NumberParseException e) {
			System.out.println("The country code is Invalid");
		} 
		return -1;
	}
	
}
