package PracticeMaven.Maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HelperClass {
	static WebDriver driver;
	// for Excel

	public static String getData(int rowNo, int cellNo) throws IOException {
		File loc = new File("C:\\Users\\SUTHAKAR\\eclipse-workspace\\Maven1\\Excel\\Saran.xlsx");
		FileInputStream f = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(f);
		Sheet s = w.getSheet("saran");
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int type = c.getCellType();
		String name = null;
		if (type == 1) {
			name = c.getStringCellValue();
		}
		if (type == 0) {
			if (DateUtil.isCellDateFormatted(c)) {
				name = new SimpleDateFormat("dd-MMM-yy").format(c.getDateCellValue());

			} else {
				name = String.valueOf((long) c.getNumericCellValue());
			}
		}
		return name;
	}
	public static void writeCellValue(int rowNo, int cellNo, String name) throws IOException {
		File loc = new File("C:\\Users\\SUTHAKAR\\eclipse-workspace\\Maven1\\Excel\\Saran.xlsx");
		FileInputStream f = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(f);
		Sheet s = w.getSheet("saran");
		Row r = s.getRow(rowNo);
		Cell c = r.createCell(cellNo);
		c.setCellValue(name);
		FileOutputStream o = new FileOutputStream(loc);
		w.write(o);

	}

	public static WebDriver LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SUTHAKAR\\eclipse-workspace\\BasePom\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public static void getUrl(String url) {
		driver.get(url);
	}
	
	public static void quitBrow() {
		driver.quit();
	}

	public static void inPut(WebElement e, String s) {
		e.sendKeys(s);
	}

	public static void click(WebElement e) {
		e.click();
	}

	public static void GetAttribute(WebElement e, String m) {
		e.getAttribute("value");
		m=e.getText();
		System.out.println(m);

	}

	public static void SelectByIndex(WebElement e, int num) {
		new Select(e).selectByIndex(num);
	}

	public static void SelectByVisibleText(WebElement e, String name) {
		new Select(e).selectByVisibleText(name);

	}

	public static void SelectByValue(WebElement e, String name) {
		new Select(e).selectByValue(name);

	}

	// right clk
	public static void RightClick(WebDriver e, WebElement n) {
		new Actions(e).contextClick(n).perform();
	}

	// double clk
	public static void DoubleClick(WebDriver d, WebElement e) {
		new Actions(d).doubleClick(e);

	}

}
