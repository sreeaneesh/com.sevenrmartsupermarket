package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;// Instance variable
	WaitUtility waitutility;
	Properties properties = new Properties();
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordField;
	@FindBy(xpath = "//label[contains (text(),'Remember Me')]")
	private WebElement rememberMeField;
	@FindBy(xpath = "//button[contains (text(),'Sign In')]")
	private WebElement submitButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		waitutility = new WaitUtility(driver);
		PageFactory.initElements(driver, this);
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String UserName) {
		userNameField.sendKeys(UserName);
	}

	public void enterPassword(String Password) {
		passwordField.sendKeys(Password);
	}

	public void clickOnSignInBtn() {
		waitutility.waitElementForClickable(submitButton, 20);
		submitButton.click();
	}

	public void login(String UserName, String Password) {
		enterUserName(UserName);
		enterPassword(Password);
		clickOnSignInBtn();
		//return new HomePage(driver);//returning object of another class
	}

	/*public void login() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInBtn();
	}*/
}
