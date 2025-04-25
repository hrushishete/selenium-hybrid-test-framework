package com.practice.sample.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.configuration.TestSuiteBase;
import com.practice.pages.LandingPage;
import com.practice.pages.ProductCataloguePage;

public class VerifyProductAddToCartTest extends TestSuiteBase{
	@Test
	public void productVerify() throws InterruptedException {
		String username = "ABC1@yopmail.com";
		String password = "ABC1@yopmail.com";
		String prodName = "ADIDAS ORIGINAL";
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
	}
}
