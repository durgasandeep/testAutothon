package com.epam.autothon.Utilities;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.epam.autothon.Constants;

public class ApplicationProperties {
	
	private Properties properties;
	private static ApplicationProperties instance = null;
	public static ApplicationProperties getInstance(String propFileName){
		if (instance == null) {
            synchronized (ApplicationProperties.class) {
                if (instance == null) {
                    
					instance = new ApplicationProperties(propFileName);
                }
            }
        }
        return instance;
	}
	
	private ApplicationProperties(String propFile){
		FileReader reader;
		try {
			reader = new FileReader("src\\test\\resources\\properties\\"+propFile+".properties");
			properties = new Properties();
			properties.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	



	
	public String getProperty(String name){
		return properties.getProperty(name);
	}
}
