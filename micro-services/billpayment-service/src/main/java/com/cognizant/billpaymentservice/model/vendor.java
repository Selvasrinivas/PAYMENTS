package com.cognizant.billpaymentservice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="vendor")
public class vendor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ven_id")
	private int vendorId;
	@Column(name="ven_name")
	private String name;
	@Column(name="ven_com_reg_no")
	private String companyRegNo;
	@Column(name="ven_type")
	private String type;
	@Column(name="ven_address")
	private String address;
	@Column(name="ven_country")
	private String country;
	@Column(name="ven_state")
	private String state;
	@Column(name="ven_email_address")
	private String email;
	@Column(name="ven_contact_number")
	private int contact;
	@Column(name="ven_website")
	private String website;
	@Column(name="ven_certificate_issue")
	private Date certificateIssue;
	@Column(name="ven_certificate_validity")
	private Date certificateValidity;
	@Column(name="ven_year_of_establishment")
	private int yearEstablish;
	@Column(name="ven_payment")
	private String payment;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="vendor_bills", joinColumns=@JoinColumn(name="vb_bi_id"), inverseJoinColumns=@JoinColumn(name="vb_ven_id"))
	private List<bills> vendorBills;
	
/*	public List<bills> getVendorBills() {
		return vendorBills;
	}
	public void setVendorBills(List<bills> vendorBills) {
		this.vendorBills = vendorBills;
	}*/
	public vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public vendor(int vendorId, String name, String companyRegNo, String type, String address, String country,
			String state, String email, int contact, String website, Date certificateIssue, Date certificateValidity,
			int yearEstablish, String payment) {
		super();
		this.vendorId = vendorId;
		this.name = name;
		this.companyRegNo = companyRegNo;
		this.type = type;
		this.address = address;
		this.country = country;
		this.state = state;
		this.email = email;
		this.contact = contact;
		this.website = website;
		this.certificateIssue = certificateIssue;
		this.certificateValidity = certificateValidity;
		this.yearEstablish = yearEstablish;
		this.payment = payment;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyRegNo() {
		return companyRegNo;
	}
	public void setCompanyRegNo(String companyRegNo) {
		this.companyRegNo = companyRegNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Date getCertificateIssue() {
		return certificateIssue;
	}
	public void setCertificateIssue(Date certificateIssue) {
		this.certificateIssue = certificateIssue;
	}
	public Date getCertificateValidity() {
		return certificateValidity;
	}
	public void setCertificateValidity(Date certificateValidity) {
		this.certificateValidity = certificateValidity;
	}
	public int getYearEstablish() {
		return yearEstablish;
	}
	public void setYearEstablish(int yearEstablish) {
		this.yearEstablish = yearEstablish;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "vendor [vendorId=" + vendorId + ", name=" + name + ", companyRegNo=" + companyRegNo + ", type=" + type
				+ ", address=" + address + ", country=" + country + ", state=" + state + ", email=" + email
				+ ", contact=" + contact + ", website=" + website + ", certificateIssue=" + certificateIssue
				+ ", certificateValidity=" + certificateValidity + ", yearEstablish=" + yearEstablish + ", payment="
				+ payment + "]";
	}
	
	

	

}
