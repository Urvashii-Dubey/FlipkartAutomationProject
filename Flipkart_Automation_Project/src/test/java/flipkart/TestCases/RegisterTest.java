package flipkart.TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import flipkart.Pages.BasePage;
import flipkart.Pages.RegisterPage;

public class RegisterTest extends BasePage {

	// Register new User
	@Test(priority = 3, enabled = true, groups = {"smoke"})
	public void RegisterUser() throws InterruptedException {

		RegisterPage registerPage = new RegisterPage(driver);

		test.log(LogStatus.INFO, "-----------------------* Register page *-----------------------");
		logger.info("-----------------------* Register page  *-----------------------");

		registerPage.goToregisterLink();
		test.log(LogStatus.INFO, "Go register new user");
		logger.info("Go register new user");

		registerPage.enterMobileNumber("9180706050");
		test.log(LogStatus.INFO, "Entered mobile number");
		logger.info("Entered mobile number");

		registerPage.clickContinue();
		test.log(LogStatus.INFO, "Click on continue button");
		logger.info("Click on continue button");

		registerPage.enterOTP("210120");
		test.log(LogStatus.INFO, "Entered OTP");
		logger.info("Entered OTP");

		registerPage.signUp();
		test.log(LogStatus.INFO, "Clicked on signup button");
		logger.info("Clicked on signup button");

		// Assertion
		registerPage.assertRegistration();
		test.log(LogStatus.INFO, "Asserted that registration is not done due to Invalid OTP");
		logger.info("Asserted that registration is not done due to Invalid OTP");
	}
}
