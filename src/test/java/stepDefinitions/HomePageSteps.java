package stepDefinitions;

import java.util.List;

import com.cucumber.listener.Reporter;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import pageObjects.HomePage;

public class HomePageSteps {
	TestContext testContext;
	HomePage homePage;
	
	
	public HomePageSteps(TestContext context) {
		testContext=context;
		homePage=testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("^Customer is on home page$")
	public void customer_is_on_home_page() throws Throwable {
		homePage.navigateTo_HomePage();
		Reporter.addStepLog("User is in Home Page");
		Reporter.addScenarioLog("scenario has started");
	}

	@When("^Customer navigates to car booking page$")
	public void customer_navigates_to_car_booking_page() throws Throwable {
		homePage.navigateTo_CarPage();
	}

	@When("^he books the car on <date> to <date> from Manchester to Kaapa$")
	public void he_books_the_car_on_date_to_date_from_Manchester_to_Kaapa(DataTable arg1) throws Throwable {
		List<List<String>> data=arg1.raw();
		homePage.select_Location_Time(data.get(0).get(0), data.get(0).get(1));
	}

}
