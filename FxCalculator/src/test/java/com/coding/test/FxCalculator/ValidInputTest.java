package com.coding.test.FxCalculator;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.coding.test.FxCalculator.Exception.UnsupportedCurrencyConversionException;
import com.coding.test.FxCalculator.impl.FXConversionServiceImpl;

/**
 * @author Shyamant Unit test for FX calculator.
 */

public class ValidInputTest {
	private FXConversionServiceImpl fxService;

	@Before
	public void setup() {
		fxService = new FXConversionServiceImpl();
	}

	@Test
	public void testAUDtoDifferentCurrencies() throws UnsupportedCurrencyConversionException {
		assert (fxService.convert("AUD", "USD", new BigDecimal(100)).toString().equals("83.71"));
		assert (fxService.convert("AUD", "DKK", new BigDecimal(100.0)).toString().equals("505.76"));
		assert (fxService.convert("AUD", "GBP", new BigDecimal(123123123.567)).toString().equals("65718527.53"));
		assert (fxService.convert("AUD", "JPY", new BigDecimal(200.00)).toString().equals("20082"));
		assert (fxService.convert("AUD", "NOK", new BigDecimal(134.00)).toString().equals("789.26"));
	}

	@Test
	public void testCADtoDifferentCurrencies() throws UnsupportedCurrencyConversionException {
		assert (fxService.convert("CAD", "CNY", new BigDecimal(100)).toString().equals("537.59"));
		assert (fxService.convert("CAD", "CZK", new BigDecimal(100.3)).toString().equals("1958.33"));
		assert (fxService.convert("CAD", "CAD", new BigDecimal(123123123.567)).toString().equals("123123123.56"));
		assert (fxService.convert("CAD", "NOK", new BigDecimal(200.00)).toString().equals("1225.84"));
		assert (fxService.convert("CAD", "DKK", new BigDecimal(134.00)).toString().equals("705.24"));
	}

	@Test
	public void testCNYtoDifferentCurrencies() throws UnsupportedCurrencyConversionException {
		assert (fxService.convert("CNY", "DKK", new BigDecimal(100)).toString().equals("97.89"));
		assert (fxService.convert("CNY", "JPY", new BigDecimal(25.3)).toString().equals("491"));
		assert (fxService.convert("CNY", "AUD", new BigDecimal(0.567)).toString().equals("0.10"));
		assert (fxService.convert("CNY", "USD", new BigDecimal(1000)).toString().equals("162.03"));
		assert (fxService.convert("CNY", "NZD", new BigDecimal(555)).toString().equals("116.03"));
	}

	@Test
	public void testCZKtoDifferentCurrencies() throws UnsupportedCurrencyConversionException {
		assert (fxService.convert("CZK", "CNY", new BigDecimal(100)).toString().equals("27.53"));
		assert (fxService.convert("CZK", "USD", new BigDecimal(26.3)).toString().equals("1.17"));
		assert (fxService.convert("CZK", "EUR", new BigDecimal(100.5)).toString().equals("3.64"));
		assert (fxService.convert("CZK", "DKK", new BigDecimal(1000)).toString().equals("269.55"));
		assert (fxService.convert("CZK", "CAD", new BigDecimal(9999.9999)).toString().equals("512.16"));
	}

	@Test
	public void testDKKtoDifferentCurrencies() throws UnsupportedCurrencyConversionException {
		assert (fxService.convert("DKK", "AUD", new BigDecimal(100)).toString().equals("19.77"));
		assert (fxService.convert("DKK", "CAD", new BigDecimal(399)).toString().equals("75.81"));
		assert (fxService.convert("DKK", "GBP", new BigDecimal(900)).toString().equals("94.98"));
		assert (fxService.convert("DKK", "USD", new BigDecimal(99.99)).toString().equals("16.54"));
		assert (fxService.convert("DKK", "NOK", new BigDecimal(500)).toString().equals("582.29"));
	}

	@Test
	public void testEURtoDifferentCurrencies() throws UnsupportedCurrencyConversionException {
		assert (fxService.convert("EUR", "GBP", new BigDecimal(100)).toString().equals("78.52"));
		assert (fxService.convert("EUR", "AUD", new BigDecimal(444.99999)).toString().equals("654.66"));
		assert (fxService.convert("EUR", "CNY", new BigDecimal(200)).toString().equals("1520.04"));
		assert (fxService.convert("EUR", "NOK", new BigDecimal(100)).toString().equals("866.51"));
		assert (fxService.convert("EUR", "NZD", new BigDecimal(77.77)).toString().equals("123.57"));
	}

	@Test
	public void testGBPtoDifferentCurrencies() throws UnsupportedCurrencyConversionException {
		assert (fxService.convert("GBP", "CAD", new BigDecimal(200)).toString().equals("360.07"));
		assert (fxService.convert("GBP", "CZK", new BigDecimal(300)).toString().equals("10545.54"));
		assert (fxService.convert("GBP", "DKK", new BigDecimal(1000000)).toString().equals("9475384.61"));
		assert (fxService.convert("GBP", "JPY", new BigDecimal(98000000)).toString().equals("18435523330"));
		assert (fxService.convert("GBP", "AUD", new BigDecimal(44)).toString().equals("82.43"));
	}

	@Test
	public void testJPYtoDifferentCurrencies() throws UnsupportedCurrencyConversionException {
		assert (fxService.convert("JPY", "DKK", new BigDecimal(100)).toString().equals("5.03"));
		assert (fxService.convert("JPY", "JPY", new BigDecimal(25.34)).toString().equals("25"));
		assert (fxService.convert("JPY", "AUD", new BigDecimal(345)).toString().equals("3.43"));
		assert (fxService.convert("JPY", "NOK", new BigDecimal(10)).toString().equals("0.58"));
		assert (fxService.convert("JPY", "EUR", new BigDecimal(333)).toString().equals("2.25"));
	}

	@Test
	public void testNOKtoDifferentCurrencies() throws UnsupportedCurrencyConversionException {
		assert (fxService.convert("NOK", "DKK", new BigDecimal(467.2389)).toString().equals("401.20"));
		assert (fxService.convert("NOK", "CZK", new BigDecimal(300)).toString().equals("955.65"));
		assert (fxService.convert("NOK", "GBP", new BigDecimal(66)).toString().equals("5.98"));
		assert (fxService.convert("NOK", "USD", new BigDecimal(1276)).toString().equals("181.34"));
		assert (fxService.convert("NOK", "CNY", new BigDecimal(888)).toString().equals("778.86"));
	}

	@Test
	public void testNZDtoDifferentCurrencies() throws UnsupportedCurrencyConversionException {
		assert (fxService.convert("NZD", "CZK", new BigDecimal(200)).toString().equals("3474.16"));
		assert (fxService.convert("NZD", "DKK", new BigDecimal(300)).toString().equals("1404.72"));
		assert (fxService.convert("NZD", "NOK", new BigDecimal(4.69999)).toString().equals("25.62"));
		assert (fxService.convert("NZD", "USD", new BigDecimal(1999)).toString().equals("1549.22"));
		assert (fxService.convert("NZD", "EUR", new BigDecimal(333)).toString().equals("209.56"));
	}

	@Test
	public void testUSDtoDifferentCurrencies() throws UnsupportedCurrencyConversionException {
		assert (fxService.convert("USD", "NOK", new BigDecimal(100)).toString().equals("703.62"));
		assert (fxService.convert("USD", "DKK", new BigDecimal(476)).toString().equals("2875.90"));
		assert (fxService.convert("USD", "AUD", new BigDecimal(345.0)).toString().equals("412.13"));
		assert (fxService.convert("USD", "CNY", new BigDecimal(1.09)).toString().equals("6.72"));
		assert (fxService.convert("USD", "GBP", new BigDecimal(77.32)).toString().equals("49.30"));
	}

}