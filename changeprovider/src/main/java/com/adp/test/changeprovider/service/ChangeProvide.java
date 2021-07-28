package com.adp.test.changeprovider.service;

import com.adp.test.changeprovider.bean.ChangeReceipt;

public interface ChangeProvide {

	public ChangeReceipt retrieveChange(Double billAmount, Double paidAmount);

}
