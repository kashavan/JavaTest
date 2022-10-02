package com.rbc.javatest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;

import com.rbc.javatest.controllers.StockRestController;
import com.rbc.javatest.pojos.StockEntry;
import com.rbc.javatest.services.StockServices;
import com.rbc.javatest.services.StockServicesImpl;

@SpringBootTest
class RBCJavaTestApplicationTests {
	
	
	@Autowired
	StockRestController RESTController;
	
	
	//ensure the uploadDataSet REST API returns the correct output
	//upload a data set with 2 AA and 3 AXP stock entries
	@Test
	public void testUploadDataSetRESTAPI() {
		
		  String dataSet = "quarter,stock,date,open,high,low,close,volume,percent_change_price,percent_change_volume_over_last_wk,previous_weeks_volume,next_weeks_open,next_weeks_close,percent_change_next_weeks_price,days_to_next_dividend,percent_return_next_dividend\n"
		  		+ "1,AA,1/7/2011,$15.82,$16.72,$15.78,$16.42,239655616,3.79267,,,$16.71,$15.97,-4.42849,26,0.182704\n"
		  		+ "1,AA,1/21/2011,$16.19,$16.38,$15.60,$15.79,138428495,-2.47066,-43.02495926,242963398,$15.87,$16.13,1.63831,12,0.189994\n"
		  		+ "1,AXP,1/7/2011,$43.30,$45.60,$43.11,$44.36,45102042,2.44804,,,$44.20,$46.25,4.63801,89,0.405771\n"
		  		+ "1,AXP,1/14/2011,$44.20,$46.25,$44.01,$46.25,25913713,4.63801,-42.54425775,45102042,$46.03,$46.00,-0.0651749,82,0.389189\n"
		  		+ "1,AXP,1/21/2011,$46.03,$46.71,$44.71,$46.00,38824728,-0.0651749,49.82309945,25913713,$46.05,$43.86,-4.7557,75,0.391304";

		ResponseEntity<String> uploadDataSetExpectedResponse =
				new ResponseEntity<String> ("Stock Dataset Successfully Uploaded!",HttpStatus.OK);
		assertEquals(uploadDataSetExpectedResponse,RESTController.uploadDataSet(dataSet));
				
	}
	
	//ensure the uploadDataRecord REST API returns the correct output
	//upload a AA stock record entry
	@Test
	public void testUploadDataRecordRESTAPI() {
		
		StockEntry stockRecord = new StockEntry("1","AA","1/14/2011","$16.71","$16.71",
				"$15.64","$15.97","242963398","-4.42849","1.380223028","239655616","$16.19",
				"$15.79","-2.47066","19","0.187852");
		
		ResponseEntity<String> uploadDataRecordExpectedResponse =
				new ResponseEntity<String> ("Stock Record Successfully Uploaded!",HttpStatus.OK);
		assertEquals(uploadDataRecordExpectedResponse,RESTController.uploadDataRecord(stockRecord));
		
	}
	
	//ensure the queryStock REST API returns the correct output
	//get all AA stock entries in the database
	//if the uploadDataSet, uploadDataRecord and queryStockTicker methods work, then the queriedStock
	//list should have 3 AA entries in total
	@Test
	public void testQueryStockRESTAPI() {
				
		String dataSet = "quarter,stock,date,open,high,low,close,volume,percent_change_price,percent_change_volume_over_last_wk,previous_weeks_volume,next_weeks_open,next_weeks_close,percent_change_next_weeks_price,days_to_next_dividend,percent_return_next_dividend\n"
			  		+ "1,AA,1/7/2011,$15.82,$16.72,$15.78,$16.42,239655616,3.79267,,,$16.71,$15.97,-4.42849,26,0.182704\n"
			  		+ "1,AA,1/21/2011,$16.19,$16.38,$15.60,$15.79,138428495,-2.47066,-43.02495926,242963398,$15.87,$16.13,1.63831,12,0.189994\n"
			  		+ "1,AXP,1/7/2011,$43.30,$45.60,$43.11,$44.36,45102042,2.44804,,,$44.20,$46.25,4.63801,89,0.405771\n"
			  		+ "1,AXP,1/14/2011,$44.20,$46.25,$44.01,$46.25,25913713,4.63801,-42.54425775,45102042,$46.03,$46.00,-0.0651749,82,0.389189\n"
			  		+ "1,AXP,1/21/2011,$46.03,$46.71,$44.71,$46.00,38824728,-0.0651749,49.82309945,25913713,$46.05,$43.86,-4.7557,75,0.391304";
		
		RESTController.uploadDataSet(dataSet);
		  
		StockEntry stockRecord = new StockEntry("1","AA","1/14/2011","$16.71","$16.71",
					"$15.64","$15.97","242963398","-4.42849","1.380223028","239655616","$16.19",
					"$15.79","-2.47066","19","0.187852");
		  
		RESTController.uploadDataRecord(stockRecord);
		  
		ResponseEntity<List<StockEntry>> queriedStocks = RESTController.queryStock("AA");
		Assert.assertEquals(3,queriedStocks.getBody().size());
	}

}
