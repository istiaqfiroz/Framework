package test1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.EmployeePage;
import pageObject.LandingPage;
import resources.Base;

public class LoginHeading extends Base {
	Logger logger = LogManager.getLogger(LoginHeading.class);
	@BeforeTest
	public void intitializeBrowser() throws IOException {
		driver = initialize();
		driver.get(prop.getProperty("url"));
		logger.info("Initialize Driver");
	}

	@Test
	public void headingTest() throws IOException {

		LandingPage lp = new LandingPage(driver);
		lp.getAdmin().sendKeys("Admin");
		lp.getPassword().sendKeys("admin123");
		lp.getSubmit().click();
		logger.info("Test Run");

		EmployeePage ep = new EmployeePage(driver);
		String employee = ep.getEmployeeName().getText();

		AssertJUnit.assertEquals(employee, "Pau Collings");
		logger.info("Assertion");

	}
	@AfterTest
	public void tearDown() {
		driver.close();
		logger.info("Driver Close");
	}
}