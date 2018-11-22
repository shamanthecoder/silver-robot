package com.coding.test.FxCalculator;

import java.util.NoSuchElementException;
import java.util.ServiceLoader;

import com.coding.test.FxCalculator.impl.FXConversionServiceImpl;
import com.coding.test.FxCalculator.service.FXConversionService;

/**
 * 
 * @author Shyamant
 *
 */

/*
 * Service provider class to load the services.
 */

public class FXServiceProvider {

	private static FXServiceProvider provider;
	private ServiceLoader<FXConversionService> loader;

	private FXServiceProvider() {
		loader = ServiceLoader.load(FXConversionService.class);
	}

	public static FXServiceProvider getInstance() {
		if (provider == null) {
			provider = new FXServiceProvider();
		}
		return provider;
	}

	public FXConversionService getService() {

		try {
			FXConversionService service = loader.iterator().next();
			if (service != null) {
				return service;
			} else {
				// return the instance of Impl as service loading might be failing due to config
				// errors while running.
				return new FXConversionServiceImpl();
			}
		} catch (NoSuchElementException ne) {
			// Service loading not working due to configuration errors in the project or
			// missing META-INF files.
			return null;
		}
	}
}
