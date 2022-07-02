package samplePackage;

import java.util.List;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;

public class EmailRegisteration {

	/**
	 * @param args
	 */
	//static WebDriver browser;
	//static String url="google.com";
	static String exptTitle="Email Registration Form";
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver browser=new ChromeDriver();
		browser.get("file:///C:/Users/Raghav%20Goyal/Desktop/capg_java/Module%204/BDD/Demos/Lesson%205-HTML%20Pages/WorkingWithForms.html");
		//String actualTitle=browser.getTitle();
		
		if(browser.getTitle().equals(exptTitle))
		{
			System.out.println("Verification Successful");
		}
		else
			System.out.println("Verification Failed");
		 
		
		//toTerminateBrowser();
		
		//toLaunchIE();
		//browser.get(url);
		if(browser.getTitle().equals(exptTitle))
		{
			System.out.println("Verification Successful");
		}
		else
			System.out.println("Verification Failed");
		boolean verifyText=browser.getPageSource().toLowerCase().contains("email registration");
		if(verifyText)
		{
			System.out.println("correct page");
		}
		
		//Actions action=new Actions(browser);
		//action.contextClick(browser.findElement(By.id("txtUserName"))).sendKeys(Keys.ARROW_DOWN).build().perform();
		//action.contextClick(browser.findElement(By.id("txtUserName"))).sendKeys(Keys.TAB).build().perform();
		
		browser.findElement(By.cssSelector("input#txtUserName")).sendKeys("nirmpandey");
		//Thread.sleep(5000);
		browser.findElement(By.cssSelector("input[name=txtPwd]")).sendKeys("GLBajaj");
		//actions.contextClick(browser.findElement(By.id("ConfPassword"))).sendKeys(Keys.TAB).build().perform();
		browser.findElement(By.cssSelector("input.Format")).sendKeys("GLBajaj");
		//String cmfPwd=browser.findElement(By.cssSelector("input[type=text]")).getAttribute("value");
		//System.out.println(cmfPwd);
		//appends the text to the username field.
		String cmfPwd=browser.findElement(By.cssSelector("input[id=txtFirstName]")).getAttribute("value");
		browser.findElement(By.xpath("//input[@id='txtLastName']")).sendKeys("pandey");
		
		//to clear data:
		browser.findElement(By.cssSelector("input.Format")).clear();
		browser.findElement(By.cssSelector("input.Format")).sendKeys("GLBajaj");
		List<WebElement> gender=browser.findElements(By.name("gender"));
		gender.get(0);
		Thread.sleep(5000);
		gender.get(1);
		
		
		
		
		
		toTerminateBrowser();
		
		
		
		
	}
	
	
	 static void toLaunchChrome()
	 {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		//browser=new ChromeDriver();
	 }
	 
	 static void toLaunchIE()
	 {
		System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe");
		//browser=new InternetExplorerDriver();
	 }
	 
	 static void toTerminateBrowser()
	 {
		// browser.close();
	 }
	 
	 

}
