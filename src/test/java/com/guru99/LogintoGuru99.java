package com.guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogintoGuru99 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		
		//using submit method to submit the form. Submit used on password field	
		String baseUrl = "https://demo.guru99.com/test/login.html";
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("shaw");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("pwd");
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).submit();
		System.out.println("Login Done with Submit");
		driver.close();
	}

}
