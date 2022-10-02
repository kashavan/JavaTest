package com.rbc.javatest.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rbc.javatest.pojos.StockEntry;

public interface StockDAO extends JpaRepository<StockEntry, Integer> {
	
	//created a custom method to search the db by the stock column name
	//Spring Data JPA runs the appropriate query behind the scenes to get the result
	List<StockEntry> findByStock(String stock);

	
}
