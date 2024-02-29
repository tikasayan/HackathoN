package testBase;

import java.io.FileReader;
 
import java.io.IOException;
 
import java.time.Duration;
 
import java.util.Properties;
 
import java.util.Scanner;
 
import org.apache.logging.log4j.LogManager;
 
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.Platform;

import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.chrome.ChromeDriver;
 
import org.openqa.selenium.chrome.ChromeOptions;
 
import org.openqa.selenium.edge.EdgeDriver;
 
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterTest;
 
import org.testng.annotations.BeforeTest;
 
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
 
	public Properties p;
	public Logger logger;
 
	Scanner sc;
 
	@BeforeTest(groups= {"sanity","regression","Master"})
 
	@Parameters({"os","browser"})
 
	public void setup(String os,String br) throws IOException, InterruptedException {
 
		//loading properties file
 
		FileReader file = new FileReader(".//src//test//resources//config.properties");
 
		p = new Properties();
 
		p.load(file);
 
 
		logger = LogManager.getLogger(this.getClass());
 
 
						//Switch Case to Choose the browser


		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
 
			 	{	
 
				DesiredCapabilities capabilities=new DesiredCapabilities();
 
				//os
 
				if(os.equalsIgnoreCase("windows"))
 
				{
 
					capabilities.setPlatform(Platform.WIN11);
 
				}
 
				else if(os.equalsIgnoreCase("mac"))
 
				{
 
					capabilities.setPlatform(Platform.MAC);
 
				}
 
				else
 
				{
 
					System.out.println("No matching os..");
 
					return;
 
				}
 
				//browser
 
				switch(br.toLowerCase())
 
				{
 
				case "chrome" : capabilities.setBrowserName("chrome"); break;
 
				case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
 
				default: System.out.println("No matching browser.."); return;
 
				}
 
				driver = new RemoteWebDriver(capabilities);
 
			    }
 
			else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
 
			{
 
				//launching browser based on condition - locally
 
				switch(br.toLowerCase())
 
				{
 
				case "chrome": driver=new ChromeDriver(); break;
 
				case "edge": driver=new EdgeDriver(); break;
 
				default: System.out.println("No matching browser..");
 
							return;
 
				}
 
			}
 
				driver.manage().deleteAllCookies();
 
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
				driver.get(p.getProperty("appURL"));
 
				driver.manage().window().maximize();
 
				Thread.sleep(3000);
 
			}
 
	@AfterTest(groups= {"sanity","regression","master"})
 
	public void tearDown() {
 
		driver.quit();
 
	}
 


 
}
