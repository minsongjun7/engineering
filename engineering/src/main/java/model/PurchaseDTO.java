package model;

import java.util.Date;

public class PurchaseDTO {
	String purNo;
	Date purDate;
	String purTotal;
	String purAddr;
	String purReceiver;
	String purReceiverPhoneNumber;
	String purMsg;
	String membId;
	
	public String getPurNo() {
		return purNo;
	}
	public void setPurNo(String purNo) {
		this.purNo = purNo;
	}
	public Date getPurDate() {
		return purDate;
	}
	public void setPurDate(Date purDate) {
		this.purDate = purDate;
	}
	public String getPurTotal() {
		return purTotal;
	}
	public void setPurTotal(String purTotal) {
		this.purTotal = purTotal;
	}
	public String getPurAddr() {
		return purAddr;
	}
	public void setPurAddr(String purAddr) {
		this.purAddr = purAddr;
	}
	public String getPurReceiver() {
		return purReceiver;
	}
	public void setPurReceiver(String purReceiver) {
		this.purReceiver = purReceiver;
	}
	public String getPurReceiverPhoneNumber() {
		return purReceiverPhoneNumber;
	}
	public void setPurReceiverPhoneNumber(String purReceiverPhoneNumber) {
		this.purReceiverPhoneNumber = purReceiverPhoneNumber;
	}
	public String getPurMsg() {
		return purMsg;
	}
	public void setPurMsg(String purMsg) {
		this.purMsg = purMsg;
	}
	public String getMembId() {
		return membId;
	}
	public void setMembId(String membId) {
		this.membId = membId;
	}
}