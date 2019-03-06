package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testDataTypes.CreditCard;

public class PaymentPage {
	WebDriver driver;
	JavascriptExecutor js;
	public PaymentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="(//button[contains(text(),'Pay Now')])[1]")
	private WebElement payNowBtn;
	
	@FindBy(how=How.ID,using="gateway")
	private WebElement gatewayDropdown;
	
	@FindBy(how=How.ID,using="card-holder-firstname")
	private WebElement cardFirstName;
	
	@FindBy(how=How.ID,using="card-holder-lastname")
	private WebElement cardLastName;
	
	@FindBy(how=How.ID,using="card-number")
	private WebElement cardNumber;
	
	@FindBy(how=How.ID,using="cvv")
	private WebElement cvv;
	
	@FindBy(how=How.ID,using="expiry-year")
	private WebElement expiryDropdown;
	
	@FindBy(how=How.XPATH, using="(//button[contains(text(),'Pay Now')])[2]")
	private WebElement payNowBtn2;
	
	public void enterCardFName(String fname) {
		cardFirstName.sendKeys(fname);
	}
	
	public void enterCardLName(String lname) {
		cardLastName.sendKeys(lname);
	}
	
	public void enterCardNumber(String CardNumber) {
		cardNumber.sendKeys(CardNumber);
	}
	
	public void enterCVV(String CVV) {
		cvv.sendKeys(CVV);
	}
	
	public void paymentMethod() {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",payNowBtn);
		Select selectGateway=new Select(gatewayDropdown);
		selectGateway.selectByIndex(4);
	}
	
	public void makePayment(CreditCard creditCard) {
		js=(JavascriptExecutor)driver;
		enterCardFName(creditCard.firstName);
		enterCardLName(creditCard.lastName);
		enterCardNumber(creditCard.cardNumber);
		enterCVV(creditCard.cvv);
		Select selectExpiry=new Select(expiryDropdown);
		selectExpiry.selectByIndex(10);
		js.executeScript("arguments[0].click();",payNowBtn2);
	}
	

}
