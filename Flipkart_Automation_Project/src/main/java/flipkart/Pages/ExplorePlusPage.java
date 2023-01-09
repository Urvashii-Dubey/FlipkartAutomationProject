package flipkart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import flipkart.Utilities.ExplicitWaitManager;

public class ExplorePlusPage extends BasePage{

	public WebDriver driver;
	public String explorePlusExpectedText = excelFile.getCellData(16, 8);

	public ExplorePlusPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForFlipkartPlusTitle() {
		ExplicitWaitManager.waitForTitle(driver, explorePlusExpectedText, 20);
	}
	
	public void explorePlusAssertion() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle =  explorePlusExpectedText;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
}

