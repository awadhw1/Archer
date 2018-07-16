package com.testframework.common;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/*import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;*/
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import ru.yandex.qatools.allure.annotations.Step;

import com.testframework.common.PropertyReader;

//@Listeners({TestNgListener.class})
public class BaseTest {
	public String URL=PropertyReader.getConfigItemValue(Constants.URL);
	public String HOMEURL=PropertyReader.getConfigItemValue(Constants.HOMEURL);
	
	public static final Logger log = Logger.getLogger(BaseTest.class.getName());
	//HomePage homePage;
	Drivers drivers;
	
	public static WebDriver driver;

	public Properties prop = new Properties();


	public static WebDriver getDriver() {
		return driver;
	}
	public String Environment;
	public static final String rootFolder = System.getProperty("user.dir");
	public static String filepath = new File("").getAbsolutePath();



	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		//Initialize driver
		try{
			init();
			String methodName = method.getName();
			log.info("********** Executing test ********** :- " + methodName);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() throws IOException, InterruptedException
	{
		try{
			log.info("Initilize webdriver");
			PropertyReader.setObjectPaths();
			Utilities.setAllureProps();
			initDriver();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
/*	public void login(String user){
		try{
			log.info("Navigate to Login page: " + PropertyReader.getConfigItemValue(URL));
			loginPage();
			drivers = new Drivers();
			homePage= new HomePage(driver);
			if(user.equalsIgnoreCase("planner")){
				homePage.Login(USERNAME_PLANNER,PASSWORD_PLANNER);
			}else if(user.equalsIgnoreCase("planning director")){
				homePage.Login(USERNAME_PLANNINGDIRECTOR,PASSWORD_PLANNINGDIRECTOR);
			}else if(user.equalsIgnoreCase("support agent")){
				homePage.Login(USERNAME_SUPPORTAGENT, PASSWORD_SUPPORTAGENT);
			}else{
				log.warn("User is undefined");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void loginToBaasPortal(){
		try{
			log.info("Open the BAAS Url " + PropertyReader.getConfigItemValue(BAASURL));
			get(PropertyReader.getConfigItemValue(BAASURL));
		}catch(Exception e){
			System.out.println("Exception is "+e);
		}
	}
	

	public void deletePlansForUser(String userName) {
		try {
			updatePlanStatusForUser(userName);
			List<Integer> planID = SQLDBConnection.getPlanIDForUser(
					PlanIdForUser, userName);
			for(int a : planID){
				System.out.println("\""+a+"\",");
			}
			if (!userName.equalsIgnoreCase("svcqa1")) {
				SQLDBConnection.setUserForPlans(userName,"svcqa1");
			}
			PropertyReader.setObjectPaths();
			System.out.println("PlanIds are "+planID);
			PlanInfo planInfo = new PlanInfo();
			for (Integer planid : planID) {
				planInfo.setPlanId(planid);
				if (planInfo != null) {
					OverlapHelper overlapHelper = new OverlapHelper();
					try {
						overlapHelper.deletePlanInfo(planInfo);
					} catch (WTestExcetion e) {
						System.out.println("Exeption is " + e);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in deletePlansForUser " + e);
		}
	}
	
	public void updatePlanStatusForUser(String userName){
		PropertyReader.setObjectPaths();
		SQLDBConnection.setPlanReviewStatusCode(13,userName);
	}
*/
	public static void initDriver() throws IOException {
		String operatingSystem= System.getProperty("os.name").toLowerCase();
		if (operatingSystem.contains("win"))
        {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")	+ Constants.chromeWebDriverPath);
			log.info(System.getProperty("webdriver.chrome.driver"));
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--disable-web-security");
			//options.setBinary(System.getProperty("webdriver.chrome.driver"));
			//		options.addArguments("user-data-dir=C:\\JK\\ChromeProfile");
			//		options.setBinary("C:\\Program Files (x86)\\chrome32_56.0.2924.87\\chrome.exe");
	
			driver = new ChromeDriver(options);
	
			//Get Browser details
			Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
			log.info("Browser:" + caps.getBrowserName() +
					" Version:" + caps.getVersion() +
					" Platform:" + caps.getPlatform());
			log.info("Driver started: "+ driver);
        }else{
        	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + Constants.chromeWebDriverPath);
        	log.info(System.getProperty("webdriver.chrome.driver"));
        	ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--disable-web-security");
			options.setBinary(System.getProperty("webdriver.chrome.driver"));
			
        	driver = new ChromeDriver(options);
            //Get Browser details
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        log.info("Browser:" + caps.getBrowserName() +
                       " Version:" + caps.getVersion() +
                       " Platform:" + caps.getPlatform());
            log.info("Driver started: "+ driver);
        }	
	}

	public void loginPage() throws IOException,
	InterruptedException {
		log.info("Loading Login Page");
		get(URL);
	}
	
	/*public void navigateToBaasPortal() throws IOException,
	InterruptedException {
		log.info("Loading BAAS Page");
		get(PropertyReader.getConfigItemValue(BAASURL));
	}*/

	@AfterMethod(alwaysRun = true)
	public void afterMethod(Method method,ITestResult result) throws IOException,
	InterruptedException {
		try {
			/*try{
				PlanInfo planInfo = new PlanInfo();
				planInfo.setPlanId(Integer.parseInt(PlanCommon.getPlanId()));
				if (planInfo != null) {
					OverlapHelper overlapHelper = new OverlapHelper();
					overlapHelper.deletePlanInfo(planInfo);
				}*/
				}catch(Exception e){
					System.out.println("Exception is "+e.getMessage());
					Drivers.driverQuit();
					//Driver.takeScreenShot(methodName);
					e.printStackTrace();
				}
			log.info("********** Finished test ********** :- " + method.getName());
		

		//Call screen Capture
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		if(ITestResult.FAILURE == result.getStatus()){
			try{
				captureScreenshot(result.getName() + sdf.format(timestamp));
			}
			catch(Exception e){
				log.info("Exception while taking screenshot" + e.getMessage() );
			}

		}
		afterTest();
	}




	/*public void deletePlan(int planId){
		try{
		PlanInfo planInfo = new PlanInfo();
		planInfo.setPlanId(planId);
		if (planInfo != null) {
			OverlapHelper overlapHelper = new OverlapHelper();
			overlapHelper.deletePlan(planInfo);
		}
		}catch(Exception e){
			System.out.println("Exception is "+e.getMessage());
		}
	}*/

	//	@AfterSuite()
	public void afterTest() throws IOException,
	InterruptedException {
		try {
			log.info("Test Completed - Closing Driver :" +driver);
			log.info("***********************************\n");
		//	Drivers.driverQuit();
		} catch (Exception e) {
	//		Drivers.driverQuit();
			e.printStackTrace();
		}
	}

	public void execCommadLine(String command) {
		try {
			Process process = Runtime.getRuntime().exec(command);
			log.info("the output stream is "
					+ process.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String s;
			while ((s = reader.readLine()) != null) {
				log.info("The inout stream is " + s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void navigateToLoginPage() throws IOException,
	InterruptedException {
		log.info("Loading Archer Login Page");
		get(URL);
	}
     @Step("Opening the home Page")
	public static void get(String url){
		driver.get(url);
	}

	public void captureScreenshot(String fileName) {
		try {
			WebDriver browser = BaseTest.getDriver();
			File screenshot = ((TakesScreenshot) browser)
					.getScreenshotAs(OutputType.FILE);
			// the screenshots can be moved to a folder for sorting
			FileUtils.copyFile(screenshot, new File("./errors/screenshot-"
					+ fileName + ".png"));
			log.info("Screenshot Taken");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public void clean_screenshots() //Clean existing screenshots from error folder before starting test
	{
		File file = new File("./errors/");
		String[] myFiles;
		if(file.isDirectory()){
			myFiles = file.list();
			for (int i=0; i<myFiles.length; i++) {
				File myFile = new File(file, myFiles[i]);
				myFile.delete();
			}
		}
	}


}
