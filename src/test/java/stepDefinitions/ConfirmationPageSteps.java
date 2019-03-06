package stepDefinitions;

import org.junit.Assert;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import pageObjects.ConfirmationPage;
import selenium.Wait;

public class ConfirmationPageSteps {

	TestContext testContext;
	ConfirmationPage confirmationPage;
	
	public ConfirmationPageSteps(TestContext context) {
		testContext=context;
		confirmationPage=testContext.getPageObjectManager().getConfirmationPage();
	}
	
	@Then("^verify the DropLocationName$")
	public void verify_the_DropLocationName() throws Throwable {
	    String locationName=(String)testContext.scenarioContext.getContext(Context.LOCATION_NAME);
	    Assert.assertEquals(locationName, confirmationPage.getDropLocationName());
	    //Assert.assertEquals(locationName,"mahesh");
	}
}
