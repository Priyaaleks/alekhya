package Tests;

import org.testng.annotations.Test;
import Base.BaseTest;
import Common.SQLDatabase;
import Pages.CategoryListPage;
import Pages.CreateNewCategoryPage;
import Pages.DashboardPage;
import Pages.LoginPage;


public class CategoryListTests extends BaseTest{

	
	@Test
	public void validatecategorylistpageJJA_10() {
		
		loginpage = new LoginPage(driver);		
		loginpage.performuserlogin(gettestdata("UserID"), gettestdata("Password"));	
		dashboadpage = new DashboardPage(driver);
		dashboadpage.selectmenuoption("Menu Management", "Category");
		SQLDatabase.validatecategorylistindatabase();
		
	}
	
	@Test
	public void validatecategorylistcolumnnamesincategorypageJJA_11() {
		
		loginpage = new LoginPage(driver);		
		loginpage.performuserlogin(gettestdata("UserID"),gettestdata("Password"));	
		dashboadpage = new DashboardPage(driver);
		dashboadpage.selectmenuoption("Menu Management", "Category");
		categorylistpage = new CategoryListPage(driver);
		categorylistpage.validatecategorylistcolumns();
		
		
	}
	
	@Test
	public void ValidateSNOcolumninAscendingorderJJA_12() {
		
		loginpage = new LoginPage(driver);		
		loginpage.performuserlogin(gettestdata("UserID"),gettestdata("Password"));	
		dashboadpage = new DashboardPage(driver);
		dashboadpage.selectmenuoption("Menu Management", "Category");
		categorylistpage = new CategoryListPage(driver);
		categorylistpage.validateSnocolumn();
		
	}
	@Test
public void ValidatetitleundertitlecolumnincategorypageJJA_26() {
		
		loginpage = new LoginPage(driver);		
		loginpage.performuserlogin(gettestdata("UserID"),gettestdata("Password"));	
		dashboadpage = new DashboardPage(driver);
		dashboadpage.selectmenuoption("Menu Management", "Category");
		createnewcategorypage = new CreateNewCategoryPage(driver);
		createnewcategorypage.validateAddNewcategoryform();
		categorylistpage = new CategoryListPage(driver);
		categorylistpage.validatetitleundertitlecolumn();
					
	}
	
	@Test
	public void ValidatedetailsunderdetailscolumnincategorypageJJA_35() {
		
		loginpage = new LoginPage(driver);		
		loginpage.performuserlogin(gettestdata("UserID"),gettestdata("Password"));	
		dashboadpage = new DashboardPage(driver);
		dashboadpage.selectmenuoption("Menu Management", "Category");
		categorylistpage = new CategoryListPage(driver);
		categorylistpage.validatedetailsunderdetailscolumn();
		
			
	}
	
	@Test
	public void validateupdateddateformatincategorypageJJA_36() {
		
		loginpage = new LoginPage(driver);		
		loginpage.performuserlogin(gettestdata("UserID"),gettestdata("Password"));	
		dashboadpage = new DashboardPage(driver);
		dashboadpage.selectmenuoption("Menu Management", "Category");
		categorylistpage = new CategoryListPage(driver);
		categorylistpage.validateupdateddateformat();
		
	}
@Test	
public void ValidatecategorytitleimageiconunderimagecolumnJJA_37() {
		
		loginpage = new LoginPage(driver);		
		loginpage.performuserlogin(gettestdata("UserID"),gettestdata("Password"));	
		dashboadpage = new DashboardPage(driver);
		dashboadpage.selectmenuoption("Menu Management", "Category");
		categorylistpage = new CategoryListPage(driver);
		categorylistpage.validateimagecolumn();
		
	}

@Test
public void ValidatestatusincategorylistpageJJA_39() {
	
	loginpage = new LoginPage(driver);		
	loginpage.performuserlogin(gettestdata("UserID"),gettestdata("Password"));	
	dashboadpage = new DashboardPage(driver);
	dashboadpage.selectmenuoption("Menu Management", "Category");
	categorylistpage = new CategoryListPage(driver);
	categorylistpage.validateStatuscolumn();
	
}

@Test
public void ValidatetitleinnotificationpanelofcategorypageJJA_47() {
	
	loginpage = new LoginPage(driver);		
	loginpage.performuserlogin(gettestdata("UserID"),gettestdata("Password"));	
	dashboadpage = new DashboardPage(driver);
	dashboadpage.selectmenuoption("Menu Management", "Category");
	categorylistpage = new CategoryListPage(driver);
	categorylistpage.Validatetitleinnotificationpanel();
	
}

@Test
public void ValidateeditanddeleteiconinActioncolumnJJA_55() {
	
	loginpage = new LoginPage(driver);		
	loginpage.performuserlogin(gettestdata("UserID"),gettestdata("Password"));	
	dashboadpage = new DashboardPage(driver);
	dashboadpage.selectmenuoption("Menu Management", "Category");
	categorylistpage = new CategoryListPage(driver);
	categorylistpage.validateactioncolumn();
	
}
}
