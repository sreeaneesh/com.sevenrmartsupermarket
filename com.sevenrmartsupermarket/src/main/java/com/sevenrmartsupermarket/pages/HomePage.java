package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;// Instance variable

	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement ProfileName;

	@FindBy(xpath = "//p[text()='Admin Users']/../div/following-sibling::a")
	private WebElement clickAdminMoreInfo;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return ProfileName.getText();
	}

	public AdminUserPage clickAdminMoreInfo() {
		clickAdminMoreInfo.click();
		return new AdminUserPage(driver);
	}

}
