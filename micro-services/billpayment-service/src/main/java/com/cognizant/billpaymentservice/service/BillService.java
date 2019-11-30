package com.cognizant.billpaymentservice.service;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.billpaymentservice.model.bill_types;
import com.cognizant.billpaymentservice.repository.BillRepository;
import com.cognizant.billpaymentservice.repository.BillTypeRepository;




@Service
public class BillService {
	@Autowired
	BillTypeRepository billtypeRepository;
	@Autowired
	BillRepository billRepository;
	
	public List<bill_types> getBillList(){
		return billtypeRepository.findAll();
		
	}
	
	public List<bill_types> getBillByName(@Valid String billName){
		return billtypeRepository.findBynameContaining(billName);
		
	}
	
	public int getByamount(@Valid int amount,@Valid int type){
		return billRepository.findByamount(amount,type);
		
	}
	

}
