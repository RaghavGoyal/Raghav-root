package com.cg.nt.login;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTitle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://NewTours.demoaut.com");
		String expTitle="Welcome: Mercury Tours";
		String orgTitle=driver.getTitle();
		
		if(orgTitle.equals(expTitle))
		{
			System.out.println("true");
		}
		WebElement uname=driver.findElement(By.name("userName"));
		uname.sendKeys("mars");
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("mars");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.name("findFlights")).click();
		driver.findElement(By.name("reserveFlights")).click();
		
		WebElement firstName=driver.findElement(By.name("passFirst0"));
		firstName.sendKeys("Raghav");
		WebElement lastName=driver.findElement(By.name("passLast0"));
		lastName.sendKeys("Goyal");
		driver.findElement(By.name("buyFlights")).click();
		
		//Alert alert=driver.switchTo().alert();.sendKeys("hello from alert box").accept();
		
		//driver.close();//close single window instance
		//driver.quit(); to close all instances.
		
		
		
	}

}
