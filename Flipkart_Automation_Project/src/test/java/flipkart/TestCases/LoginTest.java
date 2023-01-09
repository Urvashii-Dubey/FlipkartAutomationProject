package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.HomePage;
import flipkart.Pages.LoginPage;

public class LoginTest extends BasePage {
	
	// Invalid login by entering wrong phone number
	@Test(priority = 1, enabled = true, groups = {"smoke"})
	public void InvalidNumberLogin() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);

		test.log(LogStatus.INFO, "-----------------------* Invalid Phone no Login *-----------------------");
		logger.info("-----------------------* Invalid Phone no. Login *-----------------------");

		loginPage.enterMobileNumber(loginPage.InvalidNumberLogin);
		test.log(LogStatus.INFO, "Entered mobile number");
		logger.info("Entered mobile number");

		loginPage.requestOTP();
		test.log(LogStatus.INFO, "Clicked on request OTP");
		logger.info("Clicked on request OTP");

		// Assertion
		loginPage.assertInvalidLogin();
		test.log(LogStatus.INFO, "Asserted that login is not done due to invalid mob no");
		logger.info("Asserted that login is not done due to Invalid mob no");

	}

	// valid number with invalid OTP
	@Test(priority = 2, enabled = true, groups = {"smoke"})
	public void ValidNumberLogin() throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		homePage.closePopup();
		homePage.goToLoginLink();
		test.log(LogStatus.INFO,
				"-----------------------* Valid Number with Incorrect OTP Login *-----------------------");
		logger.info("-----------------------* Valid Number with Incorrect OTP Login *-----------------------");

		loginPage.enterMobileNumber(loginPage.ValidNumberLogin);
		test.log(LogStatus.INFO, "Entered mobile number");
		logger.info("Entered mobile number");

		loginPage.requestOTP();
		test.log(LogStatus.INFO, "Clicked on request OTP");
		logger.info("Clicked on request OTP");

		// Wait for OTP
		loginPage.waitForOTP();

		// If you have correct OTP then enter the correct OTP
		loginPage.enterOTP(loginPage.OTP);
		test.log(LogStatus.INFO, "Entered OTP");
		logger.info("Entered OTP");

		loginPage.verifyOTP();
		test.log(LogStatus.INFO, "Clicked on verify OTP");
		logger.info("Clicked on verify OTP");
		
		// Wait for OTP verification
		loginPage.waitForVerification();
		
		// Assertion
		loginPage.assertValidNumberWithWrongOTP();
		test.log(LogStatus.INFO, "Asserted that login is not done due to Invalid OTP");
		logger.info("Asserted that login is not done due to Invalid OTP");
	}
}
