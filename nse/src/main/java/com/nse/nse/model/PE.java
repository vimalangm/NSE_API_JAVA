package com.nse.nse.model;

public class PE {
	public int strikePrice;
	public String expiryDate;
	public String underlying;
	public String identifier;
	public double openInterest;
	public int changeinOpenInterest;
	public double pchangeinOpenInterest;
	public int totalTradedVolume;
	public double impliedVolatility;
	public double lastPrice;
	public double change;
	public double pChange;
	public int totalBuyQuantity;
	public int totalSellQuantity;
	public int bidQty;
	public double bidprice;
	public int askQty;
	public double askPrice;
	public double underlyingValue;
	public int totOI;
	public int totVol;
	public PE() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PE(int strikePrice, String expiryDate, String underlying, String identifier, double openInterest,
			int changeinOpenInterest, double pchangeinOpenInterest, int totalTradedVolume, double impliedVolatility,
			double lastPrice, double change, double pChange, int totalBuyQuantity, int totalSellQuantity, int bidQty,
			double bidprice, int askQty, double askPrice, double underlyingValue, int totOI, int totVol) {
		super();
		this.strikePrice = strikePrice;
		this.expiryDate = expiryDate;
		this.underlying = underlying;
		this.identifier = identifier;
		this.openInterest = openInterest;
		this.changeinOpenInterest = changeinOpenInterest;
		this.pchangeinOpenInterest = pchangeinOpenInterest;
		this.totalTradedVolume = totalTradedVolume;
		this.impliedVolatility = impliedVolatility;
		this.lastPrice = lastPrice;
		this.change = change;
		this.pChange = pChange;
		this.totalBuyQuantity = totalBuyQuantity;
		this.totalSellQuantity = totalSellQuantity;
		this.bidQty = bidQty;
		this.bidprice = bidprice;
		this.askQty = askQty;
		this.askPrice = askPrice;
		this.underlyingValue = underlyingValue;
		this.totOI = totOI;
		this.totVol = totVol;
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
	public String getUnderlying() {
		return underlying;
	}
	public void setUnderlying(String underlying) {
		this.underlying = underlying;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public double getOpenInterest() {
		return openInterest;
	}
	public void setOpenInterest(double openInterest) {
		this.openInterest = openInterest;
	}
	public int getChangeinOpenInterest() {
		return changeinOpenInterest;
	}
	public void setChangeinOpenInterest(int changeinOpenInterest) {
		this.changeinOpenInterest = changeinOpenInterest;
	}
	public double getPchangeinOpenInterest() {
		return pchangeinOpenInterest;
	}
	public void setPchangeinOpenInterest(double pchangeinOpenInterest) {
		this.pchangeinOpenInterest = pchangeinOpenInterest;
	}
	public int getTotalTradedVolume() {
		return totalTradedVolume;
	}
	public void setTotalTradedVolume(int totalTradedVolume) {
		this.totalTradedVolume = totalTradedVolume;
	}
	public double getImpliedVolatility() {
		return impliedVolatility;
	}
	public void setImpliedVolatility(double impliedVolatility) {
		this.impliedVolatility = impliedVolatility;
	}
	public double getLastPrice() {
		return lastPrice;
	}
	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
	public double getpChange() {
		return pChange;
	}
	public void setpChange(double pChange) {
		this.pChange = pChange;
	}
	public int getTotalBuyQuantity() {
		return totalBuyQuantity;
	}
	public void setTotalBuyQuantity(int totalBuyQuantity) {
		this.totalBuyQuantity = totalBuyQuantity;
	}
	public int getTotalSellQuantity() {
		return totalSellQuantity;
	}
	public void setTotalSellQuantity(int totalSellQuantity) {
		this.totalSellQuantity = totalSellQuantity;
	}
	public int getBidQty() {
		return bidQty;
	}
	public void setBidQty(int bidQty) {
		this.bidQty = bidQty;
	}
	public double getBidprice() {
		return bidprice;
	}
	public void setBidprice(double bidprice) {
		this.bidprice = bidprice;
	}
	public int getAskQty() {
		return askQty;
	}
	public void setAskQty(int askQty) {
		this.askQty = askQty;
	}
	public double getAskPrice() {
		return askPrice;
	}
	public void setAskPrice(double askPrice) {
		this.askPrice = askPrice;
	}
	public double getUnderlyingValue() {
		return underlyingValue;
	}
	public void setUnderlyingValue(double underlyingValue) {
		this.underlyingValue = underlyingValue;
	}
	public int getTotOI() {
		return totOI;
	}
	public void setTotOI(int totOI) {
		this.totOI = totOI;
	}
	public int getTotVol() {
		return totVol;
	}
	public void setTotVol(int totVol) {
		this.totVol = totVol;
	}
	@Override
	public String toString() {
		return "PE [strikePrice=" + strikePrice + ", expiryDate=" + expiryDate + ", underlying=" + underlying
				+ ", identifier=" + identifier + ", openInterest=" + openInterest + ", changeinOpenInterest="
				+ changeinOpenInterest + ", pchangeinOpenInterest=" + pchangeinOpenInterest + ", totalTradedVolume="
				+ totalTradedVolume + ", impliedVolatility=" + impliedVolatility + ", lastPrice=" + lastPrice
				+ ", change=" + change + ", pChange=" + pChange + ", totalBuyQuantity=" + totalBuyQuantity
				+ ", totalSellQuantity=" + totalSellQuantity + ", bidQty=" + bidQty + ", bidprice=" + bidprice
				+ ", askQty=" + askQty + ", askPrice=" + askPrice + ", underlyingValue=" + underlyingValue + ", totOI="
				+ totOI + ", totVol=" + totVol + "]";
	}
	
	
}
