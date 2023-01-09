package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.FlipkartStoriesPage;
import flipkart.Pages.HomePage;
import flipkart.Utilities.ActionManager;
import flipkart.Utilities.CommonUtils;

public class FlipkartStoriesTest extends BasePage {

	@Test(priority = 15, enabled = true, groups = {"sanity"})
	public void FlipkartStories() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		FlipkartStoriesPage flipkartStoriesPage = new FlipkartStoriesPage(driver);

		homePage.closePopup();
		test.log(LogStatus.INFO, "-----------------------* Flipkart Stories/News *-----------------------");
		logger.info("-----------------------* Flipkart Stories/News *-----------------------");
		
		// scroll to the footer of the page
		ActionManager.scrollDownToBottom();
		test.log(LogStatus.INFO, "Scroll down to the bottom of the page");
		logger.info("Scroll down to the bottom of the page");

		homePage.clickOnPressLink();
		test.log(LogStatus.INFO, "Clicked on flipkart stories link");
		logger.info("Clicked on flipkart stories link");

		// Switched to next tab
		CommonUtils.switchTab();
		
		// wait for element visibility
		flipkartStoriesPage.waitForPresenceOfElement();
		
		// Assertion
		flipkartStoriesPage.assertFlipkartStories();
		test.log(LogStatus.INFO, "Verified stories page is visible");
		logger.info("Verified stories page is visible");
	}

}
