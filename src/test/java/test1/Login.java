package test1;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.Base;

public class Login extends Base {
	Logger logger = LogManager.getLogger(Login.class);

	@Test(dataProvider = "getData")
	public void login(String Admin, String Password) throws IOException {
		driver = initialize();
		driver.get(prop.getProperty("url"));
		logger.info("Initialize Browser");
		
		LandingPage lp = new LandingPage(driver);
		lp.getAdmin().sendKeys("Admin");
		lp.getPassword().sendKeys("admin123");
		lp.getSubmit().click();
		logger.info("Run Test Case");
		driver.close();
		logger.info("Driver Close");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "Admin";
		data[0][1] = "admin123";
		data[1][0] = "Admin";
		data[1][1] = "password";
		return data;
	}
}
