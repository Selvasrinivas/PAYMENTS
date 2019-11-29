package com.cognizant.BillPaymentSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.BillPaymentSystem.Model.vendor;



public interface VendorRepository extends JpaRepository<vendor, Integer> {
	
	@Query(value="select * from vendor where ven_id=:val", nativeQuery=true)
	public vendor findById(@Param (value="val") String vendorId);
	
	@Modifying
	@Query(value="delete from vendor where ven_id=:id",nativeQuery=true)

	public void deleteById(@Param (value="id") int id);

}
