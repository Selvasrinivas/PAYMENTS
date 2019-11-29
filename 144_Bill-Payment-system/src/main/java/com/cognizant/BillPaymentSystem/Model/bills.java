package com.cognizant.BillPaymentSystem.Model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bills")
public class bills {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bi_id")
	private int billId;
	@Column(name="bi_amount")
	private BigDecimal amount;
	
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bill_types_bill_id", referencedColumnName="bt_id")
	private bill_types billTypes;
	
	
	@Override
	public String toString() {
		return "bills [billTypes=" + billTypes + ", userBill=" + userBill + ", bills=" + bills + "]";
	}


	public int getBillId() {
		return billId;
	}


	public void setBillId(int billId) {
		this.billId = billId;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public bills() {
		super();
		// TODO Auto-generated constructor stub
	}


	public bills(int billId, BigDecimal amount) {
		super();
		this.billId = billId;
		this.amount = amount;
	}


	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_us_id", referencedColumnName="us_id")
	private User userBill;
	
	
	@ManyToMany(mappedBy="vendorBills")
	private List<vendor> bills;
	
	
	
	

}
