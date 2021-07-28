package com.adp.test.changeprovider.exception;

public class InvalidPaymentException extends RuntimeException {

	private static final long serialVersionUID = 3771756546874926305L;

	public InvalidPaymentException(String exception) {
		super(exception);
	}

}
