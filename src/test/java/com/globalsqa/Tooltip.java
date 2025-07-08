package com.globalsqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltip extends BaseTest {

	@Test
	public void toolTipTest() throws InterruptedException {
		setup();
		gotoTooltipPage();
//		switchToIframe();
//		checkTooltipText();
//		checkTooltipFromImage();
//		switchToVideoBasedTab();
//		checkTooltipfromVideo();
		gotoFormBasedTab();
		switchToIframe();
		checkFormBasedTooltips();
	}

	public void gotoTooltipPage() {
		getDriver().findElement(By.xpath("//a[contains(text(),'ToolTip')]")).click();
	}

	public void switchToIframe() throws InterruptedException {
		Thread.sleep(2000L);
		scrollDownBy200();
		// Switch to inner Iframe window
		getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		System.out.println("switchToIframe");
	}

	public void checkTooltipText() throws InterruptedException {
		WebElement image = getDriver().findElement(By.xpath("//img[@class='ui-corner-all']"));
		Actions action = new Actions(getDriver());
		action.moveToElement(image).build().perform();
		Thread.sleep(1000L);
		WebElement toolTipElement = getDriver().findElement(By.xpath("//div[@class='ui-tooltip-content']"));
		String actualTooltip = toolTipElement.getText();
		String expectedTooltip = "St. Stephen's Cathedral";
		try {
			Assert.assertEquals(expectedTooltip, actualTooltip);
			System.out.println("Case for checkTooltipText passed");
		} catch (Exception e) {
			System.out.println("Case for checkTooltipText is failed");
		}
	}

	public void checkTooltipFromImage() throws InterruptedException {
		WebElement Element = getDriver().findElement(By.xpath("//img[@alt='Tower Bridge']"));
		Actions action = new Actions(getDriver());
		action.moveToElement(Element).build().perform();
		Thread.sleep(2000L);

		WebElement towerTooltip = getDriver()
				.findElement(By.xpath("//div[@class='ui-tooltip-content' and contains(text(),'Tower Bridge')]"));
		String actual = towerTooltip.getText();
		String expected = "Tower Bridge";
		Assert.assertEquals(expected, actual);
		System.out.println("Case for checkTooltipFromImage is passed");
	}

	public void switchToVideoBasedTab() throws InterruptedException {
		// Switch to Video based tab
		getDriver().switchTo().defaultContent();
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,-300)");
		Thread.sleep(2000L);
		getDriver().findElement(By.xpath("//li[contains(text(),'Video Based')]")).click();
	}

	public void checkTooltipfromVideo() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");
		String actualTextMsg = getDriver()
				.findElement(By.xpath("//div[@class='attention closable' and contains(text(),'on video')]")).getText();
		String expectedTextMsg = "Verify tooltip on video buttons.";
		Assert.assertEquals(actualTextMsg, expectedTextMsg);
		System.out.println("Case for checkTooltipfromVideo is passed");

		getDriver().switchTo().frame(getDriver()
				.findElement(By.xpath("//div[@rel-title='Video Based']/p/iframe[@class='demo-frame lazyloaded']")));
		System.out.println("Switched to Inner window/iFrame");
		Thread.sleep(2000L);

		WebElement likeButton = getDriver().findElement(By.xpath("//button[@title='I like this']"));
		Thread.sleep(2000L);
		Actions action = new Actions(getDriver());
		action.moveToElement(likeButton).build().perform();
		String actualToolTipTextLike = getDriver()
				.findElement(By.xpath("//div[@role='tooltip']/div[contains(text(),'I like this')]")).getText();
		String expectedToolTipTextlike = "I like this";
		Assert.assertEquals(actualToolTipTextLike, expectedToolTipTextlike);
		System.out.println("Tooltip text validation passed for like icon");

		WebElement dislikeButton = getDriver().findElement(By.xpath("//button[@data-icon='ui-icon-circle-arrow-s']"));
		action.moveToElement(dislikeButton).build().perform();
		Thread.sleep(2000L);
		String actualToolTipTextDisLike = getDriver()
				.findElement(By.xpath("//div[@role='tooltip']/div[contains(text(),'I dislike this')]")).getText();
		String expectedToolTipTextDislike = "I dislike this";
		Assert.assertEquals(actualToolTipTextDisLike, expectedToolTipTextDislike);
		System.out.println("Tooltip text validation passed for Dislike icon");

		WebElement addToWatchLater = getDriver().findElement(By.xpath("//button[@data-icon='ui-icon-circle-plus']"));
		Thread.sleep(2000L);
		action.moveToElement(addToWatchLater).build().perform();
		String ActualToolTipTextAddToWatchLater = getDriver()
				.findElement(By.xpath("//div[@role='tooltip'] /div[contains(text(),'Add to Watch Later')]")).getText();
		String expectedToolTipTextAddToWatchLater = "Add to Watch Later";
		Assert.assertEquals(ActualToolTipTextAddToWatchLater, expectedToolTipTextAddToWatchLater);
		System.out.println("Tooltip text validation passed for Add to watch later icon");

		WebElement addToFavorites = getDriver()
				.findElement(By.xpath("//button[@title='Add to favorites or playlist']"));
		action.moveToElement(addToFavorites).build().perform();
		Thread.sleep(2000L);
		String actualToolTipTextAddToFavorites = getDriver()
				.findElement(By.xpath("//div[@role='tooltip'] /div[contains(text(),'Add to favorites or playlist')]"))
				.getText();
		String expectedToolTipTextAddToFavorites = "Add to favorites or playlist";
		Assert.assertEquals(actualToolTipTextAddToFavorites, expectedToolTipTextAddToFavorites);
		System.out.println("Tooltip text validation passed for Add to Favorites icon");
		
		WebElement shareButton = getDriver()
				.findElement(By.xpath("//button[contains(text(),'Share')]"));
		action.moveToElement(shareButton).build().perform();
		Thread.sleep(2000L);
		String actualToolTipTextShare = getDriver()
				.findElement(By.xpath("//div[@role='tooltip'] /div[contains(text(),'Share this video')]"))
				.getText();
		String expectedToolTipTextShare = "Share this video";
		Assert.assertEquals(actualToolTipTextShare, expectedToolTipTextShare);
		System.out.println("Tooltip text validation passed for Share icon");
		
		WebElement flagButton = getDriver()
				.findElement(By.xpath("//button[@title='Flag as inappropriate']"));
		action.moveToElement(flagButton).build().perform();
		Thread.sleep(2000L);
		String actualToolTipTextflagButton = getDriver()
				.findElement(By.xpath("//div[@role='tooltip'] /div[contains(text(),'Flag as inappropriate')]"))
				.getText();
		String expectedToolTipTextflagButton = "Flag as inappropriate";
		Assert.assertEquals(actualToolTipTextflagButton, expectedToolTipTextflagButton);
		System.out.println("Tooltip text validation passed for Flag icon");
	}

	public void gotoFormBasedTab() throws InterruptedException {
		getDriver().switchTo().defaultContent();
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,-300)");
		Thread.sleep(2000L);
		getDriver().findElement(By.xpath("//li[contains(text(),'Forms Based')]")).click();
		System.out.println("Switched to Form Based tab");		
	}
	
	public void checkFormBasedTooltips() throws InterruptedException {
		Thread.sleep(2000L);
		getDriver().findElement(By.xpath("//button[contains(text(),'Show help')]")).click();
		WebElement firstName = getDriver().findElement(By.xpath("//input[@name='firstname']"));
		Actions action = new Actions(getDriver());
		action.moveToElement(firstName).build().perform();
	}
}
