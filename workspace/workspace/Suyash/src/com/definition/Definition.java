package com.definition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.RegistrationPage;

public class Definition {
	
	WebDriver driver;
	RegistrationPage mainpage;
	
	@Given("^Email Registration page open$")
	public void email_Registration_page_open() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("file:///C:/Users/Raghav%20Goyal/Downloads/RegistrationForm.html");
		
		String actualTitle= driver.getTitle();
		String expectedTitle="Welcome to JobsWorld";
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Verification successful");
		}
		else {
			System.out.println("Verification failed");
		}
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new PendingException();
	}

	@When("^User enters valid password, confirm password and email$")
	public void user_enters_valid_password_confirm_password_and_email() throws Throwable {
		
		mainpage=new RegistrationPage(driver);
		//Email And Password are Entered
		mainpage.fill_details();
		
		
	//PassWord format is Checked	
	
	mainpage.CheckPassWordFormat();
	
	    // Write code here that turns the phrase above into concrete actions
	 //   throw new PendingException();
	}

	@When("^User clicks on submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
		mainpage.submit();
	//mainpage.CheckId();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^User's email is registered$")
	public void user_s_email_is_registered() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

}
