package com.autoSuggestV2.testCases;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autoSuggestV2.pageObject.GoogleHomePage;
import com.autoSuggestV2.pageObject.GoogleSearchResultPage;

public class TC_SearchTest_001 extends BaseClass {
	
	@Parameters({"keyword","indexvalue","searchValue"})
	@Test
	public void searchPageTest(String keywordname,String indexvaluename,String searchvaluename)
	{
		GoogleHomePage gp=new GoogleHomePage(driver);
		GoogleSearchResultPage searchResult=new GoogleSearchResultPage(driver);
		gp.searchValue(keywordname);
		gp.clickElement(indexvaluename);		
		searchResult.clickLink();
		searchResult.elementPresent(searchvaluename);
		
		
		
	}

}
