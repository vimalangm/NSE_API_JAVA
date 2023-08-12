package com.nse.nse.service;

public interface NSEService {
	String baseUrl = "https://www.nseindia.com";
	public String getNseData() throws Exception;
}
