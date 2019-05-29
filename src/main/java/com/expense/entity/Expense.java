package com.expense.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * Expense Entity
 * 
 */

@Entity
@Table(name="Expense")
public class Expense {
	
	
	private Long id;

	private String date;
	   
	private String expenseHead;
	   
	private Double amount;
	   
	private String currency;
	   
	private String expenseCategory;
	   
	private Integer isRecurring;
	   
	private Integer isSelected;
	   
	private String details;

    private User user;
    
    
    
    public Expense() {
		
	}
	public Expense(String date, String expenseHead, Double amount, String currency, String expenseCategory,
			Integer isRecurring, Integer isSelected, String details,User user) {
		super();
		this.date = date;
		this.expenseHead = expenseHead;
		this.amount = amount;
		this.currency = currency;
		this.expenseCategory = expenseCategory;
		this.isRecurring = isRecurring;
		this.isSelected = isSelected;
		this.details = details;
		this.user = user;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
	@Column
	public String getExpenseHead() {
		return expenseHead;
	}
	public void setExpenseHead(String expenseHead) {
		this.expenseHead = expenseHead;
	}
	
	@Column
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Column
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@Column
	public String getExpenseCategory() {
		return expenseCategory;
	}
	public void setExpenseCategory(String expenseCategory) {
		this.expenseCategory = expenseCategory;
	}
	
	@Column
	public Integer getIsRecurring() {
		return isRecurring;
	}
	public void setIsRecurring(Integer isRecurring) {
		this.isRecurring = isRecurring;
	}
	
	@Column
	public Integer getIsSelected() {
		return isSelected;
	}
	public void setIsSelected(Integer isSelected) {
		this.isSelected = isSelected;
	}
	
	@Column
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id") //It is used for joining two tables where it uses many to one mapping
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Expense [id=" + id + ",  date=" + date + ", expenseHead=" + expenseHead
				+ ", amount=" + amount + ", currency=" + currency + ", expenseCategory=" + expenseCategory
				+ ", isRecurring=" + isRecurring + ", isSelected=" + isSelected + ", details=" + details + ", user="
				+ "]";
	}
	
	
		
}
