package com.epam.autothon.framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.epam.autothon.Constants;
import com.epam.autothon.Utilities.ApplicationProperties;

public class ChromeDriverManager extends DriverManager {

	@Override
	protected void createDriver() {
		System.setProperty("webdriver.chrome.driver", 
				ApplicationProperties.getInstance(Constants.webTests).getProperty(Constants.CHROME_DRIVER_PATH));
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		instance = new ChromeDriver(capabilities);
	}
}
