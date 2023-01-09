package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.ExplorePlusPage;
import flipkart.Pages.HomePage;

public class ExplorePlusTest extends BasePage {

	@Test(priority = 16, enabled = true, groups = {"sanity"})
	public void ExplorePlus() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		ExplorePlusPage explorePlus = new ExplorePlusPage(driver);

		homePage.closePopup();
		test.log(LogStatus.INFO,
				"-----------------------* Explore Plus Page *-----------------------");
		logger.info("-----------------------* Explore Plus Page *-----------------------");
		
		homePage.clickOnExplorePlusLink();;
		test.log(LogStatus.INFO, "Go to Explore Plus link");
		logger.info("Go to Explore Plus link");
		
		explorePlus.waitForFlipkartPlusTitle();
		
		// Assertion
		explorePlus.explorePlusAssertion();
		test.log(LogStatus.INFO, "Asserted that the seller is failed to register cause of incorrect OTP");
		logger.info("Asserted that the seller is failed to register cause of incorrect OTP");
	}
}

