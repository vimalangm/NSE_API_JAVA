package com.nse.nse.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Index {
	 public String key;
	    public String index;
	    public String indexSymbol;
	    public double last;
	    public double variation;
	    public double percentChange;
	    @JsonProperty("open") 
	    public double myopen;
	    public double high;
	    public double low;
	    public double previousClose;
	    public double yearHigh;
	    public double yearLow;
	    public String pe;
	    public String pb;
	    public String dy;
	    public String declines;
	    public String advances;
	    public String unchanged;
}
