package com.expense.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * User Entity
 * 
 * */
@Entity
@Table(name="USER")
public class User {
	
	
	private Long id;

	private String username;
	   
	private String password;
	   
	private String name;
	   
	private String currency;

	private List<Expense> expenseList=new ArrayList<Expense>();
	

	
	
	public User(String username, String password, String name, String currency, List<Expense> expenseList) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.currency = currency;
		this.expenseList = expenseList;
	}

	public User() {
		
	}

	public User(String username, String password, String name, String currency) {
		
		this.username = username;
		this.password = password;
		this.name = name;
		this.currency = currency;
	}

	@Id //This annotation defines the primary key  
	@GeneratedValue(strategy=GenerationType.IDENTITY) // It generate unique value for respective column
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	@Size(min=5)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Column
	@Size(min=5)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column
	@Size(min=5)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	@Column
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	/*It simply hides the field from the Jackson parser. 
	here we used to test the controller class which gives an output in json format*/
	@Column
	@OneToMany(mappedBy = "user",fetch = FetchType.EAGER,   cascade = CascadeType.ALL) // This annotation used for one to many mapping
	@JsonIgnore
	public List<Expense> getExpenseList() {
		return expenseList;
	}
	public void setExpenseList(List<Expense> expense) {
		this.expenseList = expense;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", currency="
				+ currency + ", expenseList=" + expenseList + "]";
	}
	
	
}
