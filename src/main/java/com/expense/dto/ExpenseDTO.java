package com.expense.dto;

public class ExpenseDTO {

	private Long id;

	private String date;

	private String expenseHead;

	private Double amount;

	private String currency;

	private String expenseCategory;

	private Integer isRecurring;

	private Integer isSelected;

	private String details;

	private Long userId;

	public ExpenseDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getExpenseHead() {
		return expenseHead;
	}

	public void setExpenseHead(String expenseHead) {
		this.expenseHead = expenseHead;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(String expenseCategory) {
		this.expenseCategory = expenseCategory;
	}

	public Integer getIsRecurring() {
		return isRecurring;
	}

	public void setIsRecurring(Integer isRecurring) {
		this.isRecurring = isRecurring;
	}

	public Integer getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Integer isSelected) {
		this.isSelected = isSelected;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ExpenseDTO [id=" + id + ", date=" + date + ", expenseHead=" + expenseHead + ", amount=" + amount
				+ ", currency=" + currency + ", expenseCategory=" + expenseCategory + ", isRecurring=" + isRecurring
				+ ", isSelected=" + isSelected + ", details=" + details + "]";
	}

}
