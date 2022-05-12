package com.autoSuggestV2.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultPage {
	public WebDriver driver;

	public GoogleSearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(how=How.XPATH,using="//a[text()='News']")
	@CacheLookup
    WebElement linkElement;	
	
	
	@FindBy(how=How.PARTIAL_LINK_TEXT,using="Localhost")
	@CacheLookup
    WebElement linkText;
	
//	@FindBy(how=How.XPATH,using="//div[@class='mCBkyc y355M JQe2Ld nDgy9d']")
	@FindBy(how=How.XPATH,using="//div[contains(@class,'mCBkyc y355M JQe2Ld')]")
	@CacheLookup
    List<WebElement> geekElement;
	
	public void clickLink()
	{
		
		linkElement.click();
		
	}
	
	public void elementPresent(String searchText) {		
		

		for (int i = 0; i < geekElement.size(); i++) {

			String geekText = geekElement.get(i).getText();
			
			if (geekText.contains(searchText)) {
				System.out.println(geekText);
				break;

			}

		}

	}	
	

}
