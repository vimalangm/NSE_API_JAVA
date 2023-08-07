package com.nse.nse.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Datum {
	   public int strikePrice;
	    public String expiryDate;
	    @JsonProperty("PE") 
	    public PE pE;
	    @JsonProperty("CE") 
	    public CE cE;
		public Datum() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Datum(int strikePrice, String expiryDate, PE pE, CE cE) {
			super();
			this.strikePrice = strikePrice;
			this.expiryDate = expiryDate;
			this.pE = pE;
			this.cE = cE;
		}
		public int getStrikePrice() {
			return strikePrice;
		}
		public void setStrikePrice(int strikePrice) {
			this.strikePrice = strikePrice;
		}
		public String getExpiryDate() {
			return expiryDate;
		}
		public void setExpiryDate(String expiryDate) {
			this.expiryDate = expiryDate;
		}
		public PE getpE() {
			return pE;
		}
		public void setpE(PE pE) {
			this.pE = pE;
		}
		public CE getcE() {
			return cE;
		}
		public void setcE(CE cE) {
			this.cE = cE;
		}
		@Override
		public String toString() {
			return "Datum [strikePrice=" + strikePrice + ", expiryDate=" + expiryDate + ", pE=" + pE + ", cE=" + cE
					+ "]";
		}
	    
}
