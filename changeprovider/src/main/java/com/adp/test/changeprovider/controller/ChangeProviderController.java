package com.adp.test.changeprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.adp.test.changeprovider.bean.ChangeReceipt;
import com.adp.test.changeprovider.service.ChangeProvide;

@RestController
public class ChangeProviderController {

	@Autowired
	ChangeProvide changeProvide;

	@GetMapping("/retrieveChange/{billAmount}/{paidAmount}")
	public ChangeReceipt getChange(@PathVariable final double billAmount, @PathVariable final double paidAmount) {

		ChangeReceipt output = changeProvide.retrieveChange(billAmount, paidAmount);

		return output;

	}

}
