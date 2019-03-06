package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;

public class HomePage {
	WebDriver driver;
	JavascriptExecutor js;
	ConfigFileReader configFileReader;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		configFileReader=new ConfigFileReader();
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='body-section']//div[@class='col-md-12']//ul//li[4]//a")
	private WebElement carMenu;
	
	@FindBy(how=How.ID,using="carlocations")
	private WebElement pickDropdown;
	
	@FindBy(how=How.ID,using="carlocations2")
	private WebElement dropDropdown;
	
	@FindBy(how=How.NAME,using="pickupTime")
	private WebElement pickUpTimeDropdown;
	
	@FindBy(how=How.NAME,using="dropoffTime")
	private WebElement dropOffTimeDropdown;
	
	@FindBy(how=How.XPATH,using="//*[@id='cars']//button")
	private WebElement searchBtn;
	
	public void navigateTo_CarPage() {
		carMenu.click();
	}
	
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationURL());
	}
	
	public void select_Location_Time(String pickDate,String dropDate) {
		Select selectDrop=new Select(dropDropdown);
		selectDrop.selectByIndex(2);
		Select selectPick=new Select(pickDropdown);
		selectPick.selectByIndex(1);
		js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('departcar').value='"+pickDate+"';");
		Select pickTime=new Select(pickUpTimeDropdown);
		pickTime.selectByIndex(3);
		js.executeScript("document.getElementById('returncar').value='"+dropDate+"';");
		Select dropTime=new Select(dropOffTimeDropdown);
		dropTime.selectByIndex(10);
		js.executeScript("arguments[0].click();", searchBtn);
	}
}
