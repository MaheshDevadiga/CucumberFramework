package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CarsPage {

	public CarsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="(//button[contains(text(),'Details')])[1]")
	private WebElement toyotaCar;
	
	public void selectCar() {
		toyotaCar.click();
	}
}
