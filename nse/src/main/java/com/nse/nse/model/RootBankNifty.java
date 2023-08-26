package com.nse.nse.model;

public class RootBankNifty {
	public RecordsBankNifty records;
	public Filtered filtered;

	public RootBankNifty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RootBankNifty(RecordsBankNifty records, Filtered filtered) {
		super();
		this.records = records;
		this.filtered = filtered;
	}

	public RecordsBankNifty getRecords() {
		return records;
	}

	public void setRecords(RecordsBankNifty records) {
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
		return "RootBankNifty [records=" + records + ", filtered=" + filtered + "]";
	}

}
