package com.cg.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PersonalObjects {
	
	 public PersonalObjects(WebDriver driver) {
		 PageFactory.initElements(driver,this);
	 }
	 
	 
	 //creating objects
	 
	 @FindBy(how=How.ID,using="txtFirstName")
		private WebElement FirstName;
	 
	 @FindBy(how=How.ID,using="txtLastName")
		private WebElement LastName;
	 
	 @FindBy(how=How.ID,using="txtEmail")
		private WebElement Email;
	 
	 @FindBy(how=How.ID,using="txtPhone")
		private WebElement Contact;
	 
	 @FindBy(how=How.ID,using="txtAddress1")
		private WebElement AddressL1;
	 
	 @FindBy(how=How.ID,using="txtAddress2")
		private WebElement AddressL2;
	 
	 @FindBy(how=How.CSS,using="option[value='Pune']")
		private WebElement Pune;
	 
	 @FindBy(how=How.CSS,using="option[value='Bangalore']")
		private WebElement Banglore;
	 
	 @FindBy(how=How.CSS,using="option[value='Chennai']")
		private WebElement Chennai;
	 
	 @FindBy(how=How.CSS,using="option[value='Hydrabad']")
		private WebElement Hydreabad;
	 
	 @FindBy(how=How.CSS,using="option[value='Maharashtra']")
		private WebElement Maharashtra;
	 
	 @FindBy(how=How.CSS,using="option[value='Karnataka']")
		private WebElement Karnataka;
	 
	 @FindBy(how=How.CSS,using="option[value='Tamilnadu']")
		private WebElement Tamilnadu;
	 
	 @FindBy(how=How.CSS,using="option[value='Telangana']")
		private WebElement Telangana;
	 
	 @FindBy(how=How.CSS,using="a[href='#']")
		private WebElement Next;

	
	 
	 
	 //creating input methods:
	 
	 
	 public void setFirstName(String firstName) {
			FirstName.sendKeys(firstName);
		}

		public void setLastName(String lastName) {
			LastName.sendKeys(lastName);
		}

		public void setEmail(String email) {
			Email.sendKeys(email);
		}

		public void setContact(String contact) {
			Contact.sendKeys(contact);
		}

		public void setAddressL1(String addressL1) {
			AddressL1.sendKeys(addressL1);
		}

		public void setAddressL2(String addressL2) {
			AddressL2.sendKeys(addressL2);
		}

		public void setPune() {
			Pune.click();
		}

		public void setBanglore() {
			Banglore.click();
		}

		public void setChennai() {
			Chennai.click();
		}

		public void setHydreabad() {
			Hydreabad.click();
		}

		public void setMaharashtra() {
			Maharashtra.click();
		}

		public void setKarnataka() {
			Karnataka.click();
		}

		public void setTamilnadu() {
			Tamilnadu.click();
		}

		public void setTelangana() {
			Telangana.click();
		}
		
		public void clickNext()
		{
			Next.click();
		}
	 
	 // Filling details to the form:
		
		public void fillDetails()
		{
			setFirstName("Raghav");
			setLastName("Goyal");
			setEmail("raghavgoyal.325@gmail.com");
			setContact("7536073024");
			setAddressL1("Krishna Nagar");
			setAddressL2("Mathura");
			setBanglore();
			setKarnataka();
			clickNext();
			
		}
		
		public void fillWrong()
		{
			setFirstName(" ");
			
		}
		
		
	 

}
