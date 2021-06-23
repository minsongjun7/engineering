package model;

import java.util.Date;

public class PaymentDTO {
	String payNo;
	String purNo;
	String payMethod;
	String payAccountNo;
	String payPrice;
	String payDate;
	String payCardBank;
	
	public String getPayNo() {
		return payNo;
	}
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}
	public String getPurNo() {
		return purNo;
	}
	public void setPurNo(String purNo) {
		this.purNo = purNo;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getPayAccountNo() {
		return payAccountNo;
	}
	public void setPayAccountNo(String payAccountNo) {
		this.payAccountNo = payAccountNo;
	}
	public String getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getPayCardBank() {
		return payCardBank;
	}
	public void setPayCardBank(String payCardBank) {
		this.payCardBank = payCardBank;
	}
}