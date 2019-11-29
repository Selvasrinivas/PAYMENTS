package com.cognizant.BillPaymentSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.cognizant.BillPaymentSystem.Model.bill_types;

public interface BillTypeRepository extends JpaRepository<bill_types, Integer> {
	

	
	public List<bill_types> findBynameContaining( String billName);
}
