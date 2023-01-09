package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.HomePage;
import flipkart.Pages.SearchAProductPage;
import flipkart.Utilities.CommonUtils;

public class SearchAProductTest extends BasePage {

	@Test(priority = 12, enabled = true, groups = {"smoke"})
	public void SearchAProduct() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		SearchAProductPage searchAProductPage = new SearchAProductPage(driver);

		homePage.closePopup();
		test.log(LogStatus.INFO, "-----------------------* Search A Product *-----------------------");
		logger.info("-----------------------* Search A Product *-----------------------");

		homePage.clickOnsearchBox();
		test.log(LogStatus.INFO, "Go on search box");
		logger.info("Go on search box");

		homePage.enterProductInSearchBox(searchAProductPage.ProductName);
		test.log(LogStatus.INFO, "Entered product name");
		logger.info("Entered product name");

		homePage.clickOnsearchButton();
		test.log(LogStatus.INFO, "Clicked on search");
		logger.info("Clicked on search");

		// Wait for product search completion
		searchAProductPage.waitForProductSearchCompletion();

		searchAProductPage.clickOnViewProduct();
		test.log(LogStatus.INFO, "View product");
		logger.info("View product");

		// Switched to next tab
		CommonUtils.switchTab();

		// Assertion
		searchAProductPage.assertSearchProduct();
		test.log(LogStatus.INFO, "Verfied product search");
		logger.info("Verfied product search");
	}

}
