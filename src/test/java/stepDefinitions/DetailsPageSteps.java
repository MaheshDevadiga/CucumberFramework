package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.DetailsPage;
import testDataTypes.Customer;

public class DetailsPageSteps {
	
	DetailsPage detailsPage;
	TestContext testContext;
	
	public DetailsPageSteps(TestContext context) {
		testContext=context;
		detailsPage=testContext.getPageObjectManager().getDetailsPage();
	}
	
	@When("^he enters all \"([^\"]*)\" details$")
	public void he_enters_all_details(String customerName) throws Throwable {
	    Customer customer=FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
	    detailsPage.enterDetails(customer);
	    detailsPage.confirmBooking();
	}
}
