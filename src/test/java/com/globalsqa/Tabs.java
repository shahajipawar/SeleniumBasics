package com.globalsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tabs extends BaseTest {

	@Test
	public void tabsTest() throws InterruptedException {
		setup();
		gotoTabsPage();
		checkLabel();
		gotoReSizeAccordianTab();
	}

	public void gotoTabsPage() throws InterruptedException {
		getDriver().findElement(By.linkText("Tabs")).click();
		Thread.sleep(1000L);
	}

	public void checkLabel() {
		// check label on page
		String expectedTitleOnTab = "Accordion And Tabs";
		WebElement actualTitleOnTab = getDriver().findElement(By.xpath("//*[@class='page_heading']/h1"));
		String actualTitleTab = actualTitleOnTab.getText();
		try {
			Assert.assertEquals(actualTitleTab, expectedTitleOnTab);
			System.out.println("Case 1 passed");
		} catch (Exception e) {
			System.out.println("Case 1 Failed");
		}
	}

	public void gotoReSizeAccordianTab() {
		getDriver().findElement(By.id("Re-Size Accordion")).click();
		// scrollDownBy500();
		// driver.findElement(By.xpath("//*[@class='ui-accordion ui-widget
		// ui-helper-reset']/h3[4]"));
	}
}

//WebDriverManager.edgedriver().setup();
//EdgeOptions co = new EdgeOptions();
//co.addArguments("--remote-allow-origins=*");
//WebDriver driver = new EdgeDriver(co);
//WebDriverManager.firefoxdriver().setup();
//WebDriver driver = new FirefoxDriver();