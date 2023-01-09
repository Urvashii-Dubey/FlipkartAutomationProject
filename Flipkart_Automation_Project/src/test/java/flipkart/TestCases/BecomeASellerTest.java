package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.BecomeASellerPage;
import flipkart.Pages.HomePage;

public class BecomeASellerTest extends BasePage {

	@Test(priority = 5, enabled = true, groups = { "smoke" })
	public void BecomeASeller() {

		HomePage homePage = new HomePage(driver);
		BecomeASellerPage sellerPage = new BecomeASellerPage(driver);

		homePage.closePopup();
		test.log(LogStatus.INFO, "-----------------------* Become a Seller Page Test *-----------------------");
		logger.info("-----------------------* Become a Seller Page Test *-----------------------");

		homePage.goToBecomeSellerLink();
		test.log(LogStatus.INFO, "Go to become a seller link");
		logger.info("Go to become a seller link");

		sellerPage.startSelling();
		test.log(LogStatus.INFO, "Clicked on start selling");
		logger.info("Clicked on start selling");

		sellerPage.enterNumber(sellerPage.Number);
		test.log(LogStatus.INFO, "Entered mobile number");
		logger.info("Entered mobile number");

		sellerPage.enterEmail(sellerPage.Email);
		test.log(LogStatus.INFO, "Entered Email");
		logger.info("Entered Email");

		sellerPage.waitForPopup();
		sellerPage.closePopUp();

		sellerPage.enterGSTIN(sellerPage.GSTIN);
		test.log(LogStatus.INFO, "Entered GSTIN number");
		logger.info("Entered GSTIN number");

		sellerPage.registerAndContinueButton();
		test.log(LogStatus.INFO, "Clicked on register and continue");
		logger.info("Clicked on register and continue");

		// Assertion
		sellerPage.assertBecomeASeller();
		test.log(LogStatus.INFO, "Asserted that the seller is failed to register cause of incorrect OTP");
		logger.info("Asserted that the seller is failed to register cause of incorrect OTP");
	}
	
	@Test(priority = 6, enabled = true, groups = { "sanity" })
	public void SellerServices() {

		HomePage homePage = new HomePage(driver);
		BecomeASellerPage sellerPage = new BecomeASellerPage(driver);

		homePage.closePopup();
		test.log(LogStatus.INFO, "-----------------------* Seller Services *-----------------------");
		logger.info("-----------------------* Seller Services *-----------------------");

		homePage.goToBecomeSellerLink();
		test.log(LogStatus.INFO, "Go to become a seller link");
		logger.info("Go to become a seller link");
		
		sellerPage.clickOnServicesLink();
		test.log(LogStatus.INFO, "Go to services link");
		logger.info("Go to services link");
		
		sellerPage.OpenServicesPage();
		test.log(LogStatus.INFO, "Open services page");
		logger.info("Open services page");
		
		// Assertion
		sellerPage.assertSellerServices();
		test.log(LogStatus.INFO, "Verfied seller services page");
		logger.info("Verfied seller services page");
	}

}