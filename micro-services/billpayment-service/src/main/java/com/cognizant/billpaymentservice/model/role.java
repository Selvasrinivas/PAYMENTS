package com.cognizant.billpaymentservice.model;

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
@Table(name="role")
public class role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ro_id")
	private int id;
	
	@Column(name="ro_name")
	private String name;
	
	@ManyToMany(mappedBy="roleList", fetch=FetchType.EAGER)
	private Set<User> userList;

	public role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "role [id=" + id + ", name=" + name + "]";
	}
	

	
	
}

