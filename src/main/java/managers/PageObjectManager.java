package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.BookPage;
import pageObjects.CarsPage;
import pageObjects.ConfirmationPage;
import pageObjects.DetailsPage;
import pageObjects.HomePage;
import pageObjects.PaymentPage;

public class PageObjectManager {
	private WebDriver driver;
	private HomePage homePage;
	private CarsPage carsPage;
	private BookPage bookPage;
	private DetailsPage detailsPage;
	private PaymentPage paymentPage;
	private ConfirmationPage confirmationPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public HomePage getHomePage() {
		return (homePage == null) ? homePage=new HomePage(driver) : homePage;
	}
	
	public CarsPage getCarsPage() {
		return (carsPage == null) ? carsPage=new CarsPage(driver) : carsPage;
	}
	
	public BookPage getBookPage() {
		return (bookPage == null) ? bookPage=new BookPage(driver) : bookPage;
	}
	
	public DetailsPage getDetailsPage() {
		return (detailsPage == null) ? detailsPage=new DetailsPage(driver) : detailsPage;
	}
	
	public PaymentPage getPaymentPage() {
		return (paymentPage == null) ? paymentPage=new PaymentPage(driver) : paymentPage;
	}
	
	public ConfirmationPage getConfirmationPage() {
		return (confirmationPage == null) ? confirmationPage=new ConfirmationPage(driver) : confirmationPage;
	}
}
