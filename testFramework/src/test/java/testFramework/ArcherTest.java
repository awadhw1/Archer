package testFramework;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Step;

import com.testframework.common.BaseTest;
import com.testframework.pageclasses.HomePage;
import com.testframework.pageclasses.LoginPage;

public class ArcherTest extends BaseTest {
	LoginPage lpage;
	HomePage hpage;

	@BeforeClass(alwaysRun = true)
	public void setup() {

		
	}

	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		navigateToLoginPage();
		loginToArcher();
	}
	
	@Step("Loading the Login Page")
	public void loginToArcher() throws InterruptedException {
		lpage = new LoginPage(driver);
		lpage.LogintoArcher();
		
		

	}

	@Test(testName = "Login Test", description = "This test cases is for Login in to Archer Instance and creating the solution")
	@Step("Create Solution step")
	public void createSolution() throws InterruptedException {
		hpage = new HomePage(driver);
		Thread.sleep(2000);
		hpage.createSolution();

	}

	

}
