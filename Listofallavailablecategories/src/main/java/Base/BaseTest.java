package Base;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


import Common.Reports;
import Pages.CategoryListPage;
import Pages.CreateNewCategoryPage;
import Pages.DashboardPage;
import Pages.LoginPage;



public class BaseTest {

	protected LoginPage loginpage = null;
	protected DashboardPage dashboadpage = null;
	protected CategoryListPage categorylistpage = null;
	protected CreateNewCategoryPage createnewcategorypage = null;
	
	protected WebDriver driver = null;
	String projectpath = System.getProperty("user.dir");
	Properties envprop = null;
	protected HashMap exceltestdata = null;
	
	protected String gettestdata(String key) {
		return String.valueOf(exceltestdata.get(key));
	}
	
	@Parameters({"browser","env"})	   
	@BeforeSuite
	public void beforesuite(String browser, String env) {
		loadenvironmentdata(env);
		Reports.initializereport();
	}
	
	@Parameters({"browser","env"})
	@BeforeMethod
	public void Launchapplication(Method method, String browser, String env) {
		
		loadtestdata();
		Reports.AddTestToReport(method.getName());
		String driverpath = projectpath+"\\Drivers\\chromedriver.exe";
		
		Reports.INFO("initializing browser:" + browser);
				
		switch(browser.toLowerCase()) {
		
			case "chrome" : System.setProperty("webdriver.chrome.driver",driverpath);
				driver = new ChromeDriver();
				break;
			case "firefox": System.setProperty("webdriver.gecko.driver",driverpath);
				driver = new FirefoxDriver();
				break;
			default : System.out.println("No such browser exist");
			
		}	
		
		Reports.INFO("browser is initialized successfully");
		
		driver.get(String.valueOf(envprop.get("appurl")));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Reports.PASS("Application launched: " + envprop.get("appurl"));
		
		System.out.println(driver.getTitle());
		
	}
	
	@AfterTest
	public void aftertest() {
		System.out.println("after test in testng");
	}
	
	@AfterSuite
	public void aftersuite() {
		System.out.println("after suite in testng");
		Reports.flushreport();
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			Reports.PASS("test is passed");
			Reports.takesnapshot(driver, result.getName());
		} else if (result.getStatus()==ITestResult.FAILURE){
			Reports.FAIL("test is failed");
			Reports.FAIL(result.getThrowable().getLocalizedMessage());
			Reports.takesnapshot(driver, result.getName());
		}
		
		Reports.closereport();
		
		if(driver != null) {
			driver.close();
			driver.quit();
		}
		
	}
	
	public void loadenvironmentdata(String environment) {
		try {
		FileReader reader = new FileReader(projectpath+"\\src\\test\\resources\\"+environment+".properties");
		envprop = new Properties();
		envprop.load(reader);
		
		System.out.println(envprop.get("appurl"));
		
		} catch(Exception ex) {
			System.out.println("Please check environment data properties");
			ex.getCause();
		}
		
	}
	
	public void loadtestdata() {
		try {
			FileInputStream fs = new FileInputStream(projectpath+"\\Testdata\\TestData.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sheet = wb.getSheet("LoginData");
			Iterator<Row> rows = sheet.iterator();
			
			exceltestdata = new HashMap<String, String>();
			List<String> keys = new ArrayList<String>();
			List<String> values = new ArrayList<String>();
			
			boolean isHeader = true;
			
			while(rows.hasNext()) {
				XSSFRow eachrow = (XSSFRow) rows.next();
				Iterator<Cell> cells = eachrow.iterator();
					
				while(cells.hasNext()) {						
						XSSFCell eachcell = (XSSFCell) cells.next();
						if(isHeader) {
							keys.add(readcellvalue(eachcell));
						} else {
							values.add(readcellvalue(eachcell));
						}
					}
				isHeader = false;
			}
			
			for(int index=0;index<keys.size();index++) {
				exceltestdata.put(keys.get(index), values.get(index));
			}
			
		} catch (Exception e) {
			System.out.println("Test data not found correctly");
			e.printStackTrace();
		}
		
		
	}
	
	public String readcellvalue(Cell cell) {
		
		String cellvalue = null;
		
		switch(cell.getCellType()) {
		case Cell.CELL_TYPE_STRING : cellvalue = new DataFormatter().formatCellValue(cell);
		break;
		case Cell.CELL_TYPE_NUMERIC : cellvalue = new DataFormatter().formatCellValue(cell);
		break;
		}
		
		return cellvalue;
	}
	
}
