package com.autoSuggestV2.pageObject;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {

	public WebDriver driver;

	public GoogleHomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.NAME, using = "q")
	@CacheLookup
	WebElement searchBox;

	@FindBy(how = How.XPATH, using = "//div[@class='mkHrUc']//ul[@jsname='bw4e9b']/li")
	@CacheLookup
	List<WebElement> element;

	public void searchValue(String Value) {
		searchBox.clear();
		searchBox.sendKeys(Value);

	}

	public void clickElement(String searchElement) {

		for (int i = 0; i < element.size(); i++) {

			String text = element.get(i).getText();
			if (text.contains(searchElement)) {
				element.get(i).click();
				break;

			}

		}

	}

}
