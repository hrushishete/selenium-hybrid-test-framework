package com.practice.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.utilities.Custome_Utilities;

public class ProductCataloguePage extends Custome_Utilities {

	WebDriver driver;

	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	private List<WebElement> allProducts;

	@FindBy(xpath = "//div[contains (@class, 'la-ball-scale-multiple')]")
	private WebElement loadIcon;

	@FindBy(xpath = "//div[text()=' Product Added To Cart ']")
	private WebElement AddedToCartPopup;

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	private WebElement cartIcon;

	public void clickOnProduct(String prodName) {
		for (WebElement pro : allProducts) {
			String productName = pro.findElement(By.xpath(".//b")).getText();
			System.out.println(productName);
			if (productName.equals(prodName)) {
				pro.findElement(By.xpath(".//button[text()=' Add To Cart']")).click();
				break;
			}
		}
	}

	public boolean verifyLoadingIcon() {
		visible(loadIcon);
		return loadIcon.isDisplayed();
	}

	public String verifyAddTOCartText() {
		visible(AddedToCartPopup);
		return AddedToCartPopup.getText().trim();
	}

	public CheckOutPage clickOnCartIcon() throws InterruptedException {
//		invisibil(By.xpath("//div[contains (@class, 'la-ball-scale-multiple')]"));
		Thread.sleep(1000);
		cartIcon.click();
		CheckOutPage checkOut = new CheckOutPage(driver);
		return checkOut;
	}
}
