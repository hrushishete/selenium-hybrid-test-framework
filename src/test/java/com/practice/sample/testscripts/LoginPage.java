package com.practice.sample.testscripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage 
{
	@Test
	public void login()
	{
		String username="ABC1@yopmail.com";
		String password="ABC1@yopmail.com";
		String prodName="ADIDAS ORIGINAL";
		String countryName="India";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Actions action=new Actions(driver);
		//login page
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys(username);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		
//		Add products
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=products.stream().filter(product -> product.findElement(By.xpath(".//b")).getText().equals(prodName)).findFirst().orElse(null);
		prod.findElement(By.xpath(".//button[text()=' Add To Cart']")).click();
		
//		for(WebElement pro : products)
//		{
//			String productName=pro.findElement(By.xpath(".//b")).getText();
//			System.out.println(productName);
//			if(productName.equals(prodName))
//			{
//				pro.findElement(By.xpath(".//button[text()=' Add To Cart']")).click();
//				break;
//			}
//		}
		
		// Verify if product is add
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains (@class, 'la-ball-scale-multiple')]"))));
		WebElement loadingElement=driver.findElement(By.xpath("//div[contains (@class, 'la-ball-scale-multiple')]"));
		boolean loading =loadingElement.isDisplayed();
		Assert.assertEquals(true, loading);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()=' Product Added To Cart ']"))));
		WebElement addedPopup=driver.findElement(By.xpath("//div[text()=' Product Added To Cart ']"));
		String addedPopupText=addedPopup.getText().trim();
		System.out.println(addedPopupText);
		Assert.assertEquals("Product Added To Cart", addedPopupText);
		
		//click on cart icon inverify product is added
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		String cartProduct=driver.findElement(By.xpath("//h3[text()='"+prodName+"']")).getText();
		System.out.println(cartProduct);
		Assert.assertEquals(prodName, cartProduct);
		
		//checkout
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(countryName);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()=' "+countryName+"']"))));
		driver.findElement(By.xpath("//span[text()=' "+countryName+"']")).click();
		action.keyDown(Keys.PAGE_DOWN).perform();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Place Order ']"))));
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
	}
}
