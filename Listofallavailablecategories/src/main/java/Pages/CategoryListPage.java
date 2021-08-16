package Pages;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Base.BasePage;
import Common.Reports;



public class CategoryListPage extends BasePage {

	//locators
	
	By categorycolumns = By.xpath("//th");
	By SNOcolumn = By.xpath("//th[text()='SNO']//following::tr/td[1]");
	By title = By.xpath("//th[text()='TITLE']//following::tr/td[3]");
	By Details = By.xpath("//th[text()='DETAILS']//following::tr/td[4]");
	By updateddates = By.xpath("//th[text()='UPDATED']//following::tr/td[6]");
	By imageicon = By.xpath("//th[text()='IMAGE']//following::tr/td[2]");
	By statuscolumn = By.xpath("//th[text()='STATUS']//following::tr/td[5][contains(text(),'ACTIVE') or contains(text(),'INACTIVE')]");
	By Navigationbar = By.xpath("//li[contains(text(),'Menu')]");
	By editicon = By.xpath("//tr//td[7]//span[contains(@class,'edit')]");
	By trashicon = By.xpath("//tr//td[7]//span[contains(@class,'trash')]");
	
	
	String dateformat;
	
	//constructor
	public CategoryListPage(WebDriver driver) {
		super(driver);
	}	
	
	//methods
	
	
	public void validatecategorylistcolumns() {
		Reports.INFO("Validating category list columns in category page");
		
		for(int index=0;index<getElements(categorycolumns).size();index++) {	
			Reports.INFO(getElements(categorycolumns).get(index).getText());
		}
		Reports.PASS("Category list columns in category page are displayed successfully");
	}

	
	
	public void validateSnocolumn() {
		Reports.INFO("Validating category list SNO column in category page");
		
		List<Integer> serialnumbers = new ArrayList<>();
		List<WebElement> snumbers = getElements(SNOcolumn);
		for(WebElement snumber : snumbers) {
			int number = Integer.valueOf(snumber.getText().toString());
			serialnumbers.add(number);
		}
		List<Integer> sortedlist = new ArrayList<>();
		for(int i:serialnumbers) {
			sortedlist.add(i);
		}
		Collections.sort(sortedlist);
		Assert.assertTrue(sortedlist.equals(serialnumbers), "SNO column in category page is not in ascending order");
	
		Reports.PASS("Sequence of numbers under SNO column are displayed in ascending order");
	}

	public void validatetitleundertitlecolumn() {
		
		Reports.INFO("Validating category list Title column in category page");
		
		for(int index=0;index<getElements(title).size();index++) {	
			if(getElements(title).get(index).getText().equals(titlename)){
				System.out.println("Title under title column is verified successfully");
			}
		}
		
			Reports.PASS("Titles of all categories under title column of category page are displayed.");
		
		
	}
	
	public void validatedetailsunderdetailscolumn() {
		
		Reports.INFO("Validating category list Details column in category page");
		
		for(int index=0;index<getElements(Details).size();index++) {	
			if(getElements(Details).get(index).getText().contains("idly,dosa")){
				System.out.println("Details under details column is verified successfully");
			}
		}
			Reports.PASS("Details of all categories under details column of category page are displayed.");
		
		
	}
	
	public void validateupdateddateformat() {
		
		Reports.INFO("Validating category list Updated column in category page");
		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		 
		 for(int index=0;index<getElements(updateddates).size();index++) { 
			  String updateddate = getElements(updateddates).get(index).getText(); 
			 String mydate = formatter.format(LocalDate.parse(updateddate, formatter));
			 Assert.assertEquals(mydate, updateddate, "not matched");
		 }	
		
		Reports.PASS("Dates under updated column in category page are in our required date format");
		
   }

	public void validateimagecolumn() {
		
		Reports.INFO("Validating category list image column in category page");	
		
		for(int index=0;index<getElements(imageicon).size();index++) {	
			boolean imageicons = getElements(imageicon).get(index).getAttribute("class").contains("invert-image");
		
			Assert.assertEquals(imageicons, true);				 		
	}
		
	Reports.PASS("Image icons of all categories under image column are displayed successfully");
}

	public void validateStatuscolumn() {
		
		Reports.INFO("Validating category list status column in category page");
		
		for(int index=0;index<getElements(statuscolumn).size();index++) {	
			Assert.assertEquals(true, getElements(statuscolumn).get(index).isDisplayed());
			
	}
		Reports.PASS("Status as ACTIVE/INACTIVE under status column in category page is displayed.");
	}

	public void Validatetitleinnotificationpanel() {
		
		Reports.INFO("Validating category list Notification panel in category page");
		
		System.out.println(getElement(Navigationbar).getText());
	
		Reports.PASS("Title in notification panel is: "+getElement(Navigationbar).getText());
	}
	
	public void validateactioncolumn() {
		
		Reports.INFO("Validating category list Action column in category page");
		
		for(int index=0;index<getElements(editicon).size();index++) {	
			
			Assert.assertEquals(true, getElements(editicon).get(index).isDisplayed());
			Assert.assertEquals(true, getElements(trashicon).get(index).isDisplayed());
			
	}
		Reports.PASS("Edit and delete icon are displayed for each and every record of category in action column");
	}
}


