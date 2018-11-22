package com.coding.test.FxCalculator.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Deque;

import com.coding.test.FxCalculator.Exception.UnsupportedCurrencyConversionException;
import com.coding.test.FxCalculator.service.Currencies;
import com.coding.test.FxCalculator.service.Currencies.ListOfCurrencies;
import com.coding.test.FxCalculator.service.CurrencyConversionTable;
import com.coding.test.FxCalculator.service.FXConversionService;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * Forex conversion implementation class.
 * 
 */
public class FXConversionServiceImpl implements FXConversionService {

	/*
	 * FX convert method which does the actual conversion and returns a value in
	 * BigDecimal.
	 * 
	 * @param String,String,BigDecimal
	 */

	public BigDecimal convert(String fromCurrency, String toCurrency, BigDecimal value)
			throws UnsupportedCurrencyConversionException {

		boolean conversionDone = false;
		Currencies currencies = new Currencies();
		if (fromCurrency.equalsIgnoreCase(toCurrency))
			return value.setScale(currencies.getCurrencyPrecision().get(toCurrency), RoundingMode.DOWN);
		try {
			// This should throw an exception for unsupported currencies.
			ListOfCurrencies.valueOf(fromCurrency);
			ListOfCurrencies.valueOf(toCurrency);

		} catch (IllegalArgumentException iae) {
			throw new UnsupportedCurrencyConversionException(
					"Unable to find rate for " + fromCurrency + "/" + toCurrency);
		}
		BigDecimal result = new BigDecimal(0);
		BigDecimal conversionRate = currencies.getCurrencyRates(fromCurrency, toCurrency);
		if (conversionRate == null) {
			// Look up the currency converter table for transitive conversion.
			CurrencyConversionTable table = new CurrencyConversionTable();
			Deque<String> stack = new ArrayDeque<String>();
			//Using Dequeue to hold currencies as this process might involve a chain of cross conversion.
			stack.push(toCurrency);
			while (!conversionDone) {
				//Iterate and do conversions according to the data in the table until all the conversions are done.
				String transitiveCurrency = table.getConversionCurrency(fromCurrency, toCurrency);
				if (transitiveCurrency.equalsIgnoreCase("D") || transitiveCurrency.equalsIgnoreCase("Inv")) {
					conversionRate = currencies.getCurrencyRates(fromCurrency, toCurrency);
					result = conversionRate.multiply(value);
					value = result;
					fromCurrency = stack.pop();
					if (!stack.isEmpty())
						toCurrency = stack.peek();
					else
						conversionDone = true;

				} else {
					// no direct conversion available so push it to the stack.
					stack.push(transitiveCurrency);
					toCurrency = transitiveCurrency;
				}
			}

		} else {
			result = conversionRate.multiply(value);
		}
		return result.setScale(currencies.getCurrencyPrecision().get(toCurrency), RoundingMode.DOWN);

	}

}
