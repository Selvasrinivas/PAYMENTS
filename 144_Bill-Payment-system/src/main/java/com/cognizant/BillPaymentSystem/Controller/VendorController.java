package com.cognizant.BillPaymentSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.BillPaymentSystem.ResponseTransfer;
import com.cognizant.BillPaymentSystem.UserAlreadyExistsException;
import com.cognizant.BillPaymentSystem.Model.vendor;
import com.cognizant.BillPaymentSystem.Service.VendorService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/vendor")
public class VendorController {
	
	
	@Autowired
	VendorService vendorService;
	
	@PutMapping("")
	public ResponseTransfer modifyVendor(@RequestBody vendor ven) {

		vendorService.updateVendorDetails(ven);
		return new ResponseTransfer("Success");
	}
	
	@GetMapping("")
	public List<vendor> getvendor(){
		return vendorService.getVendorList();
		
		
	}
	@GetMapping("/{vendorId}")
	public vendor getuserById(@PathVariable String vendorId ){
		return vendorService.getVendor(vendorId);
		
		
	}
	@PostMapping("")
	public ResponseTransfer addVendorvalues(@RequestBody  vendor vendor) throws UserAlreadyExistsException{
		vendorService.addvendor(vendor);
		System.err.println(vendor);
		return new ResponseTransfer("added");
	}
	@RequestMapping(value="/{vendorId}", method = RequestMethod.DELETE)
	public ResponseTransfer delete(@PathVariable int vendorId ){
		return vendorService.deleteV(vendorId);
		
		
	}

}
