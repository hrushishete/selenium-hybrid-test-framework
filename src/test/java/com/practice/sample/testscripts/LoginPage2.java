package com.practice.sample.testscripts;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.pages.CheckOutPage;
import com.practice.pages.LandingPage;
import com.practice.pages.PlaceOrderPage;
import com.practice.pages.ProductCataloguePage;

public class LoginPage2 {
	@Test
	public void login() throws InterruptedException {
		String username = "ABC1@yopmail.com";
		String password = "ABC1@yopmail.com";
		String prodName = "ADIDAS ORIGINAL";
		String countryName = "India";
		String url = "https://rahulshettyacademy.com/client";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// login page
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loadURL(url);
		landingPage.userLogin(username, password);

//		Add products
		ProductCataloguePage catalogue = new ProductCataloguePage(driver);
		catalogue.clickOnProduct(prodName);

//		Verify if product is add
		boolean loadingIcon=catalogue.verifyLoadingIcon();
		Assert.assertEquals(true, loadingIcon);
		String AddedToCartText=catalogue.verifyAddTOCartText();
		Assert.assertEquals(AddedToCartText, "Product Added To Cart");

//		click on cart icon inverify product is added
		catalogue.clickOnCartIcon();

//		checkout
		CheckOutPage checkOut = new CheckOutPage(driver);
		String cartProduct =checkOut.clickCheckOut(prodName);
		System.out.println(cartProduct);
		Assert.assertEquals(prodName, cartProduct);
		checkOut.checkOutButtonClick();

//		place order
		PlaceOrderPage placeOrderpage = new PlaceOrderPage(driver);
		placeOrderpage.placeOrder(countryName);
	}
}
