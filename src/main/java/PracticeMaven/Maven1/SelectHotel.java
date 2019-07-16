package PracticeMaven.Maven1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends HelperClass {
	public SelectHotel() {	
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="location")
	private WebElement loc;
	@FindBy(id="hotels")
	private WebElement htl;
	@FindBy(id="room_type")
	private WebElement rm;

	@FindBy(id="room_nos")
	private WebElement norm;

	@FindBy(id="adult_room")
	private WebElement ad;

	@FindBy(id="child_room")
	private WebElement crm;

	@FindBy(id="Submit")
	private WebElement srch;

	@FindBy(id="radiobutton_0")
	private WebElement radio;
	
	@FindBy(id="continue")
	private WebElement cnue;

	public WebElement getLoc() {
		return loc;
	}

	public WebElement getHtl() {
		return htl;
	}

	public WebElement getRm() {
		return rm;
	}

	public WebElement getNorm() {
		return norm;
	}

	public WebElement getAd() {
		return ad;
	}

	public WebElement getCrm() {
		return crm;
	}

	public WebElement getSrch() {
		return srch;
	}

	public WebElement getRadio() {
		return radio;
	}

	public WebElement getCnue() {
		return cnue;
	}
	
}
