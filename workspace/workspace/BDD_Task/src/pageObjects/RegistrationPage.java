package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	public RegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(how=How.ID,using="userID")
	private WebElement txtUserID;
	
	@FindBy(how=How.ID,using="passid")
	private WebElement txtPswd;
	
	@FindBy(how=How.ID,using="usrname")
	private WebElement username;
	
	@FindBy(how=How.NAME,using="address")
	private WebElement address;
	
	@FindBy(how=How.CSS,using="option[value='AF']")
	private WebElement Australia;
	
	@FindBy(how=How.CSS,using="option[value='AL']")
	private WebElement Canada;
	
	@FindBy(how=How.CSS,using="option[value='DZ']")
	private WebElement India;
	
	@FindBy(how=How.CSS,using="option[value='AS']")
	private WebElement Russia;
	
	@FindBy(how=How.CSS,using="option[value='AD']")
	private WebElement USA;
	
	@FindBy(how=How.NAME,using="zip")
	private WebElement zip;
	
	@FindBy(how=How.NAME,using="email")
	private WebElement email;
	
	@FindBy(how=How.CSS,using="input[value='Male']")
	private WebElement gendermale;
	
	@FindBy(how=How.CSS,using="input[value='Female']")
	private WebElement genderfemale;
	
	@FindBy(how=How.NAME,using="en")
	private WebElement english;
	
	@FindBy(how=How.NAME,using="noen")
	private WebElement noenglish;
	
	@FindBy(how=How.ID,using="desc")
	private WebElement about;
	
	@FindBy(how=How.NAME,using="submit")
	private WebElement submit;
	
	public void enterUserID(String id)
	{
		txtUserID.sendKeys(id);
	}
	
	public void enterPassword(String pwd)
	{
		txtPswd.sendKeys(pwd);
	}
	
	public void enterName(String name)
	{
		username.sendKeys(name);
	}
	
	public void enterAddress(String add)
	{
		address.sendKeys(add);
	}
	
	public void selectAustralia()
	{
		Australia.click();
	}
	
	public void selectCanada()
	{
		Canada.click();
	}
	
	public void selectIndia()
	{
		India.click();
	}
	
	public void selectRussia()
	{
		Russia.click();
	}
	
	public void selectUSA()
	{
		USA.click();
	}
	
	public void enterZip(String a)
	{
		zip.sendKeys(a);
	}
	
	public void enterEmail(String e)
	{
		email.sendKeys(e);
	}
	
	public void selectMale()
	{
		gendermale.click();
	}
	
	public void selectFemale()
	{
		genderfemale.click();
	}
	
	public void selectEnglish()
	{
		english.click();
	}
	
	public void selectNoEnglish()
	{
		noenglish.click();
	}
	
	
	public void enterAbout(String id)
	{
		about.sendKeys(id);
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
	
	public void CheckPasswordFormat()
	{
		//String pattern="^[A-Z][A-Za-z]+[0-9]+$";
		String pattern=".{7,12}";
		if(txtPswd.getAttribute("value").matches(pattern))
		{
			System.out.println("Correct Password");
		}
		else
			System.out.println("Password do not match all requirements");
	}
	
	public void CheckUserID()
	{
		String pattern="^[A-Za-z]{5,12}$";
		if(txtUserID.getAttribute("value").matches(pattern))
		{
			System.out.println("Correct username");
		}
		else
			System.out.println("username do not match all requirements");
	}
	
	 public void CheckUsernameFormat()
	  {
		  String pattern ="^[a-z0-9_-]$";
		  if(username.getAttribute("value").matches(pattern))
			  System.out.println("Correct username");
		  else
			  System.out.println("Incorrect username");
	  }
	  public void CheckAddressFormat()
	  {
		  String pattern ="^[A-Z] [A-Za-z]+[0-9]+$";
		  if(address.getAttribute("value").matches(pattern))
			  System.out.println("Correct address");
		  else
			  System.out.println("Incorrect address");
	  }
	  public void CheckZipcodeFormat()
	  {
		  String pattern ="^[0-9]{5}(?:-[0-9]{4})?$";
		  if(zip.getAttribute("value").matches(pattern))
			  System.out.println("Correct zipcode");
		  else
			  System.out.println("Incorrect zipcode");
	  }
	  public void CheckEmail()
	  {
		  String pattern ="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		  if(email.getAttribute("value").matches(pattern))
			  System.out.println("Correct email");
		  else
			  System.out.println("Incorrect email");
	  }
	
	public void clickOnTab()
	{
		txtUserID.sendKeys(Keys.TAB);
	}
	
	public void fillDetails()
	{
		enterUserID("cg001");
		clickOnTab();
		enterPassword("cg01");
		selectMale();
		enterAbout("Hello");
		clickSubmit();
		
	}
	
}
