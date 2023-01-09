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

public class CustomerCarePage extends BasePage {

	public WebDriver driver;
	public String CustomerCareExpectedTitle = excelFile.getCellData(17, 8);
	public String HelpIssuesExpectedTitle = excelFile.getCellData(18, 8);
	public String SuperCoinsExpectedTitle = excelFile.getCellData(19, 8);

	public CustomerCarePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Flipkart Help Center | 24x7 Customer Care Support')]")
	public WebElement txt_header;

	@FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[1]")
	public WebElement txt_topHeading;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Help with your issues')]")
	public WebElement link_helpWithIssues;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Help Centre')]")
	public WebElement txt_openIssues;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[14]/div[1]/span[1]")
	public WebElement txt_superCoins;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'SuperCoins')]")
	public WebElement txt_openedSuperCoins;

	public String customerCareHeader() {
		return txt_header.getText();
	}
	
	public String helpWithyourIssues() {
		return txt_openIssues.getText();
	}

	public void clickHelpWithIssues() {
		link_helpWithIssues.click();
	}

	public void clickSuperCoins() {
		txt_superCoins.click();
	}
	
	public String viewSuperCoins() {
		return txt_openedSuperCoins.getText();
	}
	
	public void waitForCusCarePageLoad() {
		String topHeading = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[1]";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(topHeading)));
	}
	
	public void assertCustomerCare() {
		Assert.assertTrue(txt_header.isDisplayed());
	}

	public void assertHelpWithIssues() {
		String ActualTitle = helpWithyourIssues();
		String ExpectedTitle = HelpIssuesExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	public void assertSuperCoinsHelpCentre() {
		String ActualTitle = viewSuperCoins();
		String ExpectedTitle = SuperCoinsExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

}
