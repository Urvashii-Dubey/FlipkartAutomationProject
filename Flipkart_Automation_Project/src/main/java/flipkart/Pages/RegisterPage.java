package flipkart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPage extends BasePage {

	public WebDriver driver;
	public String RegisterExpectedTitle = excelFile.getCellData(3, 8);

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'New to Flipkart? Create an account')]")
	WebElement link_register;

	@FindBy(how = How.XPATH, using = "//input[@class='_2IX_2- VJZDxU']")
	public WebElement txt_mobileNumber;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'CONTINUE')]")
	public WebElement btn_continue;

	@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/input[1]")
	public WebElement txt_OTPNumber;

	@FindBy(how = How.XPATH, using = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")
	public WebElement btn_signUp;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Please enter valid OTP')]")
	public WebElement txt_incorrectOTP;

	public void goToregisterLink() {

		link_register.click();
	}

	public void enterMobileNumber(String number) {

		txt_mobileNumber.sendKeys(number);
	}

	public void clickContinue() {

		btn_continue.click();
	}

	public void enterOTP(String OTP) {

		txt_OTPNumber.sendKeys(OTP);
	}

	public String incorrectOTP() {

		return txt_incorrectOTP.getText();
	}

	public void signUp() {

		btn_signUp.click();
	}

	public void assertRegistration() {
		String ActualTitle = incorrectOTP();
		String ExpectedTitle = RegisterExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

}
