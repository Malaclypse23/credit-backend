package de.thom.creditbackend;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Payback {

    private BigDecimal monthly;
    private BigDecimal totalInterest;
    private List<Rate> rates = new ArrayList<Rate>();

    public Payback() {
    }

    public Payback(BigDecimal monthly) {
        this.monthly = monthly;
		this.rates = new ArrayList<Rate>();
    }
	
	public BigDecimal getMonthly() {
		return this.monthly;
	}

	public void setMonthly(BigDecimal monthly) {
		this.monthly = monthly;
	}

	public BigDecimal getTotalInterest() {
		return this.totalInterest;
	}

	public void setTotalInterest(BigDecimal totalInterest) {
		this.totalInterest = totalInterest;
	}

	public List<Rate> getRates() {
		return this.rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

}