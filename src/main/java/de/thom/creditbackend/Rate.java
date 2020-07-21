package de.thom.creditbackend;

import java.math.BigDecimal;

public class Rate {

    private Integer rate;
    private BigDecimal zins;
    private BigDecimal tilgung;
    private BigDecimal rest;

    public Rate() {
    }

    public Rate(Integer rate, BigDecimal zins, BigDecimal tilgung, BigDecimal rest) {
        this.rate = rate;
        this.zins = zins;
        this.tilgung = tilgung;
        this.rest = rest;
    }

	public Integer getRate() {
		return this.rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public BigDecimal getZins() {
		return this.zins;
	}

	public void setZins(BigDecimal zins) {
		this.zins = zins;
	}

	public BigDecimal getTilgung() {
		return this.tilgung;
	}

	public void setTilgung(BigDecimal tilgung) {
		this.tilgung = tilgung;
	}

	public BigDecimal getRest() {
		return this.rest;
	}

	public void setRest(BigDecimal rest) {
		this.rest = rest;
	}

    
}