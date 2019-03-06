package stepDefinitions;



import cucumber.TestContext;
import cucumber.api.java.en.When;
import enums.Context;
import pageObjects.BookPage;

public class BookPageSteps {
	
	TestContext testContext;
	BookPage bookPage;
	
	public BookPageSteps(TestContext context) {
		testContext=context;
		bookPage=testContext.getPageObjectManager().getBookPage();
	}

	@When("^he selects location and time$")
	public void he_selects_location_and_time() throws Throwable {
		bookPage.bookNow();
		String dropLocationName=bookPage.getDropLocationtName();
		testContext.scenarioContext.setContext(Context.LOCATION_NAME, dropLocationName);
		bookPage.clickBookBtn();
	}

}
