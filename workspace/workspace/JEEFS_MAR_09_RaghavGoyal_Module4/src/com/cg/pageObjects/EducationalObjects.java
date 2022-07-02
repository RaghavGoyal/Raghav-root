package com.cg.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EducationalObjects {


	public EducationalObjects(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.CSS,using="option[value='BTech']")
	private WebElement Btech;
	@FindBy(how=How.CSS,using="option[value='BE']")
	private WebElement BE;
	@FindBy(how=How.CSS,using="option[value='MCA']")
	private WebElement MCA;
	@FindBy(how=How.CSS,using="option[value='Mtech']")
	private WebElement MTech;
	@FindBy(how=How.CSS,using="option[value='BCA']")
	private WebElement BCA;

	@FindBy(how=How.ID,using="txtPercentage")
	private WebElement percentage;

	@FindBy(how=How.NAME,using="passingYear")
	private WebElement passingyear;

	@FindBy(how=How.NAME,using="projectName")
	private WebElement projectname;

	@FindBy(how=How.CSS,using="input[value='.Net']")
	private WebElement dotnet;

	@FindBy(how=How.CSS,using="input[value='Java']")
	private WebElement java;

	@FindBy(how=How.CSS,using="input[value='PHP']")
	private WebElement php;

	@FindBy(how=How.CSS,using="input[value='Other']")
	private WebElement other;

	@FindBy(how=How.ID,using="txtOtherTechs")
	private WebElement othertechnology;



	//methods creation end here 


	// input for the objects created 

	public void SelectBtech() {
	    Btech.click();
	}

	public void SelectBe() {
	BE.click();
	}
	public void SelectMca() {
	MCA.click();
	}
	public void SelectMtech() {
	MTech.click();
	}
	public void SelectBca() {
	BCA.click();
	}
	public void enterPercentage(String a) {
	percentage.sendKeys(a);
	}
	public void enterPassingyear(String b) {
	passingyear.sendKeys(b);
	}
	public void enterProjectname(String c) {
	projectname.sendKeys(c);
	}

	public void Techdotnet() {
	   dotnet.click();
	}
	public void Techjava() {
	   java.click();
	}

	public void Techphp() {
	   php.click();
	}
	public void Techother() {
	   other.click();
	}
	public void Othertech(String d) {
	othertechnology.sendKeys(d);
	}




	public void fill_details() {
	SelectBtech();
	enterPercentage("70");
	enterPassingyear("2014");
	enterProjectname("glbajaj");
	Techjava();
	Othertech("anything");	
	}
}
