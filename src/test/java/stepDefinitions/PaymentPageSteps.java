package stepDefinitions;



import cucumber.TestContext;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.PaymentPage;
import testDataTypes.CreditCard;

public class PaymentPageSteps {
	
	TestContext testContext;
	PaymentPage paymentPage;
	
	public PaymentPageSteps(TestContext context) {
		testContext=context;
		paymentPage=testContext.getPageObjectManager().getPaymentPage();
	}
	
	@When("^he selects credit card for payment$")
	public void he_selects_credit_card_for_payment() throws Throwable {
		paymentPage.paymentMethod();
	}

	/*@When("^he enters credit card details$")
	public void he_enters_credit_card_details() throws Throwable {
		paymentPage.makePayment();
	}*/
	
	@When("^he enters \"([^\"]*)\" details$")
	public void he_enters_details(String creditCardName) throws Throwable {
	    CreditCard creditCard=FileReaderManager.getInstance().getJsonReader().getCreditCardByName(creditCardName);
	    paymentPage.makePayment(creditCard);
	}

}
