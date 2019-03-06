package stepDefinitions;


import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.CarsPage;

public class CarPageSteps {

	TestContext testContext;
	CarsPage carsPage;
	
	public CarPageSteps(TestContext context) {
		testContext=context;
		carsPage=testContext.getPageObjectManager().getCarsPage();
	}
	
	@When("^he selects the Toyota Car$")
	public void he_selects_the_Toyota_Car() throws Throwable {
		carsPage.selectCar();
	}
}
