package org.sampleframework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;

public class Baseclass {
public static  WebDriver driver;
public static Sheet sheet; 

			//Browser Launch 
public static void LaunchBrowser(String browser) {
	switch(browser) {
	case "chrome":
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	break;
	case"edgedriver":
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
	break;
	case"firefox":
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	break;
	case"safari":
		WebDriverManager.safaridriver().setup();
		driver=new SafariDriver();
	break;
	case"Opera":
		WebDriverManager.operadriver().setup();
		driver = (WebDriver) new OperaDriverManager();
		break;
	default:
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
			//URL Launch
}
	public static void  LaunchUrl(String url) {
		driver.get(url);
	}
			//locators
	
	public static WebElement locators(String locatorname, String value ) {
		
		if (locatorname.equalsIgnoreCase("id")) {
			WebElement Element = driver.findElement(By.id(value));
		    return Element;
		}
		else if(locatorname.equalsIgnoreCase("name")){
			WebElement Element = driver.findElement(By.name(value));
		    return Element;
		}
		else if(locatorname.equalsIgnoreCase("xpath")){
			WebElement Element = driver.findElement(By.xpath(value));
			return Element;
		}
		else if(locatorname.equalsIgnoreCase("classname")){
			WebElement Element = driver.findElement(By.className(value));
		    return Element;
		}
		else if(locatorname.equalsIgnoreCase("tagname")){
			WebElement Element = driver.findElement(By.tagName(value));
		    return Element;
		}
		else if(locatorname.equalsIgnoreCase("linktext")){
			WebElement Element = driver.findElement(By.linkText(value));
		    return Element;
		}
		else if(locatorname.equalsIgnoreCase("partiallinktext")){
			WebElement Element = driver.findElement(By.partialLinkText(value));
		    return Element;
		}
		else if(locatorname.equalsIgnoreCase("cssselector")){
			WebElement Element = driver.findElement(By.cssSelector(value));
		    return Element;
		}
		else {
			System.out.println("enter valid locators ");
			}
		return null;
		}
		//maximize
	public static void maximize() {
		driver.manage().window().maximize();
	}
		//dimensions
		
		public static void setsize(int width, int height) {
			
		Dimension dimensions = new Dimension(width, height);
		driver.manage().window().setSize(dimensions);
		}
		
		//navigate
		public static void navigate(String url ) {
			driver.navigate().to(url);
			
		}
		public static void backward() {
			driver.navigate().back();
			
		}
		public static void forward() {
			driver.navigate().forward();
			
		}
		public static void refresh( ) {
			driver.navigate().refresh();
			
		}
		//alert
		public static void alert() {
			driver.switchTo().alert();
		}
		//click button
		public static void click(WebElement element) {
		element.click();
		}
		//sendkeys
		public static void sendkeys(WebElement element, String string) {
			element.sendKeys(string);
		}
		//To print in console

		public static void getAttribute(WebElement element) {
			String attribute = element.getAttribute("value");
			System.out.println(attribute);
		
		}
		public static void getText(WebElement element) {
			String text = element.getText();
			System.out.println(text);
		}
	public static void screenshot(String path) throws IOException {
			TakesScreenshot s=(TakesScreenshot)driver;
			File screenshotAs = s.getScreenshotAs(OutputType.FILE);
			File file =new File(path);
			FileUtils.copyFile(screenshotAs, file);
	
	}
	public static void select(WebElement element, String selectby, Object  value ) {
		Select s= new Select (element);
		if (selectby.equalsIgnoreCase("index")) {
			s.selectByIndex((int)value);
		}else if (selectby.equalsIgnoreCase((String)"value")) {
			s.selectByValue((String)value);
		}else if (selectby.equalsIgnoreCase("text")) {
			s.selectByVisibleText((String) value);
	}else 
	{
		System.out.println("enter valid selectbyvalue");
		
	}
				
	}
	public static void readexcel(String filelocation, String sheetname) throws IOException {
		File file= new File(filelocation);
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		int numberOfSheets = workbook.getNumberOfSheets();
		sheet = workbook.getSheet(sheetname);
		int rows = sheet.getPhysicalNumberOfRows();
		for(int i=0;i<rows; i++) {
	    		Row row = sheet.getRow(i);
	    		int cells = row.getPhysicalNumberOfCells();
	    		for(int j=0; j<cells;j++) {
	        		Cell cell = row.getCell(j);
	        		CellType cellType = cell.getCellType();
	        		switch(cellType) {
	        		
	        		case STRING:
	        			
	        			String stringCellValue = cell.getStringCellValue();
	        			System.out.print( stringCellValue+"\t");
	        			
	        		break;
	        		
	        		case NUMERIC:
	        				if(DateUtil.isCellDateFormatted(cell)){
	        				Date dateCellValue = (Date) cell.getDateCellValue();
	        				SimpleDateFormat date= new SimpleDateFormat("dd/MM/yyyy");
	            			String format = date.format(dateCellValue);
	            			System.out.print(format+"\t");
	            			
	        			}
	        		else
	        				
	        			{
	        				double numericCellValue = cell.getNumericCellValue();
	            			long l=(long )numericCellValue;
	            			System.out.print(numericCellValue+"\t");
	            					}
	        				
	        	    default:
	        			break;
	        		}
	        		System.out.println();
//	        		DataFormatter formatter= new DataFormatter();
//	        		String formatCellValue = formatter.formatCellValue(cell);
//	        		System.out.print("\t"+formatCellValue);
//	           		
//	           		
//	        			}
//	    		System.out.println();
	    		}
		}
	   
	}
	public static String title() {
		String pagename = driver.getTitle();
		return pagename;
	}
	
	
	
	}



