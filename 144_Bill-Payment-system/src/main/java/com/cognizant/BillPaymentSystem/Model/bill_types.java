package com.cognizant.BillPaymentSystem.Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="bill_types")
public class bill_types {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bt_id")
	private int id;
	@Column(name="bt_name")
	private String name;
	
	
	@Override
	public String toString() {
		return "bill_types [id=" + id + ", name=" + name + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public bill_types(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public bill_types() {
		super();
		// TODO Auto-generated constructor stub
	}


	@ManyToMany(mappedBy="billtypeList", fetch=FetchType.EAGER)
	private Set<User> userList;
	
	
	

}
