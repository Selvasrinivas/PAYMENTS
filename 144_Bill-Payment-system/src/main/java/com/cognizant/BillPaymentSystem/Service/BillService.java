package com.cognizant.BillPaymentSystem.Service;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.BillPaymentSystem.Model.bill_types;
import com.cognizant.BillPaymentSystem.Model.bills;
import com.cognizant.BillPaymentSystem.Repository.BillRepository;
import com.cognizant.BillPaymentSystem.Repository.BillTypeRepository;

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
	
	public int getByamount(@Valid int amount){
		return billRepository.findByamount(amount);
		
	}
	

}
