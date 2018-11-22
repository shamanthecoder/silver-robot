package com.coding.test.FxCalculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * Currency class holding currencies supported and various data required for the
 * currency.
 */
public class Currencies {

	public static enum ListOfCurrencies {
		AUD, USD, CAD, CNY, CZK, DKK, EUR, GBP, JPY, NOK, NZD
	}

	private Map<String, Integer> currencyPrecisionRequired;
	private Map<String, BigDecimal> currencyPairRates;

	public Currencies() {
		currencyPrecisionRequired = new HashMap<String, Integer>();
		currencyPairRates = new HashMap<String, BigDecimal>();
		// create the precision map
		for (ListOfCurrencies currency : ListOfCurrencies.values()) {
			if (currency.toString().equalsIgnoreCase("JPY")) {
				currencyPrecisionRequired.put(currency.toString(), 0);
			} else {
				currencyPrecisionRequired.put(currency.toString(), 2);
			}
		}
		// create the rates map based on the rates given to us as of now
		currencyPairRates.put("AUDUSD", new BigDecimal(0.8371).setScale(4, RoundingMode.UP));
		currencyPairRates.put("CADUSD", new BigDecimal(0.8711).setScale(4, RoundingMode.UP));
		currencyPairRates.put("USDCNY", new BigDecimal(6.1715).setScale(4, RoundingMode.UP));
		currencyPairRates.put("EURUSD", new BigDecimal(1.2315).setScale(4, RoundingMode.DOWN));
		currencyPairRates.put("GBPUSD", new BigDecimal(1.5683).setScale(4, RoundingMode.DOWN));
		currencyPairRates.put("NZDUSD", new BigDecimal(0.7750).setScale(4, RoundingMode.DOWN));
		currencyPairRates.put("USDJPY", new BigDecimal(119.95).setScale(2, RoundingMode.DOWN));
		currencyPairRates.put("EURCZK", new BigDecimal(27.6028).setScale(4, RoundingMode.UP));
		currencyPairRates.put("EURDKK", new BigDecimal(7.4405).setScale(4, RoundingMode.DOWN));
		currencyPairRates.put("EURNOK", new BigDecimal(8.6651).setScale(4, RoundingMode.DOWN));
	}

	public static ListOfCurrencies[] getCurrencies() {
		return ListOfCurrencies.values();
	}

	public Map<String, Integer> getCurrencyPrecision() {
		return this.currencyPrecisionRequired;
	}

	public Map<String, BigDecimal> getCurrencyPairRates() {
		return this.currencyPairRates;
	}

	/*
	 * Method to get currency rates either directly or through inversion.
	 */
	public BigDecimal getCurrencyRates(String fromCurrency, String toCurrency) {
		BigDecimal rate = this.currencyPairRates.get(fromCurrency + toCurrency);
		if (rate == null) {
			rate = this.getCurrencyPairRates().get(toCurrency + fromCurrency);
			if (rate != null) {
				rate = new BigDecimal(1).divide(rate, 10, RoundingMode.DOWN);
			}
		}
		return rate;

	}
}
