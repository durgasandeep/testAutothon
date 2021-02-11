package com.epam.autothon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.epam.autothon.Constants;
import com.epam.autothon.framework.BasePage;


public class HomePage extends BasePage{
	
	@FindBy(className = "topic-html-content-header")
	private WebElement headerText; 
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	 public static HomePage using(WebDriver driver) {
	        return new HomePage(driver);
	    }

	public String getHeaderText(){
		return headerText.getText();
	}

	@Override
	protected void setPageproperties() {
		this.pageTitle = Constants.TITLE_HOME_PAGE;
		this.pageUrl = Constants.URL_HOME_PAGE;
	}
}
