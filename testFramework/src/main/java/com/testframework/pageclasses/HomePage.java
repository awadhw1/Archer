package com.testframework.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.testframework.common.DriverMethods;

public class HomePage {
	@FindBy (xpath="//span[text()='SHOW ALL']")
	WebElement showAllLink;
	public HomePage(WebDriver driver) {

		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}
	public void createSolution() throws InterruptedException{
		System.out.println(showAllLink.isDisplayed());
		System.out.println(showAllLink.isEnabled());
		System.out.println(showAllLink.getText());
		DriverMethods.clickPerformWhenReady(showAllLink, 90, "");
	}
}
