package PracticeMaven.Maven1;

import java.io.IOException;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainNg extends HelperClass {

	@BeforeClass
	public void lanchurl() {
		LaunchBrowser();
		getUrl("http://www.adactin.com/HotelApp/");
	}
	/*@AfterClass
	public void quitBrowse() {
		quitBrow();
	}*/
	
	@BeforeMethod
	public void inTime() {
		Date d=new Date();
		System.out.println(d);

	}
	@AfterMethod
	public void outTime() {
		Date d=new Date();
		System.out.println(d);

	}
	
	@Test
	
	public void businessLogic() throws IOException, InterruptedException {
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
