package com.adp.test.changeprovider.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.adp.test.changeprovider.bean.ChangeReceipt;
import com.adp.test.changeprovider.serviceimpl.ChangeProvideImpl;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("unitTest")
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class ChangeProviderControllerTest {

	@InjectMocks
	ChangeProviderController controller;

	@Mock
	ChangeProvideImpl service;

	@Test
	public void retrieveChangeSuccessTest1() {
		try {
			when(service.retrieveChange(anyDouble(), anyDouble())).thenReturn(mockChangeReceiptResponse());
			ChangeReceipt response = controller.getChange(42, 50);
			assertNotNull(response);
			assertEquals(response.getMessage(), "Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void retrieveChangeSuccessTest2() {
		try {
			when(service.retrieveChange(anyDouble(), anyDouble())).thenReturn(mockChangeReceiptResponse());
			ChangeReceipt response = controller.getChange(6.9, 10);
			assertNotNull(response);
			assertEquals(response.getMessage(), "Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void retrieveChangeSuccessTest3() {
		try {
			ChangeReceipt response = controller.getChange(42, 50);
			assertEquals(response.getTotalChangeBackToUser(), 8.0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void retrieveChangeFailureTest1() {
		try {
			ChangeReceipt response = controller.getChange(0, 10);
			System.out.println(response);
			assertEquals(response.getMessage(), "Please pay valid amount to proceed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ChangeReceipt mockChangeReceiptResponse() {
		ChangeReceipt resp = new ChangeReceipt();
		resp.setMessage("Success");
		return resp;
	}

}
