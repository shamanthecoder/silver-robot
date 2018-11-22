package com.coding.test.FxCalculator.Exception;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * Exception for unsupported currencies.
 */
public class UnsupportedCurrencyConversionException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnsupportedCurrencyConversionException(String message) {
		super(message);
	}
}
