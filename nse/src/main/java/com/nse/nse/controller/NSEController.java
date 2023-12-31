package com.nse.nse.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nse.nse.service.NSEService;

@CrossOrigin(origins = "https://www.nseindia.com/api/option-chain-indices?symbol=NIFTY")
@RestController
@RequestMapping(value = "nse/indices")
public class NSEController {

	@Autowired
	NSEService nseService;

	@GetMapping("/api")
	public String getNseNiftyData() throws Exception {

		return nseService.getNseNiftyData();

	}
	@GetMapping("/generate")
	public String generateCsv() throws FileNotFoundException {
		return nseService.generateNseDataExcel();
	}

}
