package seleniumTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E2E_Test {

	private static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\CucumberFramework\\WebDrivers\\chromedriver.exe");
		System.out.println(System.getProperty("user.dir"));
		driver=new ChromeDriver();
		
		/*System.setProperty("webdriver.gecko.driver", "D:\\CucumberFramework\\WebDrivers\\geckodriver.exe");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		 capabilities = DesiredCapabilities.firefox();
		 capabilities.setBrowserName("firefox");
		 capabilities.setVersion("41.0");
		 capabilities.setPlatform(Platform.WINDOWS);
		 capabilities.setCapability("marionette", false);

		 //WebDriver driver = new FirefoxDriver(capabilities);
		 driver=new FirefoxDriver(capabilities);*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.phptravels.net/");
		
		//click on Cars
		driver.findElement(By.xpath("//div[@id='body-section']//div[@class='col-md-12']//ul//li[4]//a")).click();
		//click pickup location
		/*driver.findElement(By.xpath("//div[@id='s2id_carlocations']/a/span[1]")).click();
		//select manchester
		driver.findElement(By.xpath("//div[@id='select2-drop']//li[2]")).click();*/
		//click drop location
		//driver.findElement(By.xpath("//div[@id='s2id_carlocations2']/a")).click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Select carLocation2= new Select(driver.findElement(By.id("carlocations2")));
		carLocation2.selectByIndex(2);
		
		Select carLocation= new Select(driver.findElement(By.id("carlocations")));
		carLocation.selectByIndex(1);
		//pick up date 
		
		js.executeScript("document.getElementById('departcar').value='11/02/2019';");
		//driver.findElement(By.xpath("//input[@id='departcar']")).click();
		Select pickup= new Select(driver.findElement(By.name("pickupTime")));
		pickup.selectByIndex(3);
		
		
		js.executeScript("document.getElementById('returncar').value='22/02/2019';");
		
		Select drop= new Select(driver.findElement(By.name("dropoffTime")));
		drop.selectByIndex(10);
		//click SEARCH Button
		
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//*[@id='cars']//button")));
		
		driver.findElement(By.xpath("(//button[contains(text(),'Details')])[2]")).click();
		//click pickup
		/*driver.findElement(By.xpath(".//*[@id='s2id_pickuplocation']/a/span[2]")).click();
		//select pickup location
		driver.findElement(By.xpath("//div[@id='select2-drop']//ul//li[2]")).click();
		//click dropoff location
		driver.findElement(By.xpath(".//*[@id='s2id_droplocation']/a/span[1]")).click();*/
		Select drpLocation= new Select(driver.findElement(By.id("droplocation")));
		drpLocation.selectByIndex(2);
		
		Select pickLocation= new Select(driver.findElement(By.id("pickuplocation")));
		pickLocation.selectByIndex(1);
		
		
		//select dropoff Time
		Select drpOffTime= new Select(driver.findElement(By.name("dropoffTime")));
		drpOffTime.selectByIndex(3);
		//click Book Now
		
		
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		//Enter FirstName
		driver.findElement(By.name("firstname")).sendKeys("Jai");
		//Enter Lastname
		driver.findElement(By.name("lastname")).sendKeys("Singh");
		//Enter Email
		driver.findElement(By.name("email")).sendKeys("Jai@gmail.com");
		//Enter Confirm Email
		driver.findElement(By.name("confirmemail")).sendKeys("Jai@gmail.com");
		//Enter Mobile
		driver.findElement(By.name("phone")).sendKeys("1234567890");
		//Enter Address
		driver.findElement(By.name("address")).sendKeys("Bangalore");
		//Click Country
		driver.findElement(By.xpath(".//*[@id='s2id_autogen1']/a/span[1]")).click();
		//Select Country
		driver.findElement(By.xpath("//div[@id='select2-drop']/ul/li[4]/div")).click();
		//Click Notes
		driver.findElement(By.xpath(".//*[@id='guestform']/div[8]/div/div[1]/label")).click();
		//Enter Notes
		driver.findElement(By.xpath("//textarea[@name='additionalnotes']")).sendKeys("Fine");
		//Click Order
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='bookingdetails']/div[2]/table/tbody/tr[1]/td[4]/label/span/span[1]")));
		
		//confirm booking
		driver.findElement(By.name("guest")).click();
		//Pay Now
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//button[contains(text(),'Pay Now')])[1]")));
		//Payment method
		Select gateway= new Select(driver.findElement(By.id("gateway")));
		gateway.selectByIndex(4);
		
		//Pay By
		driver.findElement(By.id("card-holder-firstname")).sendKeys("Jai");
		driver.findElement(By.id("card-holder-lastname")).sendKeys("Singh");
		driver.findElement(By.id("card-number")).sendKeys("1111222233331234");
		driver.findElement(By.id("cvv")).sendKeys("123");
		Select expiry= new Select(driver.findElement(By.id("expiry-year")));
		expiry.selectByIndex(10);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//button[contains(text(),'Pay Now')])[2]")));
		driver.close();
		
		
	}

}
