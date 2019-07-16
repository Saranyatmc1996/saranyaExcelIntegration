package PracticeMaven.Maven1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {
	static WebDriver driver;

	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUTHAKAR\\eclipse-workspace\\BasePom\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public static void loadUrl(String url) {
		driver.get(url);

	}

	public static void typeKeys(WebElement e, String name) {
		e.sendKeys(name);

	}

	public static void click(WebElement name) {
		name.click();
	}

	public static void DropText(WebElement a, String b) {
		new Select(a).selectByVisibleText(b);
	}

	public static void DropValue(WebElement c, String d) {
		new Select(c).selectByValue(d);
	}

	public static void DropIndex(WebElement f, int g) {
		new Select(f).selectByIndex(g);
	}
	
	public static void order(int rowNo, int cellNo, String OrderNo) throws IOException {
		File ff=new File("C:\\\\Users\\\\SUTHAKAR\\\\eclipse-workspace\\\\Maven1\\\\Excel\\\\Saran.xlsx");
		FileInputStream fsi=new FileInputStream(ff);
		Workbook wb=new XSSFWorkbook(fsi);
		Sheet she=wb.getSheet("saran");
		Row rr = she.getRow(rowNo);
		Cell cc = rr.createCell(cellNo);
		cc.setCellValue(OrderNo);
		FileOutputStream fos=new FileOutputStream(ff);
		wb.write(fos);
		
	}

	public static String getData(int rowNo, int cellNo) throws IOException {
		File f = new File("C:\\\\Users\\\\SUTHAKAR\\\\eclipse-workspace\\\\Maven1\\\\Excel\\\\Saran.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
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
				Date date = c.getDateCellValue();
				SimpleDateFormat fr = new SimpleDateFormat("dd/MM/yyyy");
				name = fr.format(date);
			} else {
				double d = c.getNumericCellValue();
				long l = (long) d;
				name = String.valueOf(l);

			}

		}
		return name;

	}public static String getDat(int rowN, int cellN) throws IOException {
		
		File f = new File("C:\\\\Users\\\\SUTHAKAR\\\\eclipse-workspace\\\\Maven1\\\\Excel\\\\Saran.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Data");
		
		return null;
		  
		
	}
	
	

}


