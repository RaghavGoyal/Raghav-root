package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Registrationform 
{
  public Registrationform(WebDriver driver)
	{
	  PageFactory.initElements(driver,this);
	}
  @FindBy(how=How.NAME,using="userid")
  private WebElement txtUsrID;
  
  @FindBy(how=How.ID,using="pwd")
  private WebElement txtPassword;
  
  @FindBy(how=How.ID,using="usrname")
  private WebElement txtusrname;
  
  @FindBy(how=How.ID,using="addr")
  private WebElement txtadd;
  
  @FindBy(how=How.NAME,using="input[value='AF']")
  private WebElement aus;
  @FindBy(how=How.NAME,using="input[value='AL']")
  private WebElement can;
  @FindBy(how=How.NAME,using="input[value='DZ']")
  private WebElement ind;
  @FindBy(how=How.NAME,using="input[value='AS']")
  private WebElement rus;
  @FindBy(how=How.NAME,using="input[value='AD']")
  private WebElement usa;
  
  @FindBy(how=How.NAME,using="zip")
  private WebElement zip;
  
  @FindBy(how=How.NAME,using="email")
  private WebElement txtemail;
  
  @FindBy(how=How.CSS,using="input[value='Male']")
  private WebElement GenMale;
  @FindBy(how=How.CSS,using="input[value='Female']")
  private WebElement GenFemale;
  
  @FindBy(how=How.CSS,using="input[value='English']")
  private WebElement Eng;
  @FindBy(how=How.CSS,using="input[value='Non English']")
  private WebElement NonEng;
  
  @FindBy(how=How.ID,using="desc")
  private WebElement about;
  
  @FindBy(how=How.NAME,using="submit")
  private WebElement btnsubmit;
  
  public void enterUserId(String uid)
  {
	  txtUsrID.sendKeys(uid);
  }
  public void enterPassword(String pwd)
  {
	  txtPassword.sendKeys(pwd);
  }
  public void enterUsername(String uname)
  {
	  txtusrname.sendKeys(uname);
  }
  public void enterAddress(String add)
  {
	  txtadd.sendKeys(add);
  }
  public void enterCountry1( )
  {
	  aus.click();
  }
  public void enterCountry2( )
  {
	  can.click();
  }
  public void enterCountry3( )
  {
	  ind.click();
  }
  public void enterCountry4( )
  {
	  rus.click();
  }
  public void enterCountry5()
  {
	  usa.click();
  }
  public void enterZipcode(CharSequence[] zipcode)
  {
	  zip.sendKeys(zipcode);
  }
  public void enterEmail(String email)
  {
	  txtemail.sendKeys(email);
  }
  public void enterGender1( )
  {
	  GenMale.click();
  }
  public void enterGender2( )
  {
	  GenFemale.click();
  }
  public void enterLanguage1( )
  {
	  Eng.click();
  }
  public void enterLanguage2( )
  {
	  NonEng.click();
  }
  public void enterAbout(String abt )
  {
	  about.sendKeys(abt);
  }
  public void enterSubmit( )
  {
	  btnsubmit.click();
  }
  public void clickOnTab()
  {
	  txtUsrID.sendKeys(Keys.TAB);
  }
  public void CheckUserIdFormat()
  {
	  String pattern ="^[A-Z] [A-Za-z]{5,12}+[0-9]+$";
	  if(txtUsrID.getAttribute("value").matches(pattern))
		  System.out.println("Correct userID");
	  else
		  System.out.println("Incorrect userID");
  }
  public void CheckPasswordFormat()
  {
	  String pattern ="^[A-Z] [A-Za-z]{7,12}+[0-9]+$";
	  if(txtPassword.getAttribute("value").matches(pattern))
		  System.out.println("Correct password");
	  else
		  System.out.println("Incorrect password");
  }
  public void CheckUsernameFormat()
  {
	  String pattern ="^[a-z0-9_-]$";
	  if(txtPassword.getAttribute("value").matches(pattern))
		  System.out.println("Correct username");
	  else
		  System.out.println("Incorrect username");
  }
  public void CheckAddressFormat()
  {
	  String pattern ="^[A-Z] [A-Za-z]+[0-9]+$";
	  if(txtPassword.getAttribute("value").matches(pattern))
		  System.out.println("Correct address");
	  else
		  System.out.println("Incorrect address");
  }
  public void CheckZipcodeFormat()
  {
	  String pattern ="^[0-9]{5}(?:-[0-9]{4})?$";
	  if(txtPassword.getAttribute("value").matches(pattern))
		  System.out.println("Correct zipcode");
	  else
		  System.out.println("Incorrect zipcode");
  }
  public void CheckEmail()
  {
	  String pattern ="^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
	  if(txtemail.getAttribute("value").matches(pattern))
		  System.out.println("Correct email");
	  else
		  System.out.println("Incorrect email");
  }
  public void fill_details()
  {
	  enterUserId("NK");
	  clickOnTab();
	  enterPassword("qwerty");
	  enterGender2();
	  enterSubmit();
  }
}