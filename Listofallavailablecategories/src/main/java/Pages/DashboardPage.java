package Pages;

import Base.BasePage;
import Common.Reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage extends BasePage {
	
	//dynamic locators
	String menutitle = "//a[text()='@@']" ;
	String menudrop = "//a[text()='@@']";
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	

	public void selectmenuoption(String MenuTitle, String Option) {
		getElement(By.xpath(menutitle.replace("@@", MenuTitle))).click();
		getElement(By.xpath(menutitle.replace("@@", Option))).click();
		Reports.PASS("Category is selected under Menu Management");
	}
}