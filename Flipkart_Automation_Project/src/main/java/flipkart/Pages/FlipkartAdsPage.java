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

public class FlipkartAdsPage extends BasePage {
	
	public WebDriver driver;
	public String InvalidEmail = excelFile.getCellData(6, 4);
	public String InvalidPassword = excelFile.getCellData(6, 5);
	public String ValidEmail = excelFile.getCellData(7, 4);
	public String ValidPassword = excelFile.getCellData(7, 5);
	public String InvalidLoginExpectedTitle = excelFile.getCellData(6, 8);
	public String ValidLoginExpectedTitle = excelFile.getCellData(7, 8);
	public String LogoutExpectedTitle = excelFile.getCellData(8, 8);

	public FlipkartAdsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Login to your account')]")
	public WebElement txt_flipkartLoginPage;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/input[1]")
	public WebElement input_enterEmail;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/div[1]/input[1]")
	public WebElement input_enterPassword;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Login')]")
	public WebElement btn_login;
	
	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[3]/div[1]/span[2]")
	public WebElement txt_emailAddress;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Invalid credentials')]")
	public WebElement txt_ErrLogin;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Log Out')]")
	public WebElement txt_logout;
	
	public void enterEmail(String email) {
		input_enterEmail.sendKeys(email);
	}
	
	public void enterPassword(String pwd) {
		input_enterPassword.sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		btn_login.click();
	}
	
	public void clickOnEmailAddress() {
		txt_emailAddress.click();
	}
	
	public void logout() {
		txt_logout.click();
	}
	
	public String errorOnLogin() {
		return txt_ErrLogin.getText();
	}
	
	public String loginScreenText() {
		return txt_flipkartLoginPage.getText();
	}
	
	public void waitForPopup() {
		String ErrLogin = "//div[contains(text(),'Invalid credentials')]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ErrLogin)));
	}
	
	public void assertInvalidLogin() {
		String ActualTitle = errorOnLogin();
		String ExpectedTitle = InvalidLoginExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	public void assertValidLogin() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = ValidLoginExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	public void assertLogout() {
		String ActualTitle = loginScreenText();
		String ExpectedTitle = LogoutExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
}
