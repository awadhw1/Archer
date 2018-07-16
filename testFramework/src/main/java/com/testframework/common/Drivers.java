package com.testframework.common;

//import static com.wm.pricing.markdown.PageClasses.PlanWorkspace_Page.loadingId;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.log4j.Logger;



public class Drivers extends BaseTest{

	public static final Logger log = Logger.getLogger(Drivers.class.getName());
	public static WebDriver driver;

	public Drivers(){
		driver = BaseTest.getDriver();
		implicitlyWait(5);
	}

	public static boolean sendKeysBylocator(WebElement element, String key,  int timeout, String comment) {
		try {
			if(comment != null){
				log.info(comment);
			}
			WebElement elementweb = getWebElement(element, timeout);
			elementweb.clear();
			Thread.sleep(300);
			Actions action = new Actions(driver);
			action.click(elementweb).sendKeys(key).perform();
			return true;
		} catch (Exception e) {
			log.info("Exception in sendKeys By locator <" + key + "> is " + e);
			Assert.assertFalse(true);
			return false;
		}
	}

	public static boolean sendKeysBylocator(By locator, String key,  int timeout, String comment) {
		try {
			if(comment != null){
				log.info(comment);
			}
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement elementweb = wait.until(ExpectedConditions.elementToBeClickable(locator));
			elementweb.clear();
			Thread.sleep(300);
			Actions action = new Actions(driver);
			action.click(elementweb).sendKeys(key).perform();
			return true;
		} catch (Exception e) {
			log.info("Exception in sendKeys By locator <" + key + "> is " + e);
			Assert.assertFalse(true);
			return false;
		}
	}

	public static boolean searchKeyBylocator(WebElement element, String key,  int timeout, String comment) {
		try {
			if(comment != null){
				log.info(comment);
			}
			WebElement elementweb = getWebElement(element, timeout);
			elementweb.clear();
			Actions action = new Actions(driver);
			action.click(elementweb).sendKeys(key).perform();
			action.sendKeys(Keys.ENTER).perform();
	//		checkScreenLoading(loadingId , timeout);
			return true;
		} catch (Exception e) {
			log.info("Exception in sendKeys By locator <" + key + "> is " + e);
			return false;
		}
	}

	public static boolean searchBar(WebElement element, String key,  int timeout, String comment) {
		try {
			if(comment != null){
				log.info(comment);
			}
		//	checkScreenLoading(loadingId , timeout);
			WebElement elementweb = getWebElement(element, timeout);
			Actions action = new Actions(driver);
			action.click(elementweb).sendKeys(key).perform();
			Thread.sleep(5000);
			action.sendKeys(Keys.ENTER).perform();
		//	checkScreenLoading(loadingId , timeout);
			return true;
		} catch (Exception e) {
			log.info("Exception in sendKeys By locator <" + key + "> is " + e);
			return false;
		}
	}

/*	public static boolean searchKeyBylocator(WebElement element, List<Row> keys,  int timeout, String comment) {
		implicitlyWait(30);
		try {
			if(comment != null){
				log.info(comment);
			}
			WebElement elementweb = getWebElement(element, timeout);
			elementweb.clear();
			Actions action = new Actions(driver);
			action.click(elementweb).sendKeys(keys.toString()).perform();

			action.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			return false;
		} catch (Exception e) {
			log.info("Exception in sendKeys By locator <" + keys + "> is " + e);
			return false;
		}
	}*/

	public static boolean clickWhenReady(WebElement element, int timeout, String comment) {
		try {
			if(comment != null){
				log.info(comment);
			}
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement elementweb = wait.until(ExpectedConditions.elementToBeClickable(element));
		//	checkScreenLoading(loadingId , timeout);
			wait.until(ExpectedConditions.visibilityOf(elementweb));
			elementweb.click();
			return true;
		} catch (Exception e) {
			log.info("Exception in clicking element <" + element + "> is " + e);
		//	throw e;
		}
		return true;
	}

	public static boolean clickWhenReady(By element, int timeout, String comment) {
		try {
			if(comment != null){
				log.info(comment);
			}
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement elementweb = wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.visibilityOf(elementweb));
		//	checkScreenLoading(loadingId , timeout);
			elementweb.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		//	throw e;
		}
		return true;
	}

	public static WebElement getWebElement(WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement elementweb = wait.until(ExpectedConditions.elementToBeClickable(element));
			return elementweb;
		} catch (Exception e) {
			log.info("Exception in getWebElement <" + element + "> is " + e);
			Assert.assertFalse(true);
			return null;
		}
	}

	public static WebElement getWebElement(By element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement elementweb = wait.until(ExpectedConditions.elementToBeClickable(element));
			return elementweb;
		} catch (Exception e) {
			log.info("Exception in getWebElement <" + element + "> is " + e);
			Assert.assertFalse(true);
			return null;
		}
	}

	public static boolean checkVisibility(WebElement element, int timeout) {
		try {
			boolean visibility= element.isDisplayed();
			return visibility;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean waitforLoadingScreen(WebElement element){
		try{
			Thread.sleep(1000);
			element.isDisplayed();
			int wait = 50; //Wait for defined limit
			boolean check;
			String str;
			do {
				implicitlyWait(30);
				try {
					check = element.isDisplayed();
					Thread.sleep(1000);
					wait --;
				} finally {
				}
				str = String.valueOf(check);
				implicitlyWait(30);
			} while ((str.equals("true")) && (wait > 0));
			implicitlyWait(30);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public static boolean waitforElementToAppear(WebElement element, int timeout){
		try{
			Thread.sleep(1000);
			int wait = timeout; //Wait for defined limit
			boolean check;
			String str;
			do {
				implicitlyWait(30);
				try {
					check = !(element.isDisplayed());
					Thread.sleep(1000);
					wait --;
				} finally {
				}
				str = String.valueOf(check);
				implicitlyWait(30);
			} while ((str.equals("true")) && (wait > 0));
			implicitlyWait(30);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public static boolean waitforElementToAppear(WebElement element){
		try{
			Thread.sleep(1000);
			element.isDisplayed();
			int wait = 20; //Wait for defined limit
			boolean check;
			String str;
			do {
				implicitlyWait(30);
				try {
					check = !(element.isDisplayed());
					Thread.sleep(1000);
					wait --;
				} finally {
				}
				str = String.valueOf(check);
				implicitlyWait(30);
			} while ((str.equals("true")) && (wait > 0));
			implicitlyWait(30);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public static boolean clickwithMouseOver(WebElement mainelement,WebElement subelement, int timeout, String comment) {
		implicitlyWait(30);
		try {
			if(comment != null){
				log.info(comment);
			}
			moveToElementPerform(mainelement, 30, "Move to Element");
			Actions actions = new Actions(driver);
			actions.moveToElement(subelement);
			actions.click().build().perform();
			return true;
		} catch (Exception e) {
			log.info(subelement + " is displayed false ");
			log.info("Exception click with MouseOver " + e);
			Assert.assertFalse(true);
			return false;
		}
	}

	public static boolean moveToElementPerform(WebElement locator, int timeout, String comment) {
		implicitlyWait(30);
		try {
			if(comment != null){
				log.info(comment);
			}
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement elementweb = wait.until(ExpectedConditions.elementToBeClickable(locator));

			Actions action = new Actions(driver);
			action.moveToElement(elementweb).perform();
			return false;
		} catch (Exception e) {
			log.info("Exception in moveToElementPerform " + e);
			return false;
		}
	}

	public static boolean sendKeys(String key,  int timeout, String comment) {
		try {
			if(comment != null){
				log.info(comment);
			}
			Actions action = new Actions(driver);
			Thread.sleep(300);
			action.sendKeys(key).perform();
			return false;
		} catch (Exception e) {
			log.info("Exception in sendKeys <" + key + "> is " + e);
			return false;
		}
	}

	public static String getElementText(WebElement locator, int timeout) {
		String text = locator.getText();
		return text;
	}

	public static void implicitlyWait(int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	private static void turnOffImplicitWait() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	public static void driverQuit() {
		try {
			driver.quit();
		}
		catch (Exception e) {
			log.info("Exception in closing driver " + e);
		}
	}

	public static String getElementAttribute(By element, int timeout) {
		String text = driver.findElement(element).getAttribute("textContent");		
		return text;
	}	

	public static int getElementCount(List<WebElement> element) throws InterruptedException {
		return element.size();
	}

	public static void checkScreenLoading(By element, int timeout) {
		try{
			turnOffImplicitWait();
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		}
		catch (Exception e) {
			log.info("Page is still Loading..: "+ e);
		}
		finally
		{
			implicitlyWait(5);
		}
	}

	public static void pressEnter(By element){
		driver.findElement(element).sendKeys(Keys.RETURN);
	}
}
