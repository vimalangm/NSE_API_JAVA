package com.nse.nse.model;

public class RootNifty{
    public RecordsNifty records;
    public Filtered filtered;
    
	public RootNifty() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RootNifty(RecordsNifty records, Filtered filtered) {
		super();
		this.records = records;
		this.filtered = filtered;
	}

	public RecordsNifty getRecords() {
		return records;
	}
	public void setRecords(RecordsNifty records) {
		this.records = records;
	}
	public Filtered getFiltered() {
		return filtered;
	}
	public void setFiltered(Filtered filtered) {
		this.filtered = filtered;
	}

	@Override
	public String toString() {
		return "RootNifty [records=" + records + ", filtered=" + filtered + "]";
	}
    
}