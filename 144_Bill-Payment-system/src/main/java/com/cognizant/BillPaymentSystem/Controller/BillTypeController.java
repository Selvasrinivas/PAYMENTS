package com.cognizant.BillPaymentSystem.Controller;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.BillPaymentSystem.Model.bill_types;
import com.cognizant.BillPaymentSystem.Model.bills;
import com.cognizant.BillPaymentSystem.Service.BillService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/bills")
public class BillTypeController {
	
	@Autowired
	BillService billService;
	@GetMapping()
	public List<bill_types> getBillListMethod(){
		return billService.getBillList();
		
	}
	
	@GetMapping("/{billName}")
	public List<bill_types> getBillByName(@PathVariable String billName){
		return billService.getBillByName(billName);
		
	}
	/*@GetMapping("/{id}")
	public int getBiByamount(@PathVariable int id){
		return billService.getByamount(id);
		
	}*/
	

}
