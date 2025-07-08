package com.guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String baseUrl = "https://demo.guru99.com/test/upload/";
		driver.get(baseUrl);
		WebElement upload = driver.findElement(By.id("uploadfile_0"));
		
		// enter the file path onto the file-selection input field
		upload.sendKeys("C:/tt.txt");
		
		// check the "I accept the terms of service" check box
		driver.findElement(By.id("terms")).click();
		
		// click the "UploadFile" button
		driver.findElement(By.name("send")).click();
		System.out.println("Done");
	}

}
