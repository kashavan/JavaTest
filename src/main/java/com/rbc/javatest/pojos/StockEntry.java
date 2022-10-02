package com.rbc.javatest.pojos;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockEntry {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String quarter;
	private String stock;
	private String date;
	private String open;
	private String high;
	private String low;
	private String close;
	private String volume;
	private String percentChangePrice;
	private String percentChangeVolumeOverLastWk;
	private String previousWeeksVolume;
	private String nextWeeksOpen;
	private String nextWeeksClose;
	private String percentChangeNextWeeksPrice;
	private String daysToNextDividend;
	private String percentReturnNextDividend;
	
	public StockEntry() {
		
	}

	public StockEntry(String quarter, String stock, String date, String open, String high, String low, String close,
			String volume, String percentChangePrice, String percentChangeVolumeOverLastWk, String previousWeeksVolume,
			String nextWeeksOpen, String nextWeeksClose, String percentChangeNextWeeksPrice, String daystoNextDividend,
			String percentReturnNextDividend) {
		super();
		this.quarter = quarter;
		this.stock = stock;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.percentChangePrice = percentChangePrice;
		this.percentChangeVolumeOverLastWk = percentChangeVolumeOverLastWk;
		this.previousWeeksVolume = previousWeeksVolume;
		this.nextWeeksOpen = nextWeeksOpen;
		this.nextWeeksClose = nextWeeksClose;
		this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
		this.daysToNextDividend = daystoNextDividend;
		this.percentReturnNextDividend = percentReturnNextDividend;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getPercentChangePrice() {
		return percentChangePrice;
	}

	public void setPercentChangePrice(String percentChangePrice) {
		this.percentChangePrice = percentChangePrice;
	}

	public String getPercentChangeVolumeOverLastWk() {
		return percentChangeVolumeOverLastWk;
	}

	public void setPercentChangeVolumeOverLastWk(String percentChangeVolumeOverLastWk) {
		this.percentChangeVolumeOverLastWk = percentChangeVolumeOverLastWk;
	}

	public String getPreviousWeeksVolume() {
		return previousWeeksVolume;
	}

	public void setPreviousWeeksVolume(String previousWeeksVolume) {
		this.previousWeeksVolume = previousWeeksVolume;
	}

	public String getNextWeeksOpen() {
		return nextWeeksOpen;
	}

	public void setNextWeeksOpen(String nextWeeksOpen) {
		this.nextWeeksOpen = nextWeeksOpen;
	}

	public String getNextWeeksClose() {
		return nextWeeksClose;
	}

	public void setNextWeeksClose(String nextWeeksClose) {
		this.nextWeeksClose = nextWeeksClose;
	}

	public String getPercentChangeNextWeeksPrice() {
		return percentChangeNextWeeksPrice;
	}

	public void setPercentChangeNextWeeksPrice(String percentChangeNextWeeksPrice) {
		this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
	}

	public String getDaystoNextDividend() {
		return daysToNextDividend;
	}

	public void setDaystoNextDividend(String daystoNextDividend) {
		this.daysToNextDividend = daystoNextDividend;
	}

	public String getPercentReturnNextDividend() {
		return percentReturnNextDividend;
	}

	public void setPercentReturnNextDividend(String percentReturnNextDividend) {
		this.percentReturnNextDividend = percentReturnNextDividend;
	}

	@Override
	public int hashCode() {
		return Objects.hash(close, date, daysToNextDividend, high, id, low, nextWeeksClose, nextWeeksOpen, open,
				percentChangeNextWeeksPrice, percentChangePrice, percentChangeVolumeOverLastWk,
				percentReturnNextDividend, previousWeeksVolume, quarter, stock, volume);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockEntry other = (StockEntry) obj;
		return Objects.equals(close, other.close) && Objects.equals(date, other.date)
				&& Objects.equals(daysToNextDividend, other.daysToNextDividend) && Objects.equals(high, other.high)
				&& id == other.id && Objects.equals(low, other.low)
				&& Objects.equals(nextWeeksClose, other.nextWeeksClose)
				&& Objects.equals(nextWeeksOpen, other.nextWeeksOpen) && Objects.equals(open, other.open)
				&& Objects.equals(percentChangeNextWeeksPrice, other.percentChangeNextWeeksPrice)
				&& Objects.equals(percentChangePrice, other.percentChangePrice)
				&& Objects.equals(percentChangeVolumeOverLastWk, other.percentChangeVolumeOverLastWk)
				&& Objects.equals(percentReturnNextDividend, other.percentReturnNextDividend)
				&& Objects.equals(previousWeeksVolume, other.previousWeeksVolume)
				&& Objects.equals(quarter, other.quarter) && Objects.equals(stock, other.stock)
				&& Objects.equals(volume, other.volume);
	}

	@Override
	public String toString() {
		return "StockEntry [id=" + id + ", quarter=" + quarter + ", stock=" + stock + ", date=" + date + ", open="
				+ open + ", high=" + high + ", low=" + low + ", close=" + close + ", volume=" + volume
				+ ", percentChangePrice=" + percentChangePrice + ", percentChangeVolumeOverLastWk="
				+ percentChangeVolumeOverLastWk + ", previousWeeksVolume=" + previousWeeksVolume + ", nextWeeksOpen="
				+ nextWeeksOpen + ", nextWeeksClose=" + nextWeeksClose + ", percentChangeNextWeeksPrice="
				+ percentChangeNextWeeksPrice + ", daystoNextDividend=" + daysToNextDividend
				+ ", percentReturnNextDividend=" + percentReturnNextDividend + "]";
	}




}
