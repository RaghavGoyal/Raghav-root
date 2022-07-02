package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	WebDriver driver;
	
	@Given("^Email registeration page is open$")
	public void email_registeration_page_is_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C://Users//Raghav%20Goyal//Desktop//capg_java//Module%204//BDD//Demos//Lesson%205-HTML%20Pages//WorkingWithForms.html");
	    throw new PendingException();
	}

	@When("^user enters valid password,confirm password and email$")
	public void user_enters_valid_password_confirm_password_and_email() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user clicks on submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^user's email is registered$")
	public void user_s_email_is_registered() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
