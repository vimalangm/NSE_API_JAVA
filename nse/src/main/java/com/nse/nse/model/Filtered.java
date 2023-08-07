package com.nse.nse.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Filtered {
	public ArrayList<Datum> data;
	@JsonProperty("CE")
	public CE cE;
	@JsonProperty("PE")
	public PE pE;
	public Filtered() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Filtered(ArrayList<Datum> data, CE cE, PE pE) {
		super();
		this.data = data;
		this.cE = cE;
		this.pE = pE;
	}
	public ArrayList<Datum> getData() {
		return data;
	}
	public void setData(ArrayList<Datum> data) {
		this.data = data;
	}
	public CE getcE() {
		return cE;
	}
	public void setcE(CE cE) {
		this.cE = cE;
	}
	public PE getpE() {
		return pE;
	}
	public void setpE(PE pE) {
		this.pE = pE;
	}
	@Override
	public String toString() {
		return "Filtered [data=" + data + ", cE=" + cE + ", pE=" + pE + "]";
	}
	
}
