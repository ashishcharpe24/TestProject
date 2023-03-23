package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.PreReq;
import com.qa.pages.searchPage;

public class searchTestCase extends PreReq {

	searchPage sp;
	@BeforeMethod
	public void PreReq() throws IOException
	{
		Browserselection();
		sp = new searchPage();
		
	}
	
	@Test
	public void seachTest()
	{
		sp.search();
	}
	
}
