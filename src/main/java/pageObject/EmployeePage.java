package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeePage {
	WebDriver driver;
	By employeeName = By.className("oxd-userdropdown-name");
	
	
	public EmployeePage(WebDriver driver) {
		
		this.driver= driver;
	}
	
	
	public WebElement getEmployeeName() {
		return driver.findElement(employeeName);
	}
}
