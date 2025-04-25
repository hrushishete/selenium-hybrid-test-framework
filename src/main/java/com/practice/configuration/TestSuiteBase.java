package com.practice.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestSuiteBase {

	public WebDriver driver;

	@BeforeMethod
	public void openBrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\data.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		
		if (browserName.toLowerCase().contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				System.out.println(browserName+" browser name");
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		} else if (browserName.toLowerCase().contains("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			if (browserName.contains("headless")) {
				System.out.println(browserName+" browser name");
				options.addArguments("--headless");
			}
			driver = new FirefoxDriver(options);
		} else if (browserName.toLowerCase().contains("edge")) {
			EdgeOptions options = new EdgeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new EdgeDriver(options);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void afterTest() {
		driver.close();
	}

}