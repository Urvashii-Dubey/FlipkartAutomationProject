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

public class BecomeASellerPage extends BasePage{

	public WebDriver driver;
	public String Number= excelFile.getCellData(5, 2);
	public String OTP = excelFile.getCellData(5, 3);
	public String Email = excelFile.getCellData(5, 4);
	public String GSTIN = excelFile.getCellData(5, 6);
	public String AfterRegisterExpectedText = excelFile.getCellData(5, 8);
	public String ServicesExpectedText = excelFile.getCellData(20, 8);

	public BecomeASellerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]/span[1]")
	public WebElement btn_startSelling;

	@FindBy(how = How.XPATH, using = "//body/div[@id='app-container']/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/input[1]") 
	public WebElement txt_enterNumber ;
	 
	@FindBy(how = How.XPATH, using = "//body/div[@id='app-container']/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]")
	public WebElement txt_enterOTP;
	 
	@FindBy(how = How.XPATH, using = "//body/div[@id='app-container']/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/input[1]")
	public WebElement txt_enterEmail;

	@FindBy(how = How.XPATH, using = "//body/div[@id='app-container']/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/input[1]")
	public WebElement txt_entreGSTIN;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Register & Continue')]")
	public WebElement btn_registerAndContinue;
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Please verify your mobile number through OTP befor')]")
	public WebElement txt_incorrectOTP;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flipkart would like to send you notifications so y')]")
	public WebElement popup_waitForPopup;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='app']/div[1]/div[1]/div[1]/ul[1]/li[2]")
	public WebElement link_services;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Services')]")
	public WebElement txt_openServices;
	
	@FindBy(how = How.XPATH, using = "//button[@id='moe-dontallow_button']")
	public WebElement popup_notAllow;

	public void startSelling() {
		btn_startSelling.click();
	}
	
	public void enterNumber(String number) {
		txt_enterNumber.sendKeys(number);
	}
	
	public void enterEmail(String email) {
		txt_enterEmail.sendKeys(email);
	}
	
	public void enterOTP(String OTP) {
		txt_enterOTP.sendKeys(OTP);
	}
	
	public void enterGSTIN(String GSTIN) {
		txt_entreGSTIN.sendKeys(GSTIN);
	}
	
	public void registerAndContinueButton() {
		btn_registerAndContinue.click();
	}
	
	public String incorrectOTP() {
		return txt_incorrectOTP.getText();
	}
	
	public void closePopUp() {
		popup_notAllow.click();
	}
	
	public void waitForPopup() {
		String waitForPopup = "//button[@id='moe-dontallow_button']";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(waitForPopup)));
	}

	public void clickOnServicesLink() {
		link_services.click();
	}
	
	public String OpenServicesPage() {
		return  txt_openServices.getText();
	}
	
	public void assertSellerServices() {
		String ActualTitle = OpenServicesPage();
		String ExpectedTitle =  ServicesExpectedText;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	public void assertBecomeASeller() {
		String ActualTitle = incorrectOTP();
		String ExpectedTitle =  AfterRegisterExpectedText;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
}
