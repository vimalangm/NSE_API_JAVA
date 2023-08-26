package com.nse.nse.model;

import java.util.ArrayList;

public class RecordsBankNifty {
	public ArrayList<String> expiryDates;
	public ArrayList<Datum> data;
	public String timestamp;
	public double underlyingValue;
	public ArrayList<Integer> strikePrices;
	public Index index;

	public RecordsBankNifty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecordsBankNifty(ArrayList<String> expiryDates, ArrayList<Datum> data, String timestamp,
			double underlyingValue, ArrayList<Integer> strikePrices, Index index) {
		super();
		this.expiryDates = expiryDates;
		this.data = data;
		this.timestamp = timestamp;
		this.underlyingValue = underlyingValue;
		this.strikePrices = strikePrices;
		this.index = index;
	}

	public ArrayList<String> getExpiryDates() {
		return expiryDates;
	}

	public void setExpiryDates(ArrayList<String> expiryDates) {
		this.expiryDates = expiryDates;
	}

	public ArrayList<Datum> getData() {
		return data;
	}

	public void setData(ArrayList<Datum> data) {
		this.data = data;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public double getUnderlyingValue() {
		return underlyingValue;
	}

	public void setUnderlyingValue(double underlyingValue) {
		this.underlyingValue = underlyingValue;
	}

	public ArrayList<Integer> getStrikePrices() {
		return strikePrices;
	}

	public void setStrikePrices(ArrayList<Integer> strikePrices) {
		this.strikePrices = strikePrices;
	}

	public Index getIndex() {
		return index;
	}

	public void setIndex(Index index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "RecordsBankNifty [expiryDates=" + expiryDates + ", data=" + data + ", timestamp=" + timestamp
				+ ", underlyingValue=" + underlyingValue + ", strikePrices=" + strikePrices + ", index=" + index + "]";
	}

}
