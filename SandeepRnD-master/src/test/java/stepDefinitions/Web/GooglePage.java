package stepDefinitions.Web;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GooglePage {
	

	@Given("I am at the google search page")
	public void i_am_at_the_google_search_page() {
	    System.out.println("on google home page");
	}
	
	@When("I enter text at {string} option")
	public void i_enter_text_at_option(String string) {
		 System.out.println("Entered string");
	}
	
	@When("I click on {string} button")
	public void i_click_on_button(String string) {
	   System.out.println("clicked on search button");
	
	}

}