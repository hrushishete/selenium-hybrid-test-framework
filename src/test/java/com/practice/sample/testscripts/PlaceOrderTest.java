package com.practice.sample.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.configuration.TestSuiteBase;
import com.practice.pages.CheckOutPage;
import com.practice.pages.LandingPage;
import com.practice.pages.PlaceOrderPage;
import com.practice.pages.ProductCataloguePage;

public class PlaceOrderTest extends TestSuiteBase{
	@Test
	public void orderPlace() throws InterruptedException {
		String username = "ABC1@yopmail.com";
		String password = "ABC1@yopmail.com";
		String prodName = "ADIDAS ORIGINAL";
		String countryName = "India";
		String url = "https://rahulshettyacademy.com/client";
		
		// login page
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loadURL(url);
		ProductCataloguePage catalogue =landingPage.userLogin(username, password);

//		Add products
		catalogue.clickOnProduct(prodName);

//		Verify if product is add
		boolean loadingIcon=catalogue.verifyLoadingIcon();
		Assert.assertEquals(true, loadingIcon);
		String AddedToCartText=catalogue.verifyAddTOCartText();
		Assert.assertEquals(AddedToCartText, "Product Added To Cart");

//		click on cart icon inverify product is added
		CheckOutPage checkOut = catalogue.clickOnCartIcon();

//		checkout
		String cartProduct =checkOut.clickCheckOut(prodName);
		System.out.println(cartProduct);
		Assert.assertEquals(prodName, cartProduct);
		PlaceOrderPage placeOrderpage = checkOut.checkOutButtonClick();

//		place order
		placeOrderpage.placeOrder(countryName);
	}
}
