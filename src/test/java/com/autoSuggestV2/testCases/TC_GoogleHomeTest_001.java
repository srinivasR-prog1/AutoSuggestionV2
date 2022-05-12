package com.autoSuggestV2.testCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autoSuggestV2.pageObject.GoogleHomePage;

public class TC_GoogleHomeTest_001 extends BaseClass {
	
	@Parameters({"keyword","indexvalue"})
	@Test
	public void HomepageTest(String keywordname,String indexvaluename)
	{
		
		GoogleHomePage gp=new GoogleHomePage(driver);
		gp.searchValue(keywordname);
		gp.clickElement(indexvaluename);
		
		
		
	}

}
