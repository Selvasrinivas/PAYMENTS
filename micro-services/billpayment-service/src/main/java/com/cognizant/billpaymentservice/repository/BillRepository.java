package com.cognizant.billpaymentservice.repository;



import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.billpaymentservice.model.bills;


@Repository
public interface BillRepository extends JpaRepository<bills, Integer> {
	@Query(value="select bi_amount from bills where user_us_id=:amount and bill_types_bill_id=:type",nativeQuery=true)
 public int findByamount(@Param (value="amount")@Valid int amount, @Param (value="type") @Valid int type);

}
