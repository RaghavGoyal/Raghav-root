package com.step;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.RegistrationPage;

public class Steps {
	WebDriver driver;
	RegistrationPage mainpage;
	
	
	@Given("^User Registartion page is open$")
	public void user_Registartion_page_is_open() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("file:///C://Users//Raghav%20Goyal//Downloads//RegistrationForm.html");
	    //throw new PendingException();
	}

	@When("^User enters username,password and other details$")
	public void user_enters_username_password_and_other_details() throws Throwable {
		driver.findElement(By.name("userid")).sendKeys("NK");
		driver.findElement(By.id("pwd")).sendKeys("qwerty");
		driver.findElement(By.id("usrname")).sendKeys("Nidhi Keshri");
		driver.findElement(By.id("addr")).sendKeys("Greater Noida");
		driver.findElement(By.xpath("//select/option[@value='DZ']")).click();
		driver.findElement(By.name("zip")).sendKeys("201306");
		driver.findElement(By.name("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@value='Female']")).click();
		//driver.findElement(By.xpath("//input[@value='Non English']")).click();
		driver.findElement(By.id("desc")).sendKeys("Hello");
	    driver.findElement(By.name("submit")).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User clicks on Submit button$")
	public void user_clicks_on_Submit_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^User is registered$")
	public void user_is_registered() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}
}

