package com.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.utilities.Custome_Utilities;

public class LandingPage extends Custome_Utilities {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	private WebElement emailEle;
	@FindBy(id = "userPassword")
	private WebElement passwordEle;
	@FindBy(id = "login")
	private WebElement submitEle;

	public ProductCataloguePage userLogin(String email, String password) {
		emailEle.sendKeys(email);
		passwordEle.sendKeys(password);
		submitEle.click();
		ProductCataloguePage catalogue = new ProductCataloguePage(driver);
		return catalogue;
	}

	public void loadURL(String url) {
		driver.get(url);
	}
}
