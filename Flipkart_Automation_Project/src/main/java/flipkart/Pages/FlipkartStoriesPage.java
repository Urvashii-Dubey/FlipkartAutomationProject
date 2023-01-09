package flipkart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import flipkart.Utilities.ExplicitWaitManager;

public class FlipkartStoriesPage extends BasePage{

	public WebDriver driver;
	public String StorieExpectedTitle = excelFile.getCellData(15, 8);

	public FlipkartStoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//header/div[@id='ast-desktop-header']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/a[1]/img[1]")
	public WebElement logo_flipkartStories;

	public void waitForPresenceOfElement() {
		ExplicitWaitManager.waitForElementToBeClickable(driver, logo_flipkartStories, 20);
	}

	public void assertFlipkartStories() {
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = StorieExpectedTitle;
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

}
