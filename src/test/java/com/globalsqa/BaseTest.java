package com.globalsqa;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public BaseTest() {
	}

	private WebDriver driver;
	String baseUrl = "https://www.globalsqa.com/demo-site/";
	String expectedTitleOnTab = "Accordion And Tabs";

	public void setup() throws InterruptedException {
		getDriver();
		browserSetup();
		launchBrowser();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void browserSetup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void launchBrowser() throws InterruptedException {
		driver.get(baseUrl);
		scrollDownBy500();
	}

	public void tearDown() {
		driver.close();
	}

	public void scrollDownBy200() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000L);
	}

	public void scrollDownBy300() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000L);
	}

	public void scrollDownBy500() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000L);
	}
}
