package com.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.utilities.Custome_Utilities;

public class CheckOutPage extends Custome_Utilities {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "cart")
	private WebElement productsInCart;

	@FindBy(xpath = "//button[text()='Checkout']")
	private WebElement checkOutButton;

	public String clickCheckOut(String prodName) {
		return productsInCart.findElement(By.xpath(".//h3[text()='" + prodName + "']")).getText();

	}

	public PlaceOrderPage checkOutButtonClick() {
		checkOutButton.click();
		PlaceOrderPage placeOrderpage = new PlaceOrderPage(driver);
		return placeOrderpage;
	}

}
