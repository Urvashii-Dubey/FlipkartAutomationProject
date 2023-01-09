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

public class FlipkartCareerPage extends BasePage {

	public WebDriver driver;
	public String EnggExpectedTitle = excelFile.getCellData(4, 8);

	public FlipkartCareerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@id='candidate-login-before']")
	WebElement link_candidateLogin;

	@FindBy(how = How.XPATH, using = "//header/nav[@id='main-navbar']/div[1]/div[2]/ul[1]/li[5]/a[1]")
	public WebElement link_interviewAtFlipkart;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Engineering')]")
	public WebElement link_engineering;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Engineering at Flipkart')]")
	public WebElement heading_enggAtFlipkart;

	public WebElement candidateLogin() {
		return link_candidateLogin;
	}

	public void clickOnEngineering() {
		link_engineering.click();
	}

	public void clickInterviewAtFLipkart() {
		link_interviewAtFlipkart.click();
	}
	
	public void waitForCareerPageLoad() {
		String candidateLogin = "//a[@id='candidate-login-before']";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(candidateLogin)));
	}
	
	public void assertCareerPage() throws Exception {
		Assert.assertTrue(link_candidateLogin.isDisplayed());
	}

	public void assertCareerEngineering() {
		String ActualTitle = heading_enggAtFlipkart.getText();
		String ExpectedTitle = EnggExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

}
