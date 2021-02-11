package com.epam.autothon.webtest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.epam.autothon.Constants;
import com.epam.autothon.Utilities.ApplicationProperties;
import com.epam.autothon.Utilities.LoggerProperties;
import com.epam.autothon.framework.DriverManager;
import com.epam.autothon.framework.DriverManagerFactory;
import com.epam.autothon.framework.DriverType;


public abstract class BaseTest {
    protected ApplicationProperties appProperties;
    protected WebDriver driver;
    private DriverManager driverManager;
    private DriverType driverType;
    final Logger logger;



    public BaseTest() {
        
       // logger = LoggerProperties.getInstance();
        logger = Logger.getLogger("devpinoyLogger");
        PropertyConfigurator.configure("log4j.properties");
        //setBrowserType();
    }
    
   

    @BeforeTest(description = "set up the environment")  
    @Parameters( {"environment","browser"} )
    public void setup(String environment, String browser) {
    	appProperties = ApplicationProperties.getInstance(environment);
    	
    	switch ( environment) {
    		case "web":
    			setBrowserType( browser);
    			driverManager = DriverManagerFactory.getDriverManager(driverType);
    			driver = driverManager.getDriver();
    			break;
    		
    		case "mobile":
    			break;
    			
    		case "api":
    			break;
    			
    			
    	}
    		
    			
    }
    

    @BeforeTest(dependsOnMethods = "setup", description = "Adds implicit wait")
    public void configureWaitTimes() {
        int implicitWaitTime = Integer.parseInt(appProperties.getProperty(Constants.IMPLICIT_WAIT_TIME));
        long pageloadWaitTime = Integer.parseInt(appProperties.getProperty(Constants.PAGE_LOAD_WAIT_TIME));
        driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageloadWaitTime, TimeUnit.SECONDS);
    }

    @BeforeTest(dependsOnMethods = "setup", description = "Maximizes the browser")
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    @AfterTest(description = "Stop Browser")
    public void stopBrowser() {
        driverManager.quit();
    }

    protected void setBrowserType(String browserString) {
       //String browserString = appProperties.getProperty(Constants.BROWSER_NAME);
        if (browserString.equalsIgnoreCase("chrome")) {
            driverType = DriverType.CHROME;
        } else if (browserString.contains("firefox")) {
            driverType = DriverType.FIREFOX;
        } else if (browserString.equalsIgnoreCase("grid-chrome")) {
            driverType = DriverType.GRID_CHROME;
        } else {
            throw new AssertionError("Unsupported Browser");
        }
    }
}
