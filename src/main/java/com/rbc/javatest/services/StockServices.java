package com.rbc.javatest.services;

import java.util.List;

import com.rbc.javatest.pojos.StockEntry;

public interface StockServices {
	
	void uploadDataSet(String dataSet);
	List<StockEntry> queryStockTicker(String stockSymbol);
	void uploadDataRecord(StockEntry record);
}
