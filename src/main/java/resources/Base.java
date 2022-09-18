package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public Properties prop;
	public WebDriver driver;

	public WebDriver initialize() throws IOException {
		prop = new Properties();
		FileInputStream fs = new FileInputStream(
				"/Users/efat/eclipse-workspace/Framework8/src/main/java/resources/data.properties");
		prop.load(fs);

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "/Users/efat/Desktop/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public String getScreenshot(String tastCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinition = System.getProperty("user.dir")+"/screenshot/"+tastCaseName+".png";
		FileUtils.copyFile(source, new File(destinition));
		return destinition;
	}

}
