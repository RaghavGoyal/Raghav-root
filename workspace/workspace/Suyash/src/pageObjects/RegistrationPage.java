package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	 public RegistrationPage(WebDriver driver) {
		 PageFactory.initElements(driver,this);
		 
	 }
	@FindBy(how=How.ID,using="usrID")
	private WebElement txtUsrID;

	@FindBy(how=How.NAME,using="passid")
	private WebElement txtPswrd;

	@FindBy(how=How.NAME,using="username")
	private WebElement txtNAME;
	
	@FindBy(how=How.ID,using="addr")
	private WebElement txtAddr;
	
	@FindBy(how=How.NAME,using="zip")
	private WebElement txtzip;
	
	@FindBy(how=How.CSS,using="option[value='AF']")
	private WebElement cuntyAus;
	@FindBy(how=How.CSS,using="option[value='CL']")
	private WebElement cuntryCnd;
	@FindBy(how=How.CSS,using="option[value='DZ']")
	private WebElement cuntryInd;
	@FindBy(how=How.CSS,using="option[value='AS']")
	private WebElement cuntryRuss;
	@FindBy(how=How.CSS,using="option[value='AD']")
	private WebElement cuntryUs;
	
	@FindBy(how=How.NAME,using="email")
	private WebElement txtEmail;
	
	@FindBy(how=How.CSS,using="input[value='Male']")
	private WebElement Genmale;
	
	@FindBy(how=How.CSS,using="input[value='Female']")
	private WebElement GenFemale;
	
	@FindBy(how=How.CSS,using="input[value='en']")
	private WebElement langEnglish;
	
	@FindBy(how=How.CSS,using="input[value='noen']")
	private WebElement langNonEnglish;
	
	@FindBy(how=How.ID,using="desc")
	private WebElement description;
	
	@FindBy(how=How.NAME,using="submit")
	private WebElement Submit;
	
 //methods creation end here 
	
	
	// input for the objects created 
	
	
	public void enterUserID(String uid) {
		txtUsrID.sendKeys(uid);
	}
	public void enterUserPswrd(String pws) {
		txtPswrd.sendKeys(pws);
	}
	public void enterUserName(String Name) {
		txtNAME.sendKeys(Name);
	}
	public void enterUserAddr(String Addr) {
		txtAddr.sendKeys(Addr);
	}
	public void enterZip(String zip) {
		txtzip.sendKeys(zip);
	}
	
	public void enterEmail(String mail) {
		txtEmail.sendKeys(mail);
	}
	public void enterAus() {
		    cuntyAus.click();
	}
	
	public void enterCnd() {
	    cuntryCnd.click();
    }
	public void enterInd() {
	    cuntryInd.click();
    }
	public void enterRuss() {
	    cuntryRuss.click();
   }
	public void enterUs() {
	    cuntryUs.click();
   }
	
	public void GenderM() {
	    Genmale.click();
   }
	public void GenderFm() {
	    GenFemale.click();
   }
	
	public void LangEng() {
	    langEnglish.click();
   }
	public void LangNonEng() {
	    langNonEnglish.click();
   }
	public void desc(String Des) {
		description.sendKeys(Des);
	}
	public void submit() throws InterruptedException {
		 Thread.sleep(5000);
	    Submit.click();
	    
 		
    }
   public void clicKOnTab() {txtUsrID.sendKeys(Keys.TAB);
   }
   
   
			
		

		
		
	
	
	public void CheckPassWordFormat() {
		String pattern = "^[A-Z]+[A-Za-z]+[0-9]+$";
		if(txtPswrd.getAttribute("value").matches(pattern)) {
			System.out.println("Password Is in Correct Format");
		}
		else {
			System.out.println("Password Is Not In Correct Format");
		}
			
	}
	
	public void fill_details() {
		enterUserID("Vi");
		enterUserPswrd("Villain201");
		enterUserName("Raghav Goyal");
		enterUserAddr("Krishna Nagar Mathura");
		enterZip("207001");
		enterEmail("raghavgoyal.325@gmail.com");
		enterAus();	
		GenderM();
		LangNonEng();
		desc("Check the Entered Data");
		
	}
	
	//String alertMessage=driver.switchTo().alert().getText().toString();
	//System.out.println(alertMessage);
	
	List<webElement> hobby=driver.findElements(By.name("checkHobbies"));
	System.out.println();
	

	

}
