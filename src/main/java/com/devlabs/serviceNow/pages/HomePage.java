package com.devlabs.serviceNow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.devlabs.testng.base.ProjectGenericWrappers;

public class HomePage extends ProjectGenericWrappers{

	public HomePage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(how = How.ID, using = "filter")
	private WebElement elementFilterNavigator;
	
	public HomePage enterFilterValue(String Filter) {
		clearAndType(elementFilterNavigator, Filter);
		return this;
	}
}
