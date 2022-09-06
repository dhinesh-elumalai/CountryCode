package com.code.sample.code;

public class Country implements Comparable<Country>{

	private String name;
	private String code;
	private int phoneCode;
	
	public Country(String name, String code, int phoneCode) {
		super();
		this.name = name;
		this.code = code;
		this.phoneCode = phoneCode;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(int phoneCode) {
		this.phoneCode = phoneCode;
	}
	public Country() {
		super();
	}

	@Override
	public int compareTo(Country countryObj) {
		if(this.name.equals(countryObj.name)) {
			return this.phoneCode-countryObj.phoneCode;
		}
		return this.name.compareTo(countryObj.getName());
	}
	
}
