package com.practice.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Custome_Utilities {
	static WebDriver driver;
	Actions action;

	public Custome_Utilities(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);
	}

	public WebDriverWait getWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	}

	public void visible(WebElement visibleElement) {
		getWait().until(ExpectedConditions.visibilityOf(visibleElement));
	}

	public void Clickable(WebElement clickableElement) {
		getWait().until(ExpectedConditions.elementToBeClickable(clickableElement));
	}

	public void invisibil(By locator) {
		getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void keyAction(Keys key) {
		action.keyDown(key).perform();
	}

	public static ExtentReports extent;

	public static ExtentReports getReportInstance(String ReportName) {
		if(extent == null)
		{
			String path = System.getProperty("user.dir") + "//reports//ExtentReports//"+ReportName+".html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setDocumentTitle("DemoReport");
			reporter.config().setReportName("Test Demo Report");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Hrushi");
		}
		return extent;
	}
	
	public static String captureScreenShot(String methodName) throws IOException
	{
		TakesScreenshot screenShot =(TakesScreenshot) driver;
		File output =screenShot.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\screenshot\\"+methodName+".jpg";
		File location=new File(path);
		FileHandler.copy(output, location);
		return path;
	}
}
