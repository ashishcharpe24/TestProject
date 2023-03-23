package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.PreReq;

public class searchPage extends PreReq {

	@FindBy(xpath = "//input[@name='q']")private WebElement searchField ;
//	@FindBy(xpath = "")private WebElement ;
//	@FindBy(xpath = "")private WebElement ;
//	@FindBy(xpath = "")private WebElement ;
//	@FindBy(xpath = "")private WebElement ;
	
	public searchPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void search()
	{
		searchField.sendKeys("amazon",Keys.ENTER);
	}

}
