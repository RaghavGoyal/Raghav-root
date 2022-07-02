package samplePackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class EmailRegisteration {
static WebDriver browser = null;
static String url="file:///C:/Users/Raghav%20Goyal/Desktop/capg_java/Module%204/BDD/Demos/Lesson%205-HTML%20Pages/WorkingWithForms.html";

public static void main(String[] args) throws InterruptedException {
toLaunchChrome();
browser.manage().window().maximize();
browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
browser.get(url);
String actualTitle=browser.getTitle();
String expectedTitle="Email Registration Forms";
if(actualTitle.equals(expectedTitle)) {
System.out.println("verification successful");
}
else
System.out.println("verification failed");
boolean verifyText=browser.getPageSource().toLowerCase().contains("email registration");

if(verifyText)
System.out.println("correct page");


Actions action=new Actions(browser);
action.contextClick	(browser.findElement(By.id("txtUserName"))).sendKeys(Keys.ARROW_DOWN).build().perform();
browser.findElement(By.cssSelector("input#txtUserName")).sendKeys("pradutta");
Thread.sleep(5000);
action.contextClick(browser.findElement(By.id("txtUserName"))).sendKeys(Keys.TAB).build().perform();
browser.findElement(By.cssSelector("input[name=txtPwd]")).sendKeys("glbajaj");
action.contextClick(browser.findElement(By.id("txtPassword"))).sendKeys(Keys.TAB).build().perform();
browser.findElement(By.cssSelector("input.Format")).sendKeys("glbajaj");
browser.findElement(By.cssSelector("input#txtFirstName")).sendKeys("pradutta");
String confPwd=browser.findElement(By.cssSelector("input#txtConfPassword")).getAttribute("value");
System.out.println(confPwd);
browser.findElement(By.xpath("//input[@id='txtLastName']")).sendKeys("kesharwani");	
browser.findElement(By.cssSelector("input.Format")).clear();
Alert alert=browser.switchTo().alert();
String alrtMsg=alert.getText();
System.out.println(alrtMsg);
alert.accept();

browser.findElement(By.cssSelector("input.Format")).sendKeys("glbajaj");
List<WebElement> gendr=browser.findElements(By.name("gender"));
gendr.get(0).click();
Thread.sleep(5000);
gendr.get(1).click();
browser.findElement(By.cssSelector("input#DOB")).sendKeys("10-06-2019");
browser.findElement(By.cssSelector("input#txtEmail")).sendKeys("praduttakesharwani86@gmail.com");
browser.findElement(By.cssSelector("input#txtAddress")).sendKeys("mathura");
browser.findElement(By.xpath("//select/option[@value='Pune']")).click();
browser.findElement(By.cssSelector("input#txtPhone")).sendKeys("123456789");
List<WebElement> hobby=browser.findElements(By.name("chkHobbies"));
hobby.get(1).click();

//terminateBrowser();
}
static void toLaunchChrome() {
System.setProperty("webdriver.chrome.driver","C:\\\\chromedriver.exe");
browser= new ChromeDriver();


}
static void toLaunchIE() {
System.setProperty("webdriver.IE.driver","C:\\\\IEDriverServer.exe");
browser= new InternetExplorerDriver();
//browser.get(url);

}
static void terminateBrowser() {
browser.close();

}
}