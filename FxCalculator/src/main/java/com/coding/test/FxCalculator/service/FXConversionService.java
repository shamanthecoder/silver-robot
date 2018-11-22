package com.coding.test.FxCalculator.service;

import java.math.BigDecimal;

import com.coding.test.FxCalculator.Exception.UnsupportedCurrencyConversionException;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * Interface for Fx conversion.
 * 
 */

public interface FXConversionService {

	public BigDecimal convert(String from, String to, BigDecimal value) throws UnsupportedCurrencyConversionException;

}
