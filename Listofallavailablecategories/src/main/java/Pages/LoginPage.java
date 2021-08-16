package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import Base.BasePage;
import Common.Reports;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
By txttitle = By.xpath("//h2");
By txtusername = By.id("txtUserID");
By txtpassword = By.id("txtPassword");
By btnlogin = By.xpath("//input[@type = 'submit']");

	
	public void performuserlogin(String username, String password) {				
		
		
		System.out.println(getElement(txttitle).getText());
		getElement(txtusername).sendKeys(username);
		Reports.INFO("username entered successfully:" + username);
		getElement(txtpassword).sendKeys(password);
		Reports.INFO("password entered successfully:" + password);
		getElement(btnlogin).click();
		Reports.PASS("Dashboard page is displayed after successfull login");
	}
	
	
	
	
}
