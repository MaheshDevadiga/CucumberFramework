package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import selenium.Wait;

public class BookPage {
	
	WebDriver driver;
	
	public BookPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(how=How.ID,using="droplocation")
	private WebElement dropDropdown;
	
	@FindBy(how=How.ID,using="pickuplocation")
	private WebElement pickDropdown;
	
	@FindBy(how=How.NAME,using="dropoffTime")
	private WebElement dropOffTimeDropdown;
	
	@FindBy(how=How.XPATH, using="(//button[@type='submit'])[1]")
	private WebElement bookNow;
	
	@FindBy(how=How.XPATH, using=".//*[@id='s2id_droplocation']/a/span[1]")
	private WebElement dropLocationName;
	
	public String getDropLocationtName() {
		return dropLocationName.getText();
	}
	
	public void bookNow() {
		Select selectDrop=new Select(dropDropdown);
		selectDrop.selectByIndex(2);
		Select selectPick=new Select(pickDropdown);
		selectPick.selectByIndex(1);
		Select selectDropOff=new Select(dropOffTimeDropdown);
		selectDropOff.selectByIndex(3);
		Wait.untilJqueryIsDone(driver);
	}
	
	public void clickBookBtn() {
		bookNow.click();
		Wait.untilJqueryIsDone(driver);
	}

}
