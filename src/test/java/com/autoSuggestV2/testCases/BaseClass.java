package com.autoSuggestV2.testCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void setUp(String br) throws MalformedURLException
	{
		String host="selenium-hub";
		DesiredCapabilities dc= new DesiredCapabilities();
		if(br.equalsIgnoreCase("chrome"))
		{
			dc.setBrowserName(BrowserType.CHROME);
			
			
		}else if(br.equalsIgnoreCase("firefox"))
		{
			dc.setBrowserName(BrowserType.FIREFOX);
			
		}
		/*if(br.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}else if (br.equals("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		}else
		{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		}*/
		
		/*if(host=="HUB_HOST")
		{
			host="selenium-hub";
			
		}*/
		String completeURL="http://"+host+":4444/wd/hub";
		System.out.println(completeURL);
 		driver=new RemoteWebDriver(new URL(completeURL), dc);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {

		driver.quit();

	}

	public WebElement externalWait(int secs, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}

}
