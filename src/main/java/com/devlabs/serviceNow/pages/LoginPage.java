package com.devlabs.serviceNow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.devlabs.testng.base.ProjectGenericWrappers;

public class LoginPage extends ProjectGenericWrappers {
	
public LoginPage(RemoteWebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver = driver;
}

@FindBy(how = How.ID, using = "user_name")
private WebElement elementUsername;

@FindBy(how = How.ID, using = "user_password")
private WebElement elementPassword;

@FindBy(how = How.ID, using = "sysverb_login")
private WebElement elementLoginButton;

@FindBy(how = How.XPATH, using = "//span[@class='dp-invalid-login-msg']")
private WebElement elementErrorMessge;


public LoginPage enterUsername(String username) {
	switchToFrame(0);
	clearAndType(elementUsername, username);
	defaultContent();
	return this;
}

public LoginPage enterPassword(String password) {
	switchToFrame(0);
	clearAndType(elementPassword, password);
	defaultContent();
	return this;
}
public HomePage clickLogin_Positive() {
	switchToFrame(0);
	click(elementLoginButton);
	return new HomePage(driver);
}
public LoginPage clickLogin_Negative() {
	switchToFrame(0);
	click(elementLoginButton);
	defaultContent();
	return this;
}

public void verifyErrorMessage(String errorMsg) {
	switchToFrame(0);
	verifyPartialText(elementErrorMessge, errorMsg);
	defaultContent();
}
}
