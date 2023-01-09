package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.FlipkartAdsPage;
import flipkart.Pages.HomePage;
import flipkart.Utilities.ActionManager;

public class FlipkartAdsTest extends BasePage {

	@Test(priority = 6, enabled = true, groups = {"sanity"})
	public void FlipkartAdsInvalidCredentialsLogin() {

		HomePage homePage = new HomePage(driver);
		FlipkartAdsPage flipkartAdsPage = new FlipkartAdsPage(driver);

		homePage.closePopup();
		test.log(LogStatus.INFO,
				"-----------------------* Flipkart Ads Invalid Credential Login *-----------------------");
		logger.info("-----------------------* Flipkart Ads Invalid Credential Login *-----------------------");
		
		// Move to More link
		homePage.moveToElement();
		
		homePage.goToMoreLink();
		test.log(LogStatus.INFO, "Go to more link");
		logger.info("Go to more link");

		homePage.goToAvertiseLink();
		test.log(LogStatus.INFO, "Go to advertise link");
		logger.info("Go to advertise link");

		flipkartAdsPage.enterEmail(flipkartAdsPage.InvalidEmail);
		test.log(LogStatus.INFO, "Entered email");
		logger.info("Entered email");

		flipkartAdsPage.enterPassword(flipkartAdsPage.InvalidPassword);
		test.log(LogStatus.INFO, "Entered Password");
		logger.info("Entered password");

		flipkartAdsPage.clickOnLogin();
		test.log(LogStatus.INFO, "Clicked on login");
		logger.info("CLicked on login");

		// Wait for Incorrect credential pop-up
		flipkartAdsPage.waitForPopup();

		// Assertion
		flipkartAdsPage.assertInvalidLogin();
		test.log(LogStatus.INFO, "Verified that the user is not logged in cause of wrong credentials");
		logger.info("Verified that the user is not logged in cause of wrong credentials");

	}

	@Test(priority = 7, enabled = true, groups = {"sanity"})
	public void FlipkartAdsValidDataLogin() {

		HomePage homePage = new HomePage(driver);
		FlipkartAdsPage flipkartAdsPage = new FlipkartAdsPage(driver);

		homePage.closePopup();
		test.log(LogStatus.INFO,
				"-----------------------* Flipkart Ads Valid Credential Login *-----------------------");
		logger.info("-----------------------* Flipkart Ads Valid Credential Login *-----------------------");
		
		// Move to More link
		homePage.moveToElement();
		
		homePage.goToMoreLink();
		test.log(LogStatus.INFO, "Go to more link");
		logger.info("Go to more link");

		homePage.goToAvertiseLink();
		test.log(LogStatus.INFO, "Go to advertise link");
		logger.info("Go to advertise link");

		flipkartAdsPage.enterEmail(flipkartAdsPage.ValidEmail);
		test.log(LogStatus.INFO, "Entered email");
		logger.info("Entered email");

		flipkartAdsPage.enterPassword(flipkartAdsPage.ValidPassword);
		test.log(LogStatus.INFO, "Entered Password");
		logger.info("Entered password");

		flipkartAdsPage.clickOnLogin();
		test.log(LogStatus.INFO, "Clicked on login");
		logger.info("CLicked on login");

		// Assertion
		flipkartAdsPage.assertValidLogin();
		test.log(LogStatus.INFO, "Verified that the user is logged in");
		logger.info("Verified that the user is logged in");

	}

	@Test(priority = 8, enabled = true, groups = {"sanity"})
	public void FlipkartAdsLogout() {

		FlipkartAdsPage flipkartAdsPage = new FlipkartAdsPage(driver);

		// logged in
		FlipkartAdsTest login = new FlipkartAdsTest();
		login.FlipkartAdsValidDataLogin();
		
		test.log(LogStatus.INFO, "-----------------------* Flipkart Ads Logout Test *-----------------------");
		logger.info("-----------------------* Flipkart Ads Logout Test *-----------------------");
		
		// close pop-up
		ActionManager.closePopUpBox();
		
		flipkartAdsPage.clickOnEmailAddress();
		test.log(LogStatus.INFO, "Clicked on user's email");
		logger.info("Clicked on user's email");

		flipkartAdsPage.logout();
		test.log(LogStatus.INFO, "Clicked log Out");
		logger.info("Clicked log Out");

		// Assertion
		flipkartAdsPage.assertLogout();
		test.log(LogStatus.INFO, "Verified that the user is logged out");
		logger.info("Verified that the user is logged out");

	}

}
