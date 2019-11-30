package com.cognizant.BillPaymentSystem.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.cognizant.BillPaymentSystem.Service.BillService;
@RestController
@CrossOrigin("http://localhost:4200")
public class BillController {
	@Autowired
	BillService billService;
	@GetMapping("bill/{amount}/{type}")
	public int getBillByamount(@PathVariable int amount, @PathVariable int type){
		return billService.getByamount(amount,type);
		
	}
}
