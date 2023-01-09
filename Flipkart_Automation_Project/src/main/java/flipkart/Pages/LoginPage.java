package flipkart.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {

	public WebDriver driver;
	public String InvalidNumberLogin = excelFile.getCellData(1, 2);
	public String ValidNumberLogin = excelFile.getCellData(2, 2);
	public String OTP = excelFile.getCellData(2, 3);
	public String InvalidNumberExpectedTitle = excelFile.getCellData(1, 8);
	public String ValidNumberWithWrongOTPExpectedTitle = excelFile.getCellData(2, 8);

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement btn_login;

	@FindBy(how = How.XPATH, using = "//input[@class='_2IX_2- VJZDxU']")
	public WebElement txt_mobileNumber;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Request OTP')]")
	public WebElement btn_requestOTP;

	@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
	public WebElement txt_OTPNumber;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Verify')]")
	public WebElement btn_verifyOTP;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Please enter valid Email ID/Mobile number')]")
	public WebElement txt_errorEmailAndNumber;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'OTP is incorrect')]")
	public WebElement txt_errorOTP;

	@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]")
	public WebElement txt_waitForOTP;

	public void enterMobileNumber(String number) {

		txt_mobileNumber.sendKeys(number);
	}

	public void requestOTP() {

		btn_requestOTP.click();
	}

	public void enterOTP(String OTP) {

		txt_OTPNumber.sendKeys(OTP);
	}

	public void verifyOTP() {

		btn_verifyOTP.click();
	}

	public String incorrectNumber() {

		return txt_errorEmailAndNumber.getText();
	}

	public String incorrectOTP() {

		return txt_errorOTP.getText();
	}

	public void waitForOTP() {
		String waitForOTP = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(waitForOTP)));
	}
	
	public void waitForVerification() {
		String errorOTP = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorOTP)));
	}

	public void assertInvalidLogin() {
		String ActualTitle = incorrectNumber();
		String ExpectedTitle = InvalidNumberExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	public void assertValidNumberWithWrongOTP() {
		String ActualTitle = incorrectOTP();
		String ExpectedTitle = ValidNumberWithWrongOTPExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

}
