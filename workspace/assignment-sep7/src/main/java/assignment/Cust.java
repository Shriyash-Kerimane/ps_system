package assignment;

public class Cust {
	private	Integer custId;
	private String custName;
	private String address;
	private Integer accountNo;
	private Double balance;
	public Cust() {
	}
	public Cust(Integer custId, String custName, String address, Integer accountNo, Double balance) {
		this.custId = custId;
		this.custName = custName;
		this.address = address;
		this.accountNo = accountNo;
		this.balance = balance;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
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
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	

}
