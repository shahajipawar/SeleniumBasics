package com.globalsqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AlertBox extends BaseTest {

	@Test
	public void alertBoxTest() throws InterruptedException {
		setup();
		openAlertBoxPage();
		scrollDownBy300(); 
		
	}

	public void openAlertBoxPage() {
		WebElement alertBoxButton = getDriver()
				.findElement(By.xpath("//li[@class = 'price_footer']/a[contains(text(),'AlertBox')]"));
		alertBoxButton.click();
	}
}
