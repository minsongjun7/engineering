package model;

public class SalesListDTO {
	String prodNo;
	String prodName;
	String prodPrice;
	String sumPurQty;
	String sumPurPrice;
	
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getSumPurQty() {
		return sumPurQty;
	}
	public void setSumPurQty(String sumPurQty) {
		this.sumPurQty = sumPurQty;
	}
	public String getSumPurPrice() {
		return sumPurPrice;
	}
	public void setSumPurPrice(String sumPurPrice) {
		this.sumPurPrice = sumPurPrice;
	}
}