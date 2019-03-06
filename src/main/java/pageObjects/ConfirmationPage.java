package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import selenium.Wait;

public class ConfirmationPage {

	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using=".//table[@id='invoiceTable']//table[1]//tr[7]//td[2]")
	private WebElement dropLocationName;
	
	public String getDropLocationName() {
		Wait.untilJqueryIsDone(driver);
		Wait.untilPageLoadComplete(driver);
		return dropLocationName.getText();
	}
}
