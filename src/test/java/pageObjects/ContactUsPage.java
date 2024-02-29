package pageObjects;
 
import java.io.IOException;

import java.time.Duration;
 
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.Wait;

import org.openqa.selenium.support.ui.WebDriverWait;
 
import utilityFiles.ExcelUtils;

import utilityFiles.ScreenShots;
 
public class ContactUsPage extends BasePage{
 
	public ContactUsPage(WebDriver driver) {

		super(driver);

		// TODO Auto-generated constructor stub

	}

	@FindBy(xpath = "//input[@id='FirstName']") WebElement FirstName;

	@FindBy(xpath = "//input[@id='LastName']") WebElement LastName;

	@FindBy(xpath = "//input[@id='Email']") WebElement Email;

	@FindBy(xpath = "//input[@id='Phone']") WebElement Phone;

	@FindBy(xpath = "//select[@id='Institution_Type__c']") WebElement InstitutionType;

	@FindBy(xpath = "//input[@id='Company']") WebElement Instituitonname;

	@FindBy(xpath = "//select[@id='Title']") WebElement JobRole;

	@FindBy(xpath = "//select[@id='Department']") WebElement Department;

	@FindBy(xpath = "//select[@id='What_the_lead_asked_for_on_the_website__c']") WebElement needs;

	@FindBy(xpath = "//select[@id='Country']") WebElement country;

	@FindBy(xpath = "//button[@type='submit']") WebElement submit;

	@FindBy(xpath="//button[contains(@aria-label,'Close Drift Widget messenger preview overlay')]") WebElement popup;

	@FindBy(xpath = "//div[@id='ValidMsgEmail']") WebElement error;

	@FindBy(xpath="//iframe[@class='drift-frame-controller']") WebElement popupFrame;
 
	public String enterDetails() throws InterruptedException, IOException {

		ScreenShots ss = new ScreenShots(driver);

		//ContactUsPage cp = new ContactUsPage(driver);

		FirstName.sendKeys("Sayantika");

		LastName.sendKeys("Dholey");

		Email.sendKeys("asdfghjlopiuresdfrgcdfvgdgdefgdfgdc");

		Phone.sendKeys("9876543210");

		Select s1 = new Select(InstitutionType);

		s1.selectByIndex(2);

		Instituitonname.sendKeys("abs");

		Select s2 = new Select(JobRole);

		s2.selectByIndex(2);

		Select s3 = new Select(Department);

		s3.selectByIndex(2);

		Select s4 = new Select(needs);

		s4.selectByIndex(2);

		Select s5 = new Select(country);

		s5.selectByIndex(2);

		
		Thread.sleep(5000);
		driver.switchTo().frame(popupFrame);

		popup.click();

		driver.switchTo().defaultContent();

		submit.click();

		Thread.sleep(2000);

		String error_msg = error.getText();

		ExcelUtils excel = new ExcelUtils();

		String xlFile = System.getProperty("user.dir")+"\\testData\\testDataCoursera.xlsx";

		excel.setCellData(xlFile, "ErrorMsg", 1, 0, error_msg);

		ss.screenshot("Error");

		return error_msg;


	}



 
}
