package com.epam.autothon.framework;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.autothon.Constants;
import com.epam.autothon.Utilities.ApplicationProperties;

public class FirFoxDriverManager extends DriverManager{

	@Override
	protected void createDriver() {
		System.setProperty("webdriver.gecko.driver", 
				ApplicationProperties.getInstance(Constants.webTests).getProperty(Constants.GECKO_DRIVER_PATH));
		
		// if required, firefox profile can be set here. 
		instance = new FirefoxDriver();
	}
	
}
