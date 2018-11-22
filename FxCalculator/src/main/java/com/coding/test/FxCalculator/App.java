package com.coding.test.FxCalculator;

import java.math.BigDecimal;
import java.util.Scanner;

import com.coding.test.FxCalculator.Exception.UnsupportedCurrencyConversionException;
import com.coding.test.FxCalculator.impl.FXConversionServiceImpl;
import com.coding.test.FxCalculator.service.FXConversionService;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * Main class and entry point to the application. This class takes user input
 * and invokes necessary service to get the results.
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Welcome to Fx converter application which does currency conversion.");
		System.out.println("Example input: AUD 100.00 in USD");
		System.out.println("Enter EXIT to end the application run");
		Scanner scan = new Scanner(System.in);
		while (true) {
			String inputString = scan.nextLine();
			System.out.println();
			if (inputString.equalsIgnoreCase("EXIT"))
				break;
			String[] input = inputString.split(" ");
			// validate the input
			if (isInvalidInput(input))
				continue;
			FXConversionService fXService = FXServiceProvider.getInstance().getService();
			if (fXService == null)
				/*
				 * In case service loading is failing due to misconfiguration,instantiate the
				 * Impl class and invoke the method.
				 */
				fXService = new FXConversionServiceImpl();
			try {
				BigDecimal result = fXService.convert(input[0].toUpperCase(), input[3].toUpperCase(),
						new BigDecimal(input[1]));
				System.out.println(input[0] + " " + input[1] + " = " + input[3] + " " + result);
				System.out.println();
			} catch (UnsupportedCurrencyConversionException e) {
				System.out.println(e.getMessage());
				System.out.println();
			}

		}
		scan.close();
	}

	/*
	 * Validation of the input at the console
	 */

	private static boolean isInvalidInput(String[] input) {
		if (input.length < 4) {
			System.out.println("Invalid input\n");
			return true;
		}
		try {
			BigDecimal.valueOf(Double.parseDouble(input[1]));
		} catch (NumberFormatException ne) {
			System.out.println("Invalid input\n");
			return true;
		}

		return false;

	}
}
