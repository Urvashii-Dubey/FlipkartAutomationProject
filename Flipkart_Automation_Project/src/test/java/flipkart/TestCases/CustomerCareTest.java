package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.CustomerCarePage;
import flipkart.Pages.HomePage;
import flipkart.Utilities.ActionManager;

public class CustomerCareTest extends BasePage {

	@Test(priority = 17, enabled = true, groups = {"sanity"})
	public void FlipkartCustomerCare() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		CustomerCarePage customerPage = new CustomerCarePage(driver);

		homePage.closePopup();
		test.log(LogStatus.INFO, "-----------------------* Flipkart Customer Care *-----------------------");
		logger.info("-----------------------* Flipkart Customer Care *-----------------------");
		
		// Move to More link
		homePage.moveToElement();
		
		homePage.goToMoreLink();
		test.log(LogStatus.INFO, "Clicked on more link");
		logger.info("Clicked on more link");
		

		homePage.goToCustomerCarelink();
		test.log(LogStatus.INFO, "Go to 24x7 customer care");
		logger.info("Go to 24x7 customer care");
		
		// Wait for customer care page to be loaded
		customerPage.waitForCusCarePageLoad();

		// Assertion
		customerPage.assertCustomerCare();
		test.log(LogStatus.INFO, "Verified that customer care page is visible");
		logger.info("Verified that customer care page is visible");
	}
	
	@Test(priority = 18, enabled = true, groups = {"sanity"})
	public void HelpCustomerCare() throws InterruptedException {

		CustomerCarePage customerPage = new CustomerCarePage(driver);
		CustomerCareTest customerCare = new CustomerCareTest();
		
		// Go on customer care page
		customerCare.FlipkartCustomerCare();
		test.log(LogStatus.INFO, "-----------------------* Customer Care Help *-----------------------");
		logger.info("-----------------------* Customer Care Help *-----------------------");
		
		
		customerPage.clickHelpWithIssues();
		test.log(LogStatus.INFO, "Clicked on help with your Issues");
		logger.info("Clicked on help with your Issues");
		
		// Assertion
		customerPage.assertHelpWithIssues();
		test.log(LogStatus.INFO, "Verified help with issues page");
		logger.info("Verified help with issues page");
	}

	@Test(priority = 19, enabled = true, groups = {"sanity"})
	public void SuperCoinsHelpCentre() throws InterruptedException {

		CustomerCarePage customerPage = new CustomerCarePage(driver);
		CustomerCareTest customerCare = new CustomerCareTest();
		
		// Go on customer care page
		customerCare.FlipkartCustomerCare();
		test.log(LogStatus.INFO, "-----------------------* Super Coins Help Centre *-----------------------");
		logger.info("-----------------------* Super Coins Help Centre *-----------------------");
		
		// Scroll down a little
		ActionManager.singleScrollDown();
		
		customerPage.clickSuperCoins();
		test.log(LogStatus.INFO, "Clicked on super coins");
		logger.info("Clicked on super coins");
		
		// Assertion
		customerPage.assertSuperCoinsHelpCentre();
		test.log(LogStatus.INFO, "Verified super coins help centre page opened");
		logger.info("Verified super coins help centre page opened");
	}
}
