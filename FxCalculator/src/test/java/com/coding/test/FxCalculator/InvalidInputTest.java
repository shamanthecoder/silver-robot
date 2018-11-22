package com.coding.test.FxCalculator;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.coding.test.FxCalculator.Exception.UnsupportedCurrencyConversionException;
import com.coding.test.FxCalculator.impl.FXConversionServiceImpl;

/**
 * 
 * @author Shyamant
 *
 */
public class InvalidInputTest {

	private FXConversionServiceImpl fxService;

	@Before
	public void setup() {
		fxService = new FXConversionServiceImpl();
	}

	@Test
	public void testInvalidFromCurrency() throws UnsupportedCurrencyConversionException {
		try {
			fxService.convert("UAD", "AUD", new BigDecimal(1));
		} catch (UnsupportedCurrencyConversionException ie) {
			assert (ie.getMessage().equals("Unable to find rate for UAD/AUD"));
			return;
		}
		//No exception means a failure and the test should fail.
		assert (false);
	}

	@Test
	public void testInvalidToCurrency() throws UnsupportedCurrencyConversionException {
		try {
			fxService.convert("AUD", "KWJ", new BigDecimal(1));
		} catch (UnsupportedCurrencyConversionException ie) {
			assert (ie.getMessage().equals("Unable to find rate for AUD/KWJ"));
			return;
		}
		//No exception means a failure and the test should fail.
		assert (false);
	}

}
