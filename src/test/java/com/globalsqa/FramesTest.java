package com.globalsqa;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

	@Test
	public void framesTest() throws InterruptedException {
		setup();
		openFramesPage();		
		openNewTab();
		getParentChildWindow();
		checkTextShown();
		gotoIFrameTab();
		checkTextShownOnIFrame();
		countIframes();		

		// Switch to required iFrame first

		// Handle drop-down
//		Select testing = new Select(driver.findElement(By.xpath("//span[@id='current_filter']")));
//		testing.selectByVisibleText("AUTOMATION");
//		System.out.println("AUTOMATION");
	}

	public void openFramesPage() throws InterruptedException {
		WebElement framesButton = getDriver().findElement(By.linkText("Frames"));
		framesButton.click();
	}

	public void openNewTab() throws InterruptedException {
		scrollDownBy300();
		getDriver().findElement(By.linkText("Click Here")).click();
		// driver.findElement(By.xpath("//a[@class='button e.g. button_hilite
		// button_pale small_button'][normalize-space()='Click Here']"));
	}

	public void getParentChildWindow() throws InterruptedException {
		// Handle the tabs opened in same browser
		Set<String> windows = getDriver().getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentwindow = it.next();
		System.out.println(parentwindow);
		String childWindow = it.next();
		System.out.println(childWindow);

		// Switch to parent window
		getDriver().switchTo().window(parentwindow);
		System.out.println("Switched to Parent window");

		// Switch to child window and close it
		getDriver().switchTo().window(childWindow);
		getDriver().close();
		System.out.println("closed child window and switched to parent window");

		// switch to parent window Open new window
		getDriver().switchTo().window(parentwindow);
		System.out.println("switched back to parent window");
		Thread.sleep(2000L);
		// driver.findElement(By.id("Open New Window")).click();
		// driver.findElement(By.className("resp-tab-item")).click();
		// driver.findElement(By.cssSelector(".resp-tab-item")).click();
		getDriver().findElement(By.xpath("//li[@class='resp-tab-item'][1]")).click();
	}

	public void checkTextShown() {
		String expectedText = "Click below button to open a new window now";
		// String actualTest = driver.findElement(By.linkText("Click below button to
		// open a new window now")).getText();
		String actualTest = getDriver()
				.findElement(By.xpath("//strong[normalize-space()='Click below button to open a new window now']"))
				.getText();
		try {
			Assert.assertEquals(actualTest, expectedText);
			System.out.println("Test case 1 is passed");
		} catch (Exception e) {
			System.out.println("Test case 1 is failed");
		}
	}

	public void gotoIFrameTab() {
		// Navigate to iFrame tab
		getDriver().findElement(By.xpath("//li[@class='resp-tab-item'][2]")).click();
	}

	public void checkTextShownOnIFrame() {
		String actualMessage = "Below is an iFrame. If you want to perform any operation in this window, you will need to enter in this iframe.";
		String expectedMessage = getDriver().findElement(By.xpath(
				"//strong[normalize-space()='Below is an iFrame. If you want to perform any operation in this window, you will need to enter in this iframe.']"))
				.getText();
		try {
			Assert.assertEquals(expectedMessage, actualMessage);
			System.out.println("Test case 2 is passed");
		} catch (Exception e) {
			System.out.println("Test case 2 is failed");
		}
	}

	public void countIframes() throws InterruptedException {
		// Count number of iframes on page
		System.out.println(getDriver().findElements(By.tagName("iframe")).size());
		Thread.sleep(2000L);
		scrollDownBy200();
	}
}
