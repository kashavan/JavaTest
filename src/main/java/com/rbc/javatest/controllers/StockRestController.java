package com.rbc.javatest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rbc.javatest.pojos.StockEntry;
import com.rbc.javatest.services.StockServices;


@RestController
public class StockRestController {
	
	@Autowired
	StockServices stockServices;
	
	@PostMapping("/uploadDataSet")
	public ResponseEntity<String> uploadDataSet (@RequestBody String dataSet){
		
		stockServices.uploadDataSet(dataSet);
		return new ResponseEntity<String> ("Stock Dataset Successfully Uploaded!",HttpStatus.OK);
	}
	
	@PostMapping("/uploadDataRecord")
	public ResponseEntity<String> uploadDataRecord (@RequestBody StockEntry record){
		
		stockServices.uploadDataRecord(record);
		return new ResponseEntity<String> ("Stock Record Successfully Uploaded!",HttpStatus.OK);
	}
	
	@GetMapping("/queryStock/{stockSymbol}")
	public ResponseEntity<List<StockEntry>> queryStock (@PathVariable String stockSymbol) {		
		List <StockEntry> stockQueryData = stockServices.queryStockTicker(stockSymbol);
		return new ResponseEntity<List<StockEntry>> (stockQueryData,HttpStatus.OK);
	}

	

}
