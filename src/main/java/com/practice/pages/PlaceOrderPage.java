package com.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.utilities.Custome_Utilities;

public class PlaceOrderPage extends Custome_Utilities {
	WebDriver driver;

	public PlaceOrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	private WebElement selectCountry;

	@FindBy(xpath = "//a[text()='Place Order ']")
	private WebElement placeOrderButton;

	public void placeOrder(String countryName) {
		selectCountry.sendKeys(countryName);
		visible(driver.findElement(By.xpath("//span[text()=' " + countryName + "']")));
		driver.findElement(By.xpath("//span[text()=' " + countryName + "']")).click();
		keyAction(Keys.PAGE_DOWN);
		Clickable(placeOrderButton);
		placeOrderButton.click();

	}
}
