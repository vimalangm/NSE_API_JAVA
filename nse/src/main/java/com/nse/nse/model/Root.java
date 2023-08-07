package com.nse.nse.model;

public class Root{
    public Records records;
    public Filtered filtered;
    
	public Root() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Root(Records records, Filtered filtered) {
		super();
		this.records = records;
		this.filtered = filtered;
	}

	public Records getRecords() {
		return records;
	}
	public void setRecords(Records records) {
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
		return "Root [records=" + records + ", filtered=" + filtered + "]";
	}
    
}