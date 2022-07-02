package com.cg.Definition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.cg.pageObjects.EducationalObjects;
import com.cg.pageObjects.PersonalObjects;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefination {

	WebDriver driver1,driver2;
	EducationalObjects step2;
	PersonalObjects step1;
	
	
	
	
	
	@Given("^Page is displaying all the detail$")
	public void page_is_displaying_all_the_detail() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");
		driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver1.get("file:///C:/Users/Raghav%20Goyal/Downloads/PersonalDetails.html#");
		
		
		
		
	    //throw new PendingException();
	}

	@Given("^Register Me tag is showing$")
	public void register_Me_tag_is_showing() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		step1=new PersonalObjects(driver1);
		//step1.fillWrong();
		step1.fillDetails();
	    //throw new PendingException();
	}
	
	

	@When("^Filling all the details$")
	public void filling_all_the_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^Details are filling$")
	public void details_are_filling() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^check if next button is validated$")
	public void check_if_next_button_is_validated() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^All the fields entered$")
	public void all_the_fields_entered() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Submission Success$")
	public void submission_Success() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Given("^Page is displaying the Details$")
	public void page_is_displaying_the_Details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Given("^Linker tag is shown$")
	public void linker_tag_is_shown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^Fill all the details$")
	public void fill_all_the_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^All the restrictions are there$")
	public void all_the_restrictions_are_there() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
	}

	@Then("^checking if next button is validating$")
	public void checking_if_next_button_is_validating() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^All the fields get entered$")
	public void all_the_fields_get_entered() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Going to the next page$")
	public void going_to_the_next_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Given("^User has valid Phone Number$")
	public void user_has_valid_Phone_Number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User enters (\\d+) and clicks on Next button$")
	public void user_enters_and_clicks_on_Next_button(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Popup not Occured$")
	public void popup_not_Occured() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Given("^User has invalid Phone Number$")
	public void user_has_invalid_Phone_Number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^Popup Occured$")
	public void popup_Occured() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Given("^User has valid Email ID$")
	public void user_has_valid_Email_ID() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User enters abc@gmail\\.com and clicks on Next buttonC$")
	public void user_enters_abc_gmail_com_and_clicks_on_Next_buttonC() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User enters abc(\\d+)@gmail\\.com and clicks on Next buttonC$")
	public void user_enters_abc_gmail_com_and_clicks_on_Next_buttonC(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Given("^User has invalid Email ID$")
	public void user_has_invalid_Email_ID() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User enters abcgmail\\.com and clicks on Next button$")
	public void user_enters_abcgmail_com_and_clicks_on_Next_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User enters abc(\\d+)@gmailcom and clicks on Next button$")
	public void user_enters_abc_gmailcom_and_clicks_on_Next_button(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User enters abc(\\d+)gmailcom and clicks on Next button$")
	public void user_enters_abc_gmailcom_and_clicks_on_Next_button1(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	
	
	//second methods:
	
	

	
}
