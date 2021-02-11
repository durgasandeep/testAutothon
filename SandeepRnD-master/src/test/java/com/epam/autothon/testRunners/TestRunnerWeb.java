package com.epam.autothon.testRunners;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/web"},
        //plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter"},
        //tags={"@smoke"},
        glue={"stepDefinitions.Web"},
        monochrome = true
)

public class TestRunnerWeb {
                
                @BeforeClass
                public static void initialSetup() throws Exception{                                              
                	System.out.println("in before class");
                	//PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\Log4j.properties");
                }                              
                @After
                public static void tearDown() throws Exception {
                	
                }
}
