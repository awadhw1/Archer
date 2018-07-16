package com.testframework.pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.apache.log4j.*;

import com.mysql.jdbc.Driver;
import com.sun.webkit.dom.KeyboardEventImpl;
import com.testframework.common.DriverMethods;

public class LoginPage {

	private static Logger log = Logger.getLogger(LoginPage.class);
	@FindBy(id = "txtUserName")
	WebElement userNameTxtbox;
	@FindBy(id = "txtInstance")
	WebElement instanceTxtbox;
	@FindBy(id = "txtpassword")
	WebElement pwdTxtbox;
	@FindBy(id = "btnLogin")
	WebElement loginBtn;
	HomePage hpage;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}

	public void LogintoArcher() {
		hpage = new HomePage(DriverMethods.driver);

		log.info("On Login Page");
		System.out.println(userNameTxtbox.isEnabled());
		if (userNameTxtbox.isDisplayed()) {
			userNameTxtbox.click();

			userNameTxtbox.sendKeys("SysAdmin");

			instanceTxtbox.click();
			instanceTxtbox.sendKeys("Archer");
			pwdTxtbox.click();
			pwdTxtbox.sendKeys("Rsa@2bsafe");
			loginBtn.click();
		} else {
			log.info(userNameTxtbox + " Is not visible ");
		}

	}

}
