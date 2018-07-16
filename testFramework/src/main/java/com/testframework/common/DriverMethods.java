package com.testframework.common;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class DriverMethods {
	public static final String rootDir = System.getProperty("user.dir");
	public static final String MAXIMIZED = "--start-maximized";
	public static final String WEBSECURITY = "--disable-web-security";

	public static WebDriver driver;

	public DriverMethods(WebDriver driver)
	{
		DriverMethods.driver = driver;
		//common= new Common(driver);
	}

	public static String takeScreenShot(String name){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date now = new Date();
		String directory = new SimpleDateFormat("EEE_d_MMM_yyyy").format(now);
		String filename = new SimpleDateFormat("HH_mm_ss_aaa").format(now);
		File dir= new File("target//screenshots//"+directory);
		if(!dir.exists()){
			dir.mkdir();
		}
		File destFile = new File("target//screenshots//"+directory+"//"+name+"_"+filename+".jpg");
		try {
			FileUtils.copyFile(scrFile,destFile);
		} catch (IOException e) {
			System.out.println("Exception is "+e);
			return null;
		}
		return"";
	}

	public static void initWebDriver() throws IOException {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")	+ Constants.chromeWebDriverPath);
					//System.setProperty("webdriver.chrome.driver",s + Constants.chromeWebDriverPath);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--disable-web-security");
		//	options.addArguments(Arrays.asList("----user-data-dir"));

		driver = new ChromeDriver(options);

		//Get Browser details
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		System.out.println("Browser:" + caps.getBrowserName() +
				" Version:" + caps.getVersion() +
				" Platform:" + caps.getPlatform());
		//		System.out.println(caps.getVersion());
		//		System.out.println(caps.getPlatform());
		implicitlyWait(60);

	}

	public static void get(String url){
		driver.get(url);
		implicitlyWait(60);
	}

	public static WebDriver getDriver(){
		return driver;
	}

	public static WebElement getWhenVisible(By locator, int timeout, String comment) {
		implicitlyWait(30);
		WebElement element = null;
		try {
			if(comment != null){
				System.out.println(comment);
			}
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return element;
		} catch (Exception e) {
			System.out.println(element + " is displayed false ");
			System.out.println("Exception in getting webelement " + e);
			return element;
		}
	}


	public static WebElement getWhenVisibleFromElmList(By locator, int timeout, String comment) {
		implicitlyWait(30);
		try {
			if(comment != null){
				System.out.println(comment);
			}
			Thread.sleep(2000);
			List<WebElement> elements = driver.findElements(locator);
			for(int i=0;i<elements.size();i++){
				//Thread.sleep(2000);
				if(elements.get(i).isDisplayed()){
					Thread.sleep(1000);
					return elements.get(i);
				}
			}
			return null;
		} catch (Exception e) {
			System.out.println(locator + " is displayed false ");
			System.out.println("Exception clickWhenReady " + e);
			Assert.assertFalse(true);
			return null;
		}
	}

	public static boolean clickWhenReady(By element, int timeout, String comment) {
		implicitlyWait(30);
		DriverMethods.waitElementToBeClickable(element, 30, null);
		try {
			if(comment != null){
				System.out.println(comment);
			}
			getWhenVisible(element, timeout, null);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement elementweb = wait.until(ExpectedConditions.elementToBeClickable(element));
			DriverMethods.waitElementToBeClickable(element, 20, null);
			elementweb.click();
			implicitlyWait(30);
			return true;
		} catch (Exception e) {
			System.out.println(element + " is displayed false ");
			System.out.println("Exception clickWhenReady " + e);
			Assert.assertFalse(true);
			return false;
		}
	}
	public static boolean clickwithMouseOver(By mainelement,By subelement, int timeout, String comment) {
		implicitlyWait(30);
		try {
			if(comment != null){
				System.out.println(comment);
			}
			moveToElementPerform(mainelement, 30, "Move to Element");
			Actions actions = new Actions(driver);
			WebElement subMenu = driver.findElement(subelement);
			actions.moveToElement(subMenu);
			actions.click().build().perform();
			return true;
		} catch (Exception e) {
			System.out.println(subelement + " is displayed false ");
			System.out.println("Exception click with MouseOver " + e);
			Assert.assertFalse(true);
			return false;
		}
	}

	public static void minimizeFont() throws InterruptedException
	{
		System.out.println("Reducing the fond size to get unpick button");
		try {
			String cntplus = Keys.chord(Keys.CONTROL, Keys.SUBTRACT);
			DriverMethods.sendKeys(cntplus, 30, "control and minus");
			DriverMethods.sendKeys(cntplus, 30, "control and minus");
			DriverMethods.sendKeys(cntplus, 30, "control and minus");
			DriverMethods.sendKeys(cntplus, 30, "control and minus");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(3000);
	}

	public static boolean isDispayed(By element){
		try{
			driver.findElement(element).isDisplayed();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public static boolean waitforLoadingScreen(By element){
		try{
			driver.findElement(element).isDisplayed();
			boolean check;
			String str;
			do {
				DriverMethods.implicitlyWait(30);
				try {
					check = driver.findElement(element).isDisplayed();
				} finally {
				}
				str = String.valueOf(check);
				DriverMethods.implicitlyWait(30);
			} while (str.equals("true"));
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public static boolean waitforElement(By element, String comment){
		try{
			// getWhenVisibleFromElmList(element, 50, null);
			if(comment != null){
				System.out.println(comment);
			}
			boolean check;
			String str;
			do {
				DriverMethods.implicitlyWait(30);
				try {
					check = driver.findElement(element).isDisplayed();
				} finally {
				}
				str = String.valueOf(check);
				DriverMethods.implicitlyWait(30);
			} while (str.equals("false"));
			return true;
		}
		catch(Exception e){
			System.out.println("Exception wait for element" + e);
			Assert.assertFalse(true);
			return false;
		}
	}

	public static boolean ifGetPageSourceContains(String str){
		return driver.getPageSource().contains(str);
	}

	public static boolean clickWhenReadyFromElmList(By element, int timeout, String comment) {
		implicitlyWait(30);
		try {
			if(comment !=null){
				System.out.println(comment);
			}
			//Thread.sleep(2000);
			implicitlyWait(90);
			List<WebElement> elements = driver.findElements(element);
			for(int i=0;i<elements.size();i++){
				//Thread.sleep(2000);
				implicitlyWait(90);
				if(elements.get(i).isDisplayed()){
					Thread.sleep(1000);
					elements.get(i).click();
				}
			}
			implicitlyWait(30);
			return true;
		} catch (Exception e) {
			System.out.println(element + " is displayed false ");
			System.out.println("Exception clickWhenReady " + e);
			Assert.assertFalse(true);
			return false;
		}
	}

	public static List<WebElement> returnElements(By xpath, int timeout, String comment) {
		implicitlyWait(30);
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(xpath);
			return elements;
		} catch (Exception e) {
			System.out.println(elements + " is displayed false ");
			System.out.println("Exception returnElements " + e);
			Assert.assertFalse(true);
			return elements;
		}
	}



	public static boolean selectByIndex(By element, int index, int timeout, String comment) {
		implicitlyWait(30);
		try {
			System.out.println(comment);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement elementweb = wait.until(ExpectedConditions.elementToBeClickable(element));

			Select sel = new Select (elementweb);
			sel.selectByIndex(index);
			return true;
		} catch (Exception e) {
			System.out.println(element + " is displayed false ");
			System.out.println("Exception selectByIndex " + e);
			return false;
		}
	}

	public static boolean selectByVisibleText(By element, String visibleText, int timeout, String comment) {
		implicitlyWait(30);
		try {
			System.out.println(comment);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement elementweb = wait.until(ExpectedConditions.elementToBeClickable(element));

			Select sel = new Select (elementweb);
			sel.selectByVisibleText(visibleText);
			return true;
		} catch (Exception e) {
			System.out.println(element + " is displayed false ");
			System.out.println("Exception selectByIndex " + e);
			return false;
		}
	}


	public static boolean waitElementToBeClickable(By element, int timeout, String comment) {
		implicitlyWait(30);
		try {
			if(comment != null){
				System.out.println(comment);
			}
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			System.out.println("Exception " +comment + ":" + e);
			Assert.assertFalse(true);
			return false;
		}
	}
	public static boolean waitElementToBeClickable(WebElement element, int timeout, String comment) {
		implicitlyWait(30);
		try {
			if(comment != null){
				System.out.println(comment);
			}
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			System.out.println("Exception " +comment + ":" + e);
			Assert.assertFalse(true);
			return false;
		}
	}

	public static boolean clickPerformWhenReady(By element, int timeout, String comment) throws InterruptedException {
		implicitlyWait(30);
		try {
			System.out.println(comment);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement elementweb = wait.until(ExpectedConditions.elementToBeClickable(element));

			Actions action = new Actions(driver);

			action.click(elementweb).perform();
			return true;
		} catch (Exception e) {
			System.out.println(element + " is displayed false ");
			System.out.println("Exception performWhenReady  " + e);
			return false;
		}
	}
	public static boolean clickPerformWhenReady(WebElement element, int timeout, String comment) throws InterruptedException {
	//	implicitlyWait(30);
		try {
			System.out.println(comment);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement elementweb = wait.until(ExpectedConditions.elementToBeClickable(element));

			Actions action = new Actions(driver);

			action.click(elementweb).perform();
			return true;
		} catch (Exception e) {
			System.out.println(element + " is displayed false ");
			System.out.println("Exception performWhenReady  " + e);
			return false;
		}
	}

	public static String getElementText(By locator, int timeout, String comment) {
		String text = getWhenVisible(locator, timeout, comment).getText();
		System.out.println("Text :" + text);
		return text;
	}

	/*public static String getErrorMsg(By screen, By frame, int timeout, String comment) {
		String text=null;
		WebElement workspace = DriverMethods.getWhenVisible(MDNewStrategyPanel,30, "Verify Error messages");
		List<WebElement> details = workspace.findElements(MDStrategyPanelerror);
		for (WebElement row : details) {
			DriverMethods.implicitlyWait(30);
			text = row.getText();
		}
		return text;
	}*/

/*	public static WebElement getElementNoWait(By locator, int timeout, String comment) {
		System.out.println(comment);
		WebElement elem = null;
		try {
			elem = driver.findElement(locator);
			return elem;
		} catch (NoSuchElementException e) {
			return elem;
		}
	}*/

	public static boolean moveToElementPerform(By locator, int timeout, String comment) {
		implicitlyWait(30);
		try {
			System.out.println(comment);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement elementweb = wait.until(ExpectedConditions.elementToBeClickable(locator));

			Actions action = new Actions(driver);
			//action.moveToElement(elementweb).click().perform();
			action.moveToElement(elementweb).perform();
			return false;
		} catch (Exception e) {
			System.out.println("Exception in moveToElementPerform " + e);
			return false;
		}
	}

	public static boolean sendKeysBylocator(By locator, String key,  int timeout, String comment) {
		implicitlyWait(30);
		try {
			System.out.println(comment);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement elementweb = wait.until(ExpectedConditions.elementToBeClickable(locator));
			elementweb.clear();
			Thread.sleep(300);
			Actions action = new Actions(driver);
			action.click(elementweb).sendKeys(key).perform();
			return false;
		} catch (Exception e) {
			System.out.println("Exception in sendKeys By locator <" + key + "> is " + e);
			return false;
		}
	}

	public static boolean searchKeyBylocator(By locator, String key,  int timeout, String comment) {
		implicitlyWait(30);
		try {
			System.out.println(comment);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement elementweb = wait.until(ExpectedConditions.elementToBeClickable(locator));
			//Thread.sleep(300);
			Actions action = new Actions(driver);
			//Thread.sleep(3000);
			action.click(elementweb).sendKeys(key).perform();
			Thread.sleep(5000);
			action.sendKeys(Keys.ENTER).perform();
			implicitlyWait(2);
			return false;
		} catch (Exception e) {
			System.out.println("Exception in sendKeys By locator <" + key + "> is " + e);
			return false;
		}
	}

	public static void sendKeysBylocatorFromTheList(By locator, String key,  int timeout, String comment) throws InterruptedException {
		Thread.sleep(timeout);
		implicitlyWait(30);
		try {
			System.out.println(comment);

			List<WebElement> elements = driver.findElements(locator);
			Thread.sleep(1000);
			for(int i=0;i<elements.size();i++){
				Thread.sleep(1000);
				if(elements.get(i).isDisplayed()){
					Thread.sleep(5000);
					elements.get(i).clear();
					Actions action = new Actions(driver);
					action.click(elements.get(i)).sendKeys(key).perform();
				}
			}

		} catch (Exception e) {
			System.out.println("Exception in sendKeys By locator <" + key + "> is " + e);
		}

	}

	public static boolean sendKeys(Keys key,  int timeout, String comment) {
		try {
			System.out.println(comment);
			Actions action = new Actions(driver);
			action.sendKeys(key).perform();
			return false;
		} catch (Exception e) {
			System.out.println("Exception in sendKeys <" + key + "> is " + e);
			return false;
		}
	}

	public static boolean sendKeys(String key,  int timeout, String comment) {
		try {
			System.out.println(comment);
			Actions action = new Actions(driver);
			Thread.sleep(300);
			action.sendKeys(key).perform();
			return false;
		} catch (Exception e) {
			System.out.println("Exception in sendKeys <" + key + "> is " + e);
			return false;
		}
	}

	public static void implicitlyWait(int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public static void rearrangeScreenSmallFF() throws InterruptedException{
		System.out.println("Rerrange window Small form factor");
		Dimension dimension = new Dimension(375,675);
		driver.manage().window().setSize(dimension);
		Thread.sleep(3000);
	}

	public static void rearrangeScreenLandscapeFF() throws InterruptedException{
		System.out.println("Rerrange window Small form factor");
		Dimension dimension = new Dimension(640,375);
		driver.manage().window().setSize(dimension);
		Thread.sleep(3000);
	}

	public static void rearrangeScreenMediumFF() throws InterruptedException{
		System.out.println("Rerrange window Medium Form Factor");
		Dimension dimension = new Dimension(960, 700);
		driver.manage().window().setSize(dimension);
	}


	public static void rearrangeScreen375_5500() throws InterruptedException{
		System.out.println("Rerrange window 375_5500");
		Dimension dimension = new Dimension(375,5500);
		driver.manage().window().setSize(dimension);
	}



	public static void maximize() throws InterruptedException{
		System.out.println("maximize window");
		try{
			driver.manage().window().maximize();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Exception in maximize browser " + e);
		}
	}

	public static void fullWindowSize(int sleep) throws InterruptedException {
		Thread.sleep(sleep);
		DriverMethods.sendKeys(Keys.F11, 30, "FullWindowSize");
	}

	public static void exitFullWindowSize(int sleep) {
		try {
			Thread.sleep(sleep);
			DriverMethods.sendKeys(Keys.F11, 30, "exitFullWindow");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void closeDriver() {
		driver.close();
	}

	public static void driverQuite() {
		try {
			driver.quit();
		}
		catch (Exception e) {
			System.out.println("Exception in closing driver " + e);
		}
	}

	public static void refreshPage() throws InterruptedException{
		System.out.println("Refresh window");
		driver.navigate().refresh();
		Thread.sleep(5000);
		implicitlyWait(30);
	}

	public static void switchFrame(String frame) throws InterruptedException {
		try {
			driver.switchTo().frame(driver.findElement(By.xpath(frame)));
		} 
		catch (Exception e) {
			System.out.println("Exception in SwichinFrame is " + e);
		}
	}

	public static void switchToDefaultContent(){
		try {
			driver.switchTo().defaultContent();
		} 
		catch (Exception e) {
			System.out.println("Exception in switchToDefaultContent is " + e);
		}
	}


}
