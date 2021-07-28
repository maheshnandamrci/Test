package com.adp.test.changeprovider.bean;

public class ChangeReceipt {

	private float totalChangeBackToUser;
	private String dollarChange;
	private String coinsChange;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public float getTotalChangeBackToUser() {
		return totalChangeBackToUser;
	}

	public void setTotalChangeBackToUser(float totalChangeBackToUser) {
		this.totalChangeBackToUser = totalChangeBackToUser;
	}

	public String getDollarChange() {
		return dollarChange;
	}

	public void setDollarChange(String dollarChange) {
		this.dollarChange = dollarChange;
	}

	public String getCoinsChange() {
		return coinsChange;
	}

	public void setCoinsChange(String coinsChange) {
		this.coinsChange = coinsChange;
	}

}
