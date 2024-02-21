package pageObjects;
 
import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

import java.util.Set;
 
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.FindBy;
 
import utilityFiles.ExcelUtils;

import utilityFiles.ScrollDown;
 
public class WebDevelopmentPage extends BasePage{

	public WebDevelopmentPage(WebDriver driver) {

		super(driver);

	}

	//Locators WebElement

	@FindBy(xpath = "//button[@aria-label=\"Show more Language options\"]")WebElement showMoreLanguages;

	@FindBy(xpath = "//input[@type='search']")WebElement LanguageSearchBox;

	@FindBy(xpath = "//button[@aria-label=\"Search\"]")WebElement LanguageSearchButton;

	@FindBy(xpath = "(//span[text()='English'])[1]")WebElement EnglishLang;

	//@FindBY(xpath="(//span[text()='English']//parent::div//preceding-sibling::span)[1]")WebElement EnglishLang;

	@FindBy(xpath = "//span[contains(text(),'Apply')]")WebElement ApplyButton;

	@FindBy(xpath = "//label[@class=\"cds-checkboxAndRadio-label\"]//span[contains(text(),'Beginner')]")WebElement BeginnerLevel;

	@FindBy(xpath = "//h3[contains(@class,\"CommonCard-title\")]")List<WebElement> Headings;

	@FindBy(xpath = "(//h3[contains(@class,\"CommonCard-title\")])[1]")WebElement FirstHead;

	@FindBy(xpath = "(//h3[contains(@class,\"CommonCard-title\")])[2]")WebElement SecondHead;

	@FindBy(xpath = "(//p[contains(@class,\"cds-119 css-11uuo4b cds-121\")])[1]")WebElement Rating1;

	@FindBy(xpath = "(//p[contains(@class,\"cds-119 css-11uuo4b cds-121\")])[2]")WebElement Rating2;

	@FindBy(xpath ="(//div[contains(@class,'CommonCard-metadata')])[1]")WebElement Duration1;

	@FindBy(xpath ="(//div[contains(@class,'CommonCard-metadata')])[2]")WebElement Duration2;
 
			//@FindBy(xpath = "(//div[contains(@class,'CommonCard-metadata')]//p[contains(@class,'Typography-base css-dmxkm1')])[1]")WebElement Duration1;

			//@FindBy(xpath = "(//div[contains(@class,'CommonCard-metadata')]//p[contains(@class,'Typography-base css-dmxkm1')])[2]")WebElement Duration2;

	@FindBy(xpath = "//div[contains(@class,'ProductCard-content')][1]")WebElement FirstCard;

	@FindBy(xpath = "//h1[@data-e2e='hero-title']")WebElement FirstCardHead;

	@FindBy(xpath = "(//div[contains(@class,'cds-Typography-base css-h1jogs')])[3]")WebElement FirstCardRating;

	@FindBy(xpath = "(//div[contains(@class,'cds-Typography-base css-h1jogs')])[3]")WebElement FirstCardDuration;

	String Rate1 = "";

	@FindBy(xpath="(//div[@class=\"cds-296 cds-formGroup-groupWrapper\"])[3]")List<WebElement> Levels;

	@FindBy(xpath = "(//input[@type='text'])[1]")WebElement SearchBox;

	@FindBy(xpath = "//div[@data-e2e=\"NumberOfResultsSection\"]")WebElement SearchResult;

	@FindBy(xpath = "//a[@data-click-key=\"search.search.click.logo\"]")WebElement Logo;


	//Action Methods

	public void selectLanguage() throws InterruptedException {

		Thread.sleep(2000);

		Actions act = new Actions(driver);

		act.moveToElement(EnglishLang).click().build().perform();

		Thread.sleep(3000);

	}

	public void clickLogo() {

		Logo.click();

	}

	public void selectLevel() throws InterruptedException {

		BeginnerLevel.click();

		Thread.sleep(3000);

	}

 
	

	public void FirstNameRatingTime() throws IOException {

		String Head1 = FirstHead.getText();

		System.out.println("Course:" +Head1);

		String Rateing1 = Rating1.getText();

		System.out.println("Rating for First Course: "+Rateing1);

		String Duration = Duration1.getText();

		String [] arrDur = Duration.split("·");

			System.out.println("Duration:" +arrDur[2]);

			System.out.println("-------------------------------------");

			ExcelUtils excel = new ExcelUtils();

			String xlFile = System.getProperty("user.dir")+"\\testData\\testDataCoursera.xlsx";

			excel.setCellData(xlFile, "CoursesPage", 2, 0, Head1);

			excel.setCellData(xlFile, "CoursesPage", 2, 1, Rateing1);

			excel.setCellData(xlFile, "CoursesPage", 2, 2, arrDur[2]);

	}

	public void SecondNameRatingTime() throws IOException {

		String Head2 = SecondHead.getText();

		System.out.println("Course:" +Head2);

		String Rateing2 = Rating2.getText();

		System.out.println("Rating for Second Course: "+Rateing2);

		String Duration1 = Duration2.getText();

		String [] arrDur1 = Duration1.split("·");

			System.out.println("Duration:" +arrDur1[2]);

			System.out.println("-------------------------------------");

			ExcelUtils excel = new ExcelUtils();

			String xlFile = System.getProperty("user.dir")+"\\testData\\testDataCoursera.xlsx";

			excel.setCellData(xlFile, "CoursesPage", 3, 0, Head2);

			excel.setCellData(xlFile, "CoursesPage", 3, 1, Rateing2);

			excel.setCellData(xlFile, "CoursesPage", 3, 2, arrDur1[2]);

	}

	public void clickFirstCard() {

		FirstCard.click();

	}


	public void Search() throws InterruptedException {

		Thread.sleep(3000);

		SearchBox.clear();

		Thread.sleep(1000);

		SearchBox.clear();

		SearchBox.sendKeys("Language Learning");

		Actions act = new Actions(driver);

		act.sendKeys(Keys.ENTER).perform();

	}

	public void scrollScreen() {

		JavascriptExecutor js =(JavascriptExecutor)driver;

		js.executeScript("window.scrollBy(0,300)"," ");

	}

	public void searchResult() 

	{

		String NumberofCourses = SearchResult.getText();

		System.out.println("Number of Courses: "+NumberofCourses);

	}
 
 
}
