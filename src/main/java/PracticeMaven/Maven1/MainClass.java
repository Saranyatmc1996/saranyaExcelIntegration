package PracticeMaven.Maven1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

import com.beust.jcommander.Parameters;

public class MainClass extends HelperClass {
public static void main(String[] args) throws IOException, InterruptedException {
	LaunchBrowser();
	getUrl("http://www.adactin.com/HotelApp/");
	Login l=new Login();
	inPut(l.getUser(),getData(0,1));
	inPut(l.getPass(),getData(1,1));
	click(l.getLogin());
	SelectHotel s=new SelectHotel();
	SelectByVisibleText(s.getLoc(),getData(2,1));
	SelectByVisibleText(s.getHtl(),getData(3,1));
	SelectByVisibleText(s.getRm(),getData(4,1));
	SelectByVisibleText(s.getNorm(),getData(5,1));  
	SelectByVisibleText(s.getAd(),getData(6,1));  
	SelectByVisibleText(s.getCrm(),getData(7,1));
	click(s.getSrch());
	click(s.getRadio());
	click(s.getCnue());
	BookHotel b=new BookHotel();
	inPut(b.getFname(),getData(9,1));
	inPut(b.getLname(),getData(10,1));
	inPut(b.getAddress(),getData(11,1));
	inPut(b.getCcvNo(),getData(12,1));
	SelectByVisibleText(b.getCcType(),getData(13,1));
	SelectByVisibleText(b.getMonth(),getData(14,1));
	SelectByVisibleText(b.getYear(),getData(15,1));
	inPut(b.getCvvNo(),getData(16,1));
	click(b.getBook());	
	Thread.sleep(2000);
	
	writeCellValue(1,5,b.getPrint().getAttribute("value"));
	
}

}