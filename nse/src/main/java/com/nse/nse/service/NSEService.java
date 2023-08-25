package com.nse.nse.service;

import java.io.FileNotFoundException;

public interface NSEService {
	String baseUrl = "https://www.nseindia.com";

	public String getNseNiftyData() throws Exception;

	public String generateNseDataExcel() throws FileNotFoundException;
}
