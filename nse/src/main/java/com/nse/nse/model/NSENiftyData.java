package com.nse.nse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NSENiftyData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "created_date")
	private String createdDate;
	@Column(name = "created_time")
	private String createdTime;
	@Column(name = "underlying_value")
	private double underlyingValue;
	private double ce;
	private double pe;
	private double pcr;
	@Column(name = "nearest_actual_value")
	private double nearestValue;
	@Column(name = "valid_expiry_date")
	private String validExpiryDate;
	private String symbol;

	public NSENiftyData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NSENiftyData(long id, String createdDate, String createdTime, double underlyingValue, double ce, double pe,
			double pcr, double nearestValue, String validExpiryDate, String symbol) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.createdTime = createdTime;
		this.underlyingValue = underlyingValue;
		this.ce = ce;
		this.pe = pe;
		this.pcr = pcr;
		this.nearestValue = nearestValue;
		this.validExpiryDate = validExpiryDate;
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public double getUnderlyingValue() {
		return underlyingValue;
	}

	public void setUnderlyingValue(double underlyingValue) {
		this.underlyingValue = underlyingValue;
	}

	public double getCe() {
		return ce;
	}

	public void setCe(double ce) {
		this.ce = ce;
	}

	public double getPe() {
		return pe;
	}

	public void setPe(double pe) {
		this.pe = pe;
	}

	public double getPcr() {
		return pcr;
	}

	public void setPcr(double pcr) {
		this.pcr = pcr;
	}

	public double getNearestValue() {
		return nearestValue;
	}

	public void setNearestValue(double nearestValue) {
		this.nearestValue = nearestValue;
	}

	public String getValidExpiryDate() {
		return validExpiryDate;
	}

	public void setValidExpiryDate(String validExpiryDate) {
		this.validExpiryDate = validExpiryDate;
	}

	@Override
	public String toString() {

		StringBuilder dataBuilder = new StringBuilder();
		appendFieldValue(dataBuilder, String.valueOf(id));
		appendFieldValue(dataBuilder, getCreatedDate());
		appendFieldValue(dataBuilder, getCreatedTime());
		appendFieldValue(dataBuilder, String.valueOf(underlyingValue));
		appendFieldValue(dataBuilder, String.valueOf(ce));
		appendFieldValue(dataBuilder, String.valueOf(pe));
		appendFieldValue(dataBuilder, String.valueOf(pcr));
		appendFieldValue(dataBuilder, String.valueOf(nearestValue));
		appendFieldValue(dataBuilder, String.valueOf(validExpiryDate));
		appendFieldValue(dataBuilder, symbol);
		return dataBuilder.toString();
	}

	private void appendFieldValue(StringBuilder dataBuilder, String fieldValue) {
		if (fieldValue != null) {
			dataBuilder.append(fieldValue).append(",");
		} else {
			dataBuilder.append("").append(",");
		}
	}

}
