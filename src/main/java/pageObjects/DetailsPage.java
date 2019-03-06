package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import testDataTypes.Customer;

public class DetailsPage {
	WebDriver driver;
	JavascriptExecutor js;
	
	public DetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.NAME,using="firstname")
	private WebElement firstName;
	
	@FindBy(how=How.NAME,using="lastname")
	private WebElement lastName;
	
	@FindBy(how=How.NAME,using="email")
	private WebElement email;
	
	@FindBy(how=How.NAME,using="confirmemail")
	private WebElement confirmEmail;
	
	@FindBy(how=How.NAME,using="phone")
	private WebElement phone;
	
	@FindBy(how=How.NAME,using="address")
	private WebElement address;
	
	@FindBy(how=How.NAME,using="guest")
	private WebElement guest;
	
	@FindBy(how=How.XPATH, using=".//*[@id='s2id_autogen1']/a/span[1]")
	private WebElement country;
	
	@FindBy(how=How.XPATH, using="//div[@id='select2-drop']/ul/li[4]/div")
	private WebElement countrySelect;
	
	@FindBy(how=How.XPATH, using=".//*[@id='guestform']/div[8]/div/div[1]/label")
	private WebElement notesCheckbox;
	
	@FindBy(how=How.XPATH, using="//textarea[@name='additionalnotes']")
	private WebElement additionalNotes;
	                              
	@FindBy(how=How.XPATH, using=".//*[@id='bookingdetails']/div[2]/table/tbody/tr[1]/td[4]/label/span/span[1]")
	private WebElement extras;
	
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void enterEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void enterConfirmEmail(String ConfirmEmail) {
		confirmEmail.sendKeys(ConfirmEmail);
	}
	
	public void enterPhone(String Phone) {
		phone.sendKeys(Phone);
	}
	
	public void enterAddress(String Address) {
		address.sendKeys(Address);
	}
	
	public void selectCountry() {
		country.click();
		countrySelect.click();
	}
	
	public void enterAdditionalNotes(String AdditionalNotes) {
		notesCheckbox.click();
		additionalNotes.sendKeys(AdditionalNotes);
	}
	
	public void enterDetails(Customer customer) {
		js=(JavascriptExecutor)driver;
		enterFirstName(customer.firstName);
		enterLastName(customer.lastName);
		enterEmail(customer.email);
		enterConfirmEmail(customer.confirmEmail);
		enterPhone(customer.mobile);
		enterAddress(customer.address);
		selectCountry();
		enterAdditionalNotes(customer.address);
		js.executeScript("arguments[0].click();", extras);
	}
	
	public void confirmBooking() {
		guest.click();
	}
	
}
