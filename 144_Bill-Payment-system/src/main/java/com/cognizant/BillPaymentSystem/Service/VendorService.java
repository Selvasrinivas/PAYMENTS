package com.cognizant.BillPaymentSystem.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.BillPaymentSystem.ResponseTransfer;
import com.cognizant.BillPaymentSystem.UserAlreadyExistsException;
import com.cognizant.BillPaymentSystem.Model.vendor;
import com.cognizant.BillPaymentSystem.Repository.VendorRepository;

@Service
public class VendorService {
	
	@Autowired
	VendorRepository vendorRepository;
	
	 @Transactional
	  public void updateVendorDetails(vendor ven){

	
			 vendorRepository.save(ven);
			
		 }
	
	 
	 @Transactional
	  public List<vendor> getVendorList(){
	    return vendorRepository.findAll();		 
		 }
	  @Transactional
	  public vendor getVendor(String  vendorId){
		    return vendorRepository.findById(vendorId);		 
			 }
	  @Transactional
	  public vendor addvendor(@Valid vendor vendor) throws UserAlreadyExistsException{
	
		 return vendorRepository.save(vendor);
		 
		  
	  }

	  public ResponseTransfer deleteV(int vendorId) {
			// TODO Auto-generated method stub
			 vendorRepository.deleteById(vendorId);
			 return new ResponseTransfer("deldeted");
		}

}
