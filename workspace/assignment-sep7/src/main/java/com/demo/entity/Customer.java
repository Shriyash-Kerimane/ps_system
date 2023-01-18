package com.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BANKACCOUNT")
public class Customer {

	@Id
	@Column(name = "CUSTID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;

	@Column(name = "CUSTNAME", length = 20)
	private String custName;

	@Column(name = "ADDRESS", length = 20)
	private String address;

	@Column(name = "ACCOUNTNO")
	private int accountNo;

	@Column(name = "BALANCE")
	private double balance;

	public Customer() {

	}

	public Customer(int custId, String custName, String address, int accountNo, double balance) {
		this.custId = custId;
		this.custName = custName;
		this.address = address;
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "CustomerBean [custId=" + custId + ", custName=" + custName + ", address=" + address + ", accountNo="
				+ accountNo + ", balance=" + balance + "]";
	}

}