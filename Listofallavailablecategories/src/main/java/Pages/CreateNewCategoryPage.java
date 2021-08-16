package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Base.BasePage;


public class CreateNewCategoryPage extends BasePage {
	
	 //locators
	By btnAddNew = By.xpath("//a[contains(@href,'Create')]");
	By ttlcategory = By.tagName("h5");
	By title = By.id("txtTitle");
	By description = By.id("txtDescription");
	By btncreate = By.xpath("//input[@type='submit']");
	
	
	//constructor
		public CreateNewCategoryPage(WebDriver driver) {
			super(driver);
		}
		
	//methods
		public void validateAddNewcategoryform() {
			getElement(btnAddNew).click();
			getElement(ttlcategory).getTagName();
			getElement(title).sendKeys(titlename);
			getElement(description).sendKeys(descriptionname);
			getElement(btncreate).click();
			
		}
		
		
}

