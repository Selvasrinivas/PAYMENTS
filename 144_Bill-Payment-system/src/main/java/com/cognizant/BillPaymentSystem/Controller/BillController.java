package com.cognizant.BillPaymentSystem.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.cognizant.BillPaymentSystem.Service.BillService;
@RestController
public class BillController {
	@Autowired
	BillService billService;
	@GetMapping("bill/{amount}")
	public int getBillByamount(@PathVariable int amount){
		return billService.getByamount(amount);
		
	}
}
