package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.FlipkartCareerPage;
import flipkart.Pages.HomePage;
import flipkart.Utilities.ActionManager;

public class FlipkartCareerTest extends BasePage {

	@Test(priority = 4, enabled = true, groups = {"sanity"})
	public void FlipkartCareer() throws Exception {

		HomePage homePage = new HomePage(driver);
		FlipkartCareerPage careerPage = new FlipkartCareerPage(driver);

		homePage.closePopup();
		test.log(LogStatus.INFO, "-----------------------* Flipkart Career Page Test *-----------------------");
		logger.info("-----------------------* Flipkart Career Page Test *-----------------------");

		// scroll to the footer of the page
		ActionManager.scrollDownToBottom();
		test.log(LogStatus.INFO, "Scroll down to the bottom of the page");
		logger.info("Scroll down to the bottom of the page");

		homePage.clickOnCareerLink();
		test.log(LogStatus.INFO, "Clicked on careers link");
		logger.info("Clicked on careers link");
		
		// Wait for Page Load
		careerPage.waitForCareerPageLoad();
		
		// Assertion for career page
		careerPage.assertCareerPage();
		test.log(LogStatus.INFO, "Career Page visible");
		logger.info("Career Page visible");

		careerPage.clickInterviewAtFLipkart();
		test.log(LogStatus.INFO, "Clicked on Interview At Flipkart");
		logger.info("Clicked on Interview At Flipkart");
		
		// Scroll down a little
		ActionManager.singleScrollDown();
		
		ActionManager.singleScrollDown();
		careerPage.clickOnEngineering();
		test.log(LogStatus.INFO, "Clicked on engineering");
		logger.info("visibleClicked on engineering");

		// assertion
		careerPage.assertCareerEngineering();
		test.log(LogStatus.INFO, "Asserted that the engineering page is visible");
		logger.info("Asserted that the engineering page is visible");
	}
}
