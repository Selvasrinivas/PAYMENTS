package com.cognizant.authenticationservice.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="us_id")
	private int userId;
	@Column(name="us_firstname")
	private String firstName;
	
	@Column(name="us_lastname")
	private String lastName;
	@Column(name="us_age")
	private int age;
	@Column(name="us_gender")
	private String gender;
	@Column(name="us_contactnumber")
	private String contactNumber;
	@Column(name="us_pan")
	private String pan;
	@Column(name="us_aadharnumber")
	private String aadhar;
	@Column(name="us_usID")
	private String usId;
	@Column(name="us_password")
	private String password;
	
	
	
	@ManyToMany
	@JoinTable(name="user_role", joinColumns={@JoinColumn(name="user_us_id")},
	inverseJoinColumns={@JoinColumn(name="role_ro_id")})
	private Set<role> roleList;
	
	
	public Set<role> getRoleList() {
		return roleList;
	}


	public void setRoleList(Set<role> roleList) {
		this.roleList = roleList;
	}
/*	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="bills", joinColumns={@JoinColumn(name="user_us_id")},
	inverseJoinColumns={@JoinColumn(name="bill_types_bill_id")})
	private List<bill_types> billtypeList;

	*/
	
	public User(int userId, String firstName, String lastName, int age, String gender, String contactNumber, String pan,
			String aadhar, String usId, String password, Set<role> roleList) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.pan = pan;
		this.aadhar = aadhar;
		this.usId = usId;
		this.password = password;
		this.roleList = roleList;
	}
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getPan() {
		return pan;
	}


	public void setPan(String pan) {
		this.pan = pan;
	}


	public String getAadhar() {
		return aadhar;
	}


	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}


	public String getUsId() {
		return usId;
	}


	public void setUsId(String usId) {
		this.usId = usId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	


	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", contactNumber=" + contactNumber + ", pan=" + pan + ", aadhar=" + aadhar
				+ ", usId=" + usId + ", password=" + password + "]";
	}
	
	
	

	
	
	

}
