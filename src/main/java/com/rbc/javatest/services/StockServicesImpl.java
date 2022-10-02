package com.rbc.javatest.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rbc.javatest.daos.StockDAO;
import com.rbc.javatest.pojos.StockEntry;



@Component(value="stockEntryService")
public class StockServicesImpl implements StockServices {
	
	@Autowired
	private StockDAO stockDao;

	@Override
	public void uploadDataSet(String dataSet) {

		Stream<String> contentStream = dataSet.lines();
		List<String>  contentList = contentStream.collect(Collectors.toList());
		contentList.remove(0);
		

		for(String s:contentList) {
			String[] stockFields = s.split(",");
			StockEntry entry = new StockEntry(stockFields[0],stockFields[1],stockFields[2],stockFields[3],stockFields[4],stockFields[5],stockFields[6],stockFields[7],stockFields[8],stockFields[10],stockFields[11],stockFields[12],stockFields[13],stockFields[14],stockFields[15],stockFields[15]);
			stockDao.save(entry);
		}


	}

	@Override
	public List<StockEntry> queryStockTicker(String stockSymbol) {
		List<StockEntry> queryData = stockDao.findByStock(stockSymbol);
		return queryData;
	}

	@Override
	public void uploadDataRecord(StockEntry record) {

		stockDao.save(record);
	}
	



}
