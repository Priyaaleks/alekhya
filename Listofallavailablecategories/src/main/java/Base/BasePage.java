package Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver = null;
	protected JavascriptExecutor js;
	protected WebDriverWait wait;
	final long explicitwait = 30;
	protected String titlename = generaterandomstring(10);
	 protected String descriptionname = "Breakfast items list ";

	//Locators
	
	//Constructors
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver, explicitwait); 
		js = (JavascriptExecutor) driver;
		
	}
	
	//Methods
	
	public WebDriver getdriver() {
		return driver;
	}
	
	public WebElement getElement(By by) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		js.executeScript("arguments[0].style.border = '3px solid red'", driver.findElement(by));
		return driver.findElement(by);
		
	}
	
	public List<WebElement> getElements(By by){
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		js.executeScript("arguments[0].style.border = '3px solid red'", driver.findElement(by));
		return driver.findElements(by);
		
	}
	
	protected String generaterandomstring(int length) {
		String randomtitle = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789"+"abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(length);
		for(int i=0;i<length;i++) {
			int index =(int) (randomtitle.length()*Math.random());
			sb.append(randomtitle.charAt(index));
		}
		return sb.toString();
	}
	
}
