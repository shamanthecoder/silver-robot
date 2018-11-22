package com.coding.test.FxCalculator.service;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * Currency converter table optimised, folded diagonally by joining the columns,
 * hence saving memory.
 */

public class CurrencyConversionTable {

	private Map<String, String> currencyTable;

	public CurrencyConversionTable() {
		this.currencyTable = new HashMap<String, String>();
		currencyTable.put("AUD/CAD", "USD");
		currencyTable.put("AUD/CNY", "USD");
		currencyTable.put("AUD/CZK", "USD");
		currencyTable.put("AUD/DKK", "USD");
		currencyTable.put("AUD/EUR", "USD");
		currencyTable.put("AUD/GBP", "USD");
		currencyTable.put("AUD/JPY", "USD");
		currencyTable.put("AUD/NOK", "USD");
		currencyTable.put("AUD/NZD", "USD");
		currencyTable.put("AUD/USD", "D");
		currencyTable.put("CAD/CNY", "USD");
		currencyTable.put("CAD/CZK", "USD");
		currencyTable.put("CAD/DKK", "USD");
		currencyTable.put("CAD/EUR", "USD");
		currencyTable.put("CAD/GBP", "USD");
		currencyTable.put("CAD/JPY", "USD");
		currencyTable.put("CAD/NOK", "USD");
		currencyTable.put("CAD/NZD", "USD");
		currencyTable.put("CAD/USD", "D");
		currencyTable.put("CNY/CZK", "USD");
		currencyTable.put("CNY/DKK", "USD");
		currencyTable.put("CNY/EUR", "USD");
		currencyTable.put("CNY/GBP", "USD");
		currencyTable.put("CNY/JPY", "USD");
		currencyTable.put("CNY/NOK", "USD");
		currencyTable.put("CNY/NZD", "USD");
		currencyTable.put("CNY/USD", "D");
		currencyTable.put("CZK/DKK", "EUR");
		currencyTable.put("CZK/EUR", "Inv");
		currencyTable.put("CZK/GBP", "USD");
		currencyTable.put("CZK/JPY", "USD");
		currencyTable.put("CZK/NOK", "EUR");
		currencyTable.put("CZK/NZD", "USD");
		currencyTable.put("CZK/USD", "EUR");
		currencyTable.put("DKK/EUR", "Inv");
		currencyTable.put("DKK/GBP", "USD");
		currencyTable.put("DKK/JPY", "USD");
		currencyTable.put("DKK/NOK", "EUR");
		currencyTable.put("DKK/NZD", "USD");
		currencyTable.put("DKK/USD", "EUR");
		currencyTable.put("EUR/GBP", "USD");
		currencyTable.put("EUR/JPY", "USD");
		currencyTable.put("EUR/NOK", "D");
		currencyTable.put("EUR/NZD", "USD");
		currencyTable.put("EUR/USD", "D");
		currencyTable.put("GBP/JPY", "USD");
		currencyTable.put("GBP/NOK", "USD");
		currencyTable.put("GBP/NZD", "USD");
		currencyTable.put("GBP/USD", "D");
		currencyTable.put("JPY/NOK", "USD");
		currencyTable.put("JPY/NZD", "USD");
		currencyTable.put("JPY/USD", "Inv");
		currencyTable.put("NOK/NZD", "USD");
		currencyTable.put("NOK/USD", "EUR");
		currencyTable.put("NZD/USD", "D");
	}

	/*
	 * Method to get the crossing currency for complex conversions.
	 */
	public String getConversionCurrency(String fromCurrency, String toCurrency) {

		String currency = this.currencyTable.get(getTableKey(fromCurrency, toCurrency));
		if (currency == null) {
			currency = this.currencyTable.get(getTableKey(toCurrency, fromCurrency));
		}
		return currency;
	}

	private String getTableKey(String fromCurrency, String toCurrency) {
		StringBuilder builder = new StringBuilder();
		builder.append(fromCurrency);
		builder.append("/");
		builder.append(toCurrency);
		return builder.toString();
	}

}
