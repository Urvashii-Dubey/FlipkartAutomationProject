package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.FlipkartSocialLinksPage;
import flipkart.Pages.HomePage;
import flipkart.Utilities.ActionManager;
import flipkart.Utilities.CommonUtils;

public class FlipkartSocialLinksTest extends BasePage {
	
	@Test(priority = 9, enabled = true, groups = {"sanity"})
	public void FlipkartFacebookPage() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		FlipkartSocialLinksPage flipkartSocialLinksPage = new FlipkartSocialLinksPage(driver);

		test.log(LogStatus.INFO, "opened homepage");
		homePage.closePopup();
		test.log(LogStatus.INFO, "-----------------------* Flipkart Facebook Page Test *-----------------------");
		logger.info("-----------------------* Flipkart Facebook Page Test *-----------------------");

		// scroll to the footer of the page
		ActionManager.scrollDownToBottom();
		test.log(LogStatus.INFO, "Scroll down to the bottom of the page");
		logger.info("Scroll down to the bottom of the page");

		flipkartSocialLinksPage.goToFacebookLink();
		test.log(LogStatus.INFO, "Clicked on facebook link");
		logger.info("Clicked on facebook link");
		
		// Switched to next tab
		CommonUtils.switchTab();
			
		// Wait for facebook page load
		flipkartSocialLinksPage.waitForFacebookPageLoad();
		
		// Assertion
		flipkartSocialLinksPage.assertFacebook();
		test.log(LogStatus.INFO, "Verfied Facebook Page");
		logger.info("Verfied Facebook Page");
	}

	@Test(priority = 10, enabled = true, groups = {"sanity"})
	public void FlipkartTwitterHandle() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		FlipkartSocialLinksPage flipkartSocialLinksPage = new FlipkartSocialLinksPage(driver);

		homePage.closePopup();
		test.log(LogStatus.INFO, "-----------------------* Flipkart Twitter Page Test *-----------------------");
		logger.info("-----------------------* Flipkart Twitter Page Test *-----------------------");

		// scroll to the footer of the page
		ActionManager.scrollDownToBottom();
		test.log(LogStatus.INFO, "Scroll down to the bottom of the page");
		logger.info("Scroll down to the bottom of the page");

		flipkartSocialLinksPage.goTotwitterLink();
		test.log(LogStatus.INFO, "Clicked on twitter link");
		logger.info("Clicked on twitter link");
		
		// Switched to next tab
		CommonUtils.switchTab();
		
		// Wait for twitter page load
		flipkartSocialLinksPage.waitForTwitterPageLoad();
		
		// Assertion
		flipkartSocialLinksPage.assertTwitter();
		test.log(LogStatus.INFO, "Verfied twitter Page");
		logger.info("Verfied tweitter Page");
	}

	@Test(priority = 11, enabled = true, groups = {"sanity"})
	public void FlipkartYouTubeChannel() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		FlipkartSocialLinksPage flipkartSocialLinksPage = new FlipkartSocialLinksPage(driver);

		homePage.closePopup();
		test.log(LogStatus.INFO, "-----------------------* Flipkart YouTube Page Test *-----------------------");
		logger.info("-----------------------* Flipkart YouTube Page Test *-----------------------");

		// scroll to the footer of the page
		ActionManager.scrollDownToBottom();
		test.log(LogStatus.INFO, "Scroll down to the bottom of the page");
		logger.info("Scroll down to the bottom of the page");

		flipkartSocialLinksPage.openYouTubeLink();
		test.log(LogStatus.INFO, "Clicked on YouTube link");
		logger.info("Clicked on youTube link");
		
		// Switched to next tab
		CommonUtils.switchTab();
		
		// Wait for youtube page load
		flipkartSocialLinksPage.waitForYouTubePageLoad();
		
		// Assertion
		flipkartSocialLinksPage.assertYouTube();
		test.log(LogStatus.INFO, "Verfied YouTube Page");
		logger.info("Verfied YouTube Page");
	}
}
